/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.ui.element.UiElement;

/**
 *
 */
public abstract class ParentRenderNode<T extends UiElement> extends RenderNode<T> {
	protected final List<RenderNode<?>> children = new ArrayList<RenderNode<?>>(1);
	
	protected boolean childDirty = false;

	public ParentRenderNode(ParentRenderNode<?> parent, T element) {
		super(parent, element);
	}
	
	public void addChild(RenderNode<?> child) {
		children.add(child);
		setDirty(true);
	}
	
	public void removeChild(RenderNode<?> child) {
		children.remove(child);
		setDirty(true);
	}
	
	public void clearChildren() {
		children.clear();
		setDirty(true);
	}
	
	@Override
	public boolean isDirty() {
		return childDirty || super.isDirty();
	}
	
	public void setChildDirty(boolean childDirty) {
		if(!childDirty) {
			return;
		}
		this.childDirty = childDirty;
	}
}
