/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.concurrent;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.execute.context.concurrent.EgxContextParallel;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallel extends EgxModule {

	protected static final Set<String> CONFIG_PROPERTIES = new HashSet<>(2);
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EgxModuleParallel() {
		this(new EgxContextParallel());
	}
	
	public EgxModuleParallel(int parallelism) {
		this(new EgxContextParallel(null, parallelism));
	}
	
	public EgxModuleParallel(IEgxContextParallel egxContext) {
		this.context = egxContext;
		this.invokedTemplates = new ConcurrentLinkedQueue<>();
	}
	
	@Override
	protected void generateRules() throws EolRuntimeException {
		IEgxContextParallel context = getContext();
		EglTemplateFactory templateFactory = context.newTemplateFactory();
		Map<URI, EglTemplate> templateCache = ConcurrencyUtils.concurrentMap();
		
		for (GenerationRule rule : getGenerationRules()) {
			Collection<?> allElements = rule.getAllElements(context);
			ArrayList<Runnable> genJobs = new ArrayList<>(allElements.size());
			
			for (Object element : allElements) {
				genJobs.add(() -> {
					try {
						rule.generate(context, templateFactory, this, element, templateCache);
					}
					catch (EolRuntimeException exception) {
						context.handleException(exception);
					}
				});
			}
			
			context.executeParallel(rule, genJobs);
		}
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		getContext().goParallel();
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		getContext().endParallel();
		super.postExecution();
	}
	
	@Override
	public IEgxContextParallel getContext() {
		return (IEgxContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEgxContextParallel) {
			super.setContext(context);
		}
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		context = IEolContextParallel.configureContext(
			properties,
			threads -> new EgxContextParallel(getContext().getTemplateFactory(), threads),
			getContext()
		);
	}
	
	@Override
	public Set<String> getConfigurationProperties() {
		return CONFIG_PROPERTIES;
	}
}
