/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.ui.render.ParentRenderNode;
import org.mini2Dx.ui.render.ScrollBoxRenderNode;

/**
 *
 */
public class ScrollBox extends Column {
	private float maxWidth, maxHeight;
	
	public ScrollBox() {
		this(null);
	}
	
	public ScrollBox(String id) {
		super(id);
	}
	
	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new ScrollBoxRenderNode(parentRenderNode, this);
		for(int i = 0; i < children.size(); i++) {
			children.get(i).attach(renderNode);
		}
		parentRenderNode.addChild(renderNode);
	}

	public float getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(float maxWidth) {
		this.maxWidth = maxWidth;
	}

	public float getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(float maxHeight) {
		this.maxHeight = maxHeight;
	}
}
