/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.ui.render.ImageRenderNode;
import org.mini2Dx.ui.render.ParentRenderNode;

/**
 *
 */
public class Image extends UiElement {
	private ImageRenderNode renderNode;
	private String path;

	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new ImageRenderNode(parentRenderNode, this);
		parentRenderNode.addChild(renderNode);
	}

	@Override
	public void detach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode == null) {
			return;
		}
		parentRenderNode.removeChild(renderNode);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
}
