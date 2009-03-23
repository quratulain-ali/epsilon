/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: SingleClassWithAttributes.java,v 1.2 2008/08/07 12:44:20 louis Exp $
 */
package org.eclipse.epsilon.hutn.generate.model;

import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.*;

import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingleClassWithAttributes extends HutnModelGeneratorTest {

	@BeforeClass
	public static void generateModel() throws HutnGenerationException {
		model = modelGeneratorTest(createSpec("families", createPackageObject(createClassObject("The Smiths", "Family",
		                                                                            createAttributeSlot("name", "The Smiths"),
		                                                                            createAttributeSlot("numberOfChildren", 2)))));
		
		model.setVariable("family", "Family.allInstances().first()");
	}
	
	@Test
	public void modelShouldHaveOneFamily() {
		model.assertEquals(1, "Family.allInstances().size()");
	}
	
	@Test
	public void familyShouldHaveCorrectName() {
		model.assertEquals("The Smiths", "family.name");
	}
	
	@Test
	public void familyShouldHaveCorrectNumberOfChildren() {
		model.assertEquals(2, "family.numberOfChildren");
	}
}
