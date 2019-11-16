package org.eclipse.epsilon.picto.source;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.epsilon.picto.PictoMetadata;
import org.eclipse.epsilon.picto.PictoSource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public abstract class SimpleSource implements PictoSource {

	public abstract String getFormat();
	
	public abstract String getFileExtension();
	
	@Override
	public PictoMetadata getRenderingMetadata(IEditorPart editorPart) {
		PictoMetadata metadata = new PictoMetadata();
		metadata.setFile(getFile(editorPart).getLocation().toOSString());
		metadata.setFormat(getFormat());
		return metadata;
	}

	@Override
	public Resource getResource(IEditorPart editorPart) {
		return new ResourceImpl();
	}

	@Override
	public boolean supports(IEditorPart editorPart) {
		IFile file = getFile(editorPart);
		if (file == null) return false;
		return file.getLocation().getFileExtension().equalsIgnoreCase(getFileExtension());
	}

	@Override
	public IFile getFile(IEditorPart editorPart) {
		if (editorPart.getEditorInput() instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput();
			return input.getFile();
		}
		return null;
	}

}
