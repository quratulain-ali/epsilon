/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance.dom;

import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.CollectionLiteralExpression;
import org.eclipse.epsilon.eol.dom.ExpressionStatement;
import org.eclipse.epsilon.eol.dom.FirstOrderOperationCallExpression;
import org.eclipse.epsilon.eol.dom.ForStatement;
import org.eclipse.epsilon.eol.dom.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.IntegerLiteral;
import org.eclipse.epsilon.eol.dom.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.dom.PlusOperatorExpression;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dom.TypeExpression;
import org.eclipse.epsilon.eol.dom.VariableDeclaration;
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.junit.Test;

public class DomTests {
	
	@Test
	public void testDom() throws Exception {
		new StatementBlock (
				/*var a : Integer = 5;*/
				new AssignmentStatement(new VariableDeclaration(new NameExpression("a"), new TypeExpression("Integer"), false), new IntegerLiteral(5)),
				/*if (a < 10) {
					a.println(); // prints 5
				} */
				new IfStatement(new LessThanOperatorExpression(new NameExpression("a"), new IntegerLiteral(10)), 
						new StatementBlock(
								new ExpressionStatement(new OperationCallExpression( new NameExpression("a"), new NameExpression("println"))
							)),
						new StatementBlock()
				),
				/*var b : Integer = 3;*/
				new AssignmentStatement(new VariableDeclaration(new NameExpression("b"), new TypeExpression("Integer"), false), new IntegerLiteral(3)),
				/*
				while (b < a) {
					b = b + 1;
					b.println(); // prints 4 and 5
				}
				*/
				new WhileStatement(new GreaterThanOperatorExpression(new NameExpression("a"), new NameExpression("b")), new StatementBlock(
							new AssignmentStatement(new NameExpression("b"), new PlusOperatorExpression(new NameExpression("b"), new IntegerLiteral(1))),
							new ExpressionStatement(new OperationCallExpression(new NameExpression("b"), new NameExpression("println")))
						)),
				/*var x = Sequence{2..4}.select(x | x > 2);*/
				new AssignmentStatement(new VariableDeclaration(new NameExpression("x"), null, false), 
						new FirstOrderOperationCallExpression(
								new CollectionLiteralExpression<>("Sequence", true, new IntegerLiteral(2), new IntegerLiteral(4)),
								new NameExpression("select"), 
								new Parameter(new NameExpression("x"), null), 
								new GreaterThanOperatorExpression(new NameExpression("x"), new IntegerLiteral(2)))),
				/*
				for (i in x) {
					i.println(); // prints 3.4
				}
				*/
				new ForStatement(
						new Parameter(new NameExpression("i"), null), 
						new NameExpression("x"), 
						new StatementBlock(new ExpressionStatement(new OperationCallExpression(new NameExpression("i"), new NameExpression("println")))))
		).execute(new EolContext());
	}
	
	@Test
	public void testIfStatementNoBracketsChildren() throws Exception {
		EolModule module = new EolModule();
		module.parse("if (true) var a = 0;");
		IfStatement ifStatement = (IfStatement) module.getMain().getStatements().get(0);
		assertTrue(ifStatement.getChildren().get(1) instanceof AssignmentStatement);
	}
	
	@Test
	public void testIfStatementNoBracketsExpressionStatementChild() throws Exception {
		EolModule module = new EolModule();
		module.parse("if (true) 1.println();");
		IfStatement ifStatement = (IfStatement) module.getMain().getStatements().get(0);
		assertTrue(ifStatement.getChildren().get(1) instanceof ExpressionStatement);
	}
	
}
