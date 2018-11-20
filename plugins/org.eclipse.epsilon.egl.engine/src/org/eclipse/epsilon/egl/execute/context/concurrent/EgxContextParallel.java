/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.execute.context.concurrent;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.execute.context.EgxModuleTemplateAdapter;
import org.eclipse.epsilon.erl.execute.context.concurrent.ErlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxContextParallel extends ErlContextParallel implements IEgxContextParallel {

	protected EgxModuleTemplateAdapter baseTemplate;
	protected EglTemplateFactory templateFactory;
	
	public EgxContextParallel() {
		this(null);
	}
	
	public EgxContextParallel(EglTemplateFactory templateFactory) {
		this(templateFactory, 0);
	}
	
	public EgxContextParallel(EglTemplateFactory templateFactory, int parallelism) {
		super(parallelism);
		this.templateFactory = templateFactory != null ? templateFactory :
			new EglTemplateFactory(new EglContextParallel(getParallelism()));
	}

	public EgxContextParallel(int parallelism) {
		super(parallelism);
	}

	@Override
	public EgxModuleTemplateAdapter getTrace() {
		if (baseTemplate == null) {
			baseTemplate = new EgxModuleTemplateAdapter(getModule());
		}
		return baseTemplate;
	}
	
	@Override
	public void setBaseTemplate(EgxModuleTemplateAdapter baseTemplate) {
		this.baseTemplate = baseTemplate;
	}
	
	@Override
	public void setTemplateFactory(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
	}

	@Override
	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}
	
	@Override
	public IEgxModule getModule() {
		return (IEgxModule) module;
	}
}
