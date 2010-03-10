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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong;

import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.flock.IFlockModule;
import org.eclipse.epsilon.flock.FlockModule;
import org.eclipse.epsilon.flock.FlockResult;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;

import util.FamiliesModelConstructor;

public abstract class Strong2StrongMigrationAcceptanceTest extends HutnTestWithFamiliesMetaModel {
	
	protected static ModelWithEolAssertions migrated;
	protected static FlockResult result;
	
	protected static void migrateFamiliesToFamilies(String strategy, AbstractEmfModel original) throws Exception {
		final InMemoryEmfModel migratedModel = new InMemoryEmfModel("Migrated", EmfUtil.createResource(), "families");
		migrate(strategy, original, migratedModel);
	}
	
	protected static void migrateFamiliesToFamilies(String strategy, String hutnForOriginalModel) throws Exception {
		final InMemoryEmfModel migratedModel = new InMemoryEmfModel("Migrated", EmfUtil.createResource(), "families");
		migrate(strategy, hutnToFamily(hutnForOriginalModel), migratedModel);
	}
	
	protected static void migrateFamiliesTo(EPackage evolvedMetamodel, String strategy, String hutnForOriginalModel) throws Exception {
		final InMemoryEmfModel migratedModel = new InMemoryEmfModel("Migrated", EmfUtil.createResource(), evolvedMetamodel);
		migrate(strategy, hutnToFamily(hutnForOriginalModel), migratedModel);
	}
	
	private static AbstractEmfModel hutnToFamily(String hutnForOriginalModel) {
		return new FamiliesModelConstructor().constructModel("Original", hutnForOriginalModel);
	}
	
	private static void migrate(String strategy, AbstractEmfModel original, InMemoryEmfModel migratedModel) throws Exception {
		final IFlockModule migrator = new FlockModule();
		
		if (migrator.parse(strategy) && migrator.getParseProblems().isEmpty()) {		
			result = migrator.execute(original, migratedModel);
			
			migrated = new ModelWithEolAssertions(migratedModel);
			
			result.printWarnings(System.err);
			
		} else {
			for (ParseProblem problem : migrator.getParseProblems()) {
				System.err.println(problem);
			}
			fail("Could not parse migration strategy.");
		}
	}
}
