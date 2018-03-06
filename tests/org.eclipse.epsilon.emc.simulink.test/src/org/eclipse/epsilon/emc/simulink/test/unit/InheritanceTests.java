package org.eclipse.epsilon.emc.simulink.test.unit;

import org.eclipse.epsilon.emc.simulink.test.util.AbstractSimulinkTest;
import org.junit.Test;

public class InheritanceTests extends AbstractSimulinkTest {
	
	// MODEL
	
	@Test
	public void testModelChildren() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var result = M.children; "
				+ "assert(result.size() = 1); "
				+ "assert(result.includes(chart));";
	}
	
	@Test
	public void testModelFindBlocks() {
		eol = "var chart = new `sflib/Chart`; "
				+ "var result = M.findBlocks(); "
				+ "assert(result.size() = 1); "
				+ "assert(result.includes(chart)); ";
	}
	
	// CHART PARENT
	
	@Test
	public void testChartStateflowConstParent() {
		eol = "var parentSim = new `sflib/Chart`; "
				+ "var parent = `Stateflow.Chart`.all.first(); "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testChartStateflowAttrParent() {
		eol = "var parentSim = new `sflib/Chart`; "
				+ "var parent = `Stateflow.Chart`.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testChartStateflowAddParent() {
		eol = "var parentSim = new `sflib/Chart`; "
				+ "var parent = `Stateflow.Chart`.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testStateflowConstChartChildren() {
		eol = "var parentSim = new `sflib/Chart`; "
				+ "var parent = `Stateflow.Chart`.all.first(); "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(parent.getChildren().size() = 1);"
				+ "assert(parent.children.size() = 1); "
				+ "assert(parent.children.includes(sA); "
				+ "assert(parent.getChildren().includes(sA); ";
	}
	
	@Test
	public void testStateflowAttrChartChildren() {
		eol = "var parentSim = new `sflib/Chart`; "
				+ "var parent = `Stateflow.Chart`.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(parent.getChildren().size() = 1);"
				+ "assert(parent.children.size() = 1); "
				+ "assert(parent.children.includes(sA); "
				+ "assert(parent.getChildren().includes(sA); ";
	}
	
	@Test
	public void testAddStateflowChartChildren() {
		eol = "var parentSim = new `sflib/Chart`; "
				+ "var parent = `Stateflow.Chart`.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(parent.getChildren().size() = 1);"
				+ "assert(parent.children.size() = 1); "
				+ "assert(parent.children.includes(sA); "
				+ "assert(parent.getChildren().includes(sA); ";
	}
	
	// STATEFLOW PARENT
	
	@Test
	public void testSfStateflowConstParent() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testSfStateflowAttrParent() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testSfStateflowAddParent() { // OK
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(sA.parent = parent);";
	}
	
	@Test
	public void testStateflowConstSfChildren() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`(parent); "
				+ "assert(parent.getChildren().size() = 1);"
				+ "assert(parent.children.size() = 1); "
				+ "assert(parent.children.includes(sA); "
				+ "assert(parent.getChildren().includes(sA); ";
	}
	
	@Test
	public void testStateflowAttrSfChildren() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "sA.parent = parent; "
				+ "assert(parent.getChildren().size() = 1);"
				+ "assert(parent.children.size() = 1); "
				+ "assert(parent.children.includes(sA); "
				+ "assert(parent.getChildren().includes(sA); ";
	}
	
	@Test
	public void testAddStateflowSfChildren() {
		eol = "var function = new `simulink/User-Defined Functions/MATLAB Function`;"
				+ "var parent = EMChart.all.first(); "
				+ "var sA = new `Stateflow.State`; "
				+ "parent.add(sA); "
				+ "assert(parent.getChildren().size() = 1);"
				+ "assert(parent.children.size() = 1); "
				+ "assert(parent.children.includes(sA); "
				+ "assert(parent.getChildren().includes(sA); ";
	}
	
}
