package org.eclipse.epsilon.erl.execute;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.erl.dom.NamedRule;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

public class RuleExecutorFactory extends ExecutorFactory {

	protected RuleProfiler ruleProfiler;
	
	public RuleExecutorFactory() {
		this(null, false);
	}

	public RuleExecutorFactory(ExecutorFactory parent, boolean concurrent) {
		super(parent, concurrent);
		setRuleProfiler(new RuleProfiler());
		if (base instanceof RuleExecutorFactory) {
			executionListeners.remove(((RuleExecutorFactory) base).getRuleProfiler());
		}
	}
	
	public RuleProfiler getRuleProfiler() {
		return ruleProfiler;
	}
	
	public void setRuleProfiler(RuleProfiler ruleProfiler) {
		if (this.ruleProfiler != null) {
			removeExecutionListener(this.ruleProfiler);
		}
		
		addExecutionListener(this.ruleProfiler = ruleProfiler);
	}
	
	@Override
	public void merge(MergeMode mode) {
		ExecutorFactory from = getFrom(mode), to = getTo(mode);
		
		if (to instanceof RuleExecutorFactory && from instanceof RuleExecutorFactory) {
			((RuleExecutorFactory)to).getRuleProfiler()
				.mergeExecutionTimes(
					((RuleExecutorFactory)from).getRuleProfiler().getExecutionTimes()
				);
		}
		
		super.merge(mode);
	}

	public Object execute(NamedRule namedRule, Object element, IErlContext context) throws EolRuntimeException {
		if (namedRule == null) return null;
		
		preExecute(namedRule, context);
		
		Object result = null;
		
		try {
			result = namedRule.executeImpl(element, context);
			postExecuteSuccess(namedRule, result, context);
		}
		catch (Exception ex) {
			postExecuteFailure(namedRule, ex, context);
		}
		finally {
			postExecuteFinally(namedRule, context);
		}
		
		return result;
	}
	
}
