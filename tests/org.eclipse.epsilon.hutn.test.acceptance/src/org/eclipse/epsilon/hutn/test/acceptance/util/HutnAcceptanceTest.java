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
 * $Id: HutnAcceptanceTest.java,v 1.2 2008/08/07 12:44:24 louis Exp $
 */
package org.eclipse.epsilon.hutn.test.acceptance.util;

import static org.junit.Assert.fail;

import java.io.File;

import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.AfterClass;

public abstract class HutnAcceptanceTest extends HutnTestWithFamiliesMetaModel {

	protected static ModelWithEolAssertions model;
	
	protected static ModelWithEolAssertions generateModel(String hutn) throws Exception {
		return generateModel(hutn, null);
	}
	
	protected static ModelWithEolAssertions generateModel(String hutn, String path) throws Exception {
		final IHutnModule module = new HutnModule();
		
		return generateModel(module, module.parse(hutn), path);
	}
	
	protected static ModelWithEolAssertions generateModel(File hutnSource) throws Exception {
		final IHutnModule module = new HutnModule();
		
		return generateModel(module, module.parse(hutnSource), null);
	}

	private static ModelWithEolAssertions generateModel(IHutnModule module, boolean parsedCorrectly, String outputPath) throws Exception, HutnGenerationException {
		if (!parsedCorrectly) {
			for (ParseProblem p : module.getParseProblems()) {
				System.err.println(p);
			}
			fail("Could not parse HUTN.");
		}
		
		final ModelWithEolAssertions result = new ModelWithEolAssertions(module.generateEmfModel());

		if (outputPath != null) {
			result.store(outputPath);
		}
		
		return result;
	}
	
	@AfterClass
	public static void disposeModel() {
		if (model != null) model.dispose();
	}
}
