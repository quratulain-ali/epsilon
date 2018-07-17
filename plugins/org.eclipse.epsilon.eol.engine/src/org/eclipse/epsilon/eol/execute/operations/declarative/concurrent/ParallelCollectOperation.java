package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.ThreadLocalBatchData;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class ParallelCollectOperation extends CollectOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context_) throws EolRuntimeException {
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		Collection<Object> resultsCol = EolCollectionType.createSameType(source);
		EolExecutorService executor = context.newExecutorService();
		ThreadLocalBatchData<Object> localResults = new ThreadLocalBatchData<>(context.getParallelism());
		
		for (Object item : source) {
			if (iterator.getType() == null || iterator.getType().isKind(item)) {
				executor.execute(() -> {
					
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						new Variable(iterator.getName(), item, iterator.getType(), true)
					);
					
					try {
						localResults.addElement(context.getExecutorFactory().execute(expression, context));
					}
					catch (EolRuntimeException exception) {
						context.handleException(exception, executor);
					}
					
					scope.leaveLocal(expression);
				});
			}
		}
		
		executor.awaitCompletion();
		
		resultsCol.addAll(localResults.getBatch());
		return resultsCol;
	}
	
}
