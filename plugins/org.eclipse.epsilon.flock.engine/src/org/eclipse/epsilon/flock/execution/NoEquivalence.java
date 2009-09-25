/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class NoEquivalence implements Equivalence {

	public final ModelElement original;
	
	public NoEquivalence(ModelElement original) {
		if (original == null)
			throw new IllegalArgumentException("original cannot be null");
		
		this.original = original;
	}
	
	public ModelElement getOriginal() {
		return original; 
	}
	
	public void automaticallyPopulateEquivalent() throws FlockRuntimeException {
		// do nothing
	}
	
	public void applyStrategyToPopulateEquivalent() throws FlockRuntimeException {
		// do nothing
	}

	public ModelElement getEquivalent() {
		return null;
	}
	
	@Override
	public String toString() {
		return original + " <-> null";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof NoEquivalence))
			return false;
		
		final NoEquivalence other = (NoEquivalence)obj;
		
		return original.equals(other.original);
	}
	
	@Override
	public int hashCode() {
		return original.hashCode();
	}
}
