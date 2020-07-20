/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.transformers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.picto.PictoView;
import org.eclipse.epsilon.picto.ViewContent;

public class GraphvizContentTransformer implements ViewContentTransformer {
	
	@Override
	public boolean canTransform(ViewContent content) {
		return content.getFormat().toLowerCase().startsWith("graphviz-");
	}

	@Override
	public ViewContent transform(ViewContent content, PictoView pictoView) throws Exception {
		String[] parts = content.getFormat().split("-");
		String program = parts[1].trim();
		ExternalContentTransformation ect = graphvizToImageImpl(program, content.getText(), "svg");
		String text = new String(ect.call());
		String format = ect.getOutputFile().toFile().exists() ? "svg" : "exception";
		return new ViewContent(format, text, content);
	}
	
	@Override
	public String getLabel(ViewContent content) {
		return "Graphviz";
	}
	
	
	public static String graphvizToSvg(String program, String graphviz) throws IOException {
		return new String(graphvizToImageImpl(program, graphviz, "svg").call());
	}
	
	public static Path graphvizToImage(String program, String graphviz, String imageType) throws IOException {
		ExternalContentTransformation ect = graphvizToImageImpl(program, graphviz, imageType);
		ect.call();
		return ect.getOutputFile();
	}
	
	protected static ExternalContentTransformation graphvizToImageImpl(String program, String graphviz, String imageType) throws IOException {
		Path
			temp = ExternalContentTransformation.createTempFile(null, null),
			image = ExternalContentTransformation.createTempFile(imageType, null);
	
		Files.write(temp, graphviz.getBytes());
		
		if (OperatingSystem.isMac()) {
			program = "/usr/local/bin/" + program;
		}
		else if (OperatingSystem.isUnix()) {
			program = "/usr/bin/" + program;
		}
		
		return new ExternalContentTransformation(
			image, program,
			image, "-T" + imageType, temp, "-o", image
		);
	}
}
