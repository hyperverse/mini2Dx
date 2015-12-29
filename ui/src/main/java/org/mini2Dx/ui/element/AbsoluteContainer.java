/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.ui.render.AbsoluteContainerRenderNode;
import org.mini2Dx.ui.render.ParentRenderNode;

/**
 *
 */
public class AbsoluteContainer extends Container {
	private float x, y;
	
	public AbsoluteContainer() {
		this(null);
	}
	
	public AbsoluteContainer(String id) {
		super(id);
	}
	
	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new AbsoluteContainerRenderNode(parentRenderNode, this);
		for(int i = 0; i < children.size(); i++) {
			children.get(i).attach(renderNode);
		}
		parentRenderNode.addChild(renderNode);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
}
