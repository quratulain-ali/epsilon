/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id: UnrecognisedIdentifier.java,v 1.1 2008/08/07 14:51:11 louis Exp $
 */
package org.eclipse.epsilon.hutn.validation.model;

import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.createClassObject;
import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.createPackageObject;
import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.createReferenceSlot;
import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.createSpec;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.exceptions.HutnValidationException;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnrecognisedIdentifier extends HutnModelValidationTest {

	@BeforeClass
	public static void validateModel() throws HutnValidationException {
		problems = modelValidationTest(createSpec("families", createPackageObject(createClassObject("The Smiths",
		                                                                                "Family",
		                                                                                createReferenceSlot("pets", "Fido")))));
	}
	
	@Test
	public void validationShouldReportOneProblem() {
		assertEquals(1, problems.size());
	}
	
	@Test
	public void reasonShouldBeUnrecognisedIdentifier() {
		assertEquals("Unrecognised identifier: Fido", problems.get(0).getReason());
	}
}
