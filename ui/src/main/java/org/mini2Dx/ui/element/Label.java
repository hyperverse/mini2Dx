/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.ui.render.LabelRenderNode;
import org.mini2Dx.ui.render.ParentRenderNode;

/**
 *
 */
public class Label extends UiElement {
	private LabelRenderNode renderNode;
	private String text = "";
	
	public Label() {
		this(null);
	}
	
	public Label(String id) {
		super(id);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if(text == null) {
			return;
		}
		this.text = text;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}

	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new LabelRenderNode(parentRenderNode, this);
		parentRenderNode.addChild(renderNode);
	}

	@Override
	public void detach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode == null) {
			return;
		}
		parentRenderNode.removeChild(renderNode);
	}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
}
