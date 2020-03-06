/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance;

import org.eclipse.epsilon.egx.engine.test.acceptance.equivalence.EgxModuleEquivalenceTests;
import org.eclipse.epsilon.egx.engine.test.acceptance.operations.*;
import org.eclipse.epsilon.egx.engine.test.acceptance.parse.GenerationRuleConstructsTests;
import org.eclipse.epsilon.egx.engine.test.acceptance.rules.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

@RunWith(Suite.class)
@SuiteClasses({
	Rule.class,
	RulesAreTyped.class,
	DomainTests.class,
	IncludeTests.class,
	GenerationRuleConstructsTests.class,
	EgxModuleEquivalenceTests.class
})
public class EgxAcceptanceTestSuite {

	public static Test suite() {
		return new JUnit4TestAdapter(EgxAcceptanceTestSuite.class);
	}
}
