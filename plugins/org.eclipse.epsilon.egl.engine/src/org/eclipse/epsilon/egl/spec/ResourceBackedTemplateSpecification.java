/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.spec;

import java.net.URI;

import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.traceability.Template;


class ResourceBackedTemplateSpecification extends EglTemplateSpecification {

	private final URI resource;
	
	protected ResourceBackedTemplateSpecification(String name, URI resource) {
		super(name);
		
		this.resource = resource;
	}

	public Template createTemplate() {
		return new Template(getName(), resource);
	}
	
	public void parseInto(IEglModule module) throws Exception {
		module.parse(resource);
	}	
}
