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
package org.eclipse.epsilon.concordance.clients.xref;

import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;

public class DanglingCrossReferenceUnmarker {

	private final ConcordanceIndex index;
	private final CrossReferenceVisitor visitor = new DanglingCrossReferenceUnmarkingVisitor();
	
	public DanglingCrossReferenceUnmarker(ConcordanceIndex index) {
		this.index = index;
	}

	public void unmarkResolvedCrossReferencesTo(IConcordanceModel model) {
		index.visitAllCrossReferencesWithTarget(model, visitor);
	}
	
	static class DanglingCrossReferenceUnmarkingVisitor implements CrossReferenceVisitor {

		public void visit(CrossReference crossReference) {
			if (!crossReference.isDangling()) {
				new MarkerManager(crossReference.source.getResource()).removeErrorMarker(crossReference);
			}
		}
		
	}
}
