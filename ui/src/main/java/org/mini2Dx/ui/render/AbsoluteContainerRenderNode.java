/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.ui.element.AbsoluteContainer;
import org.mini2Dx.ui.layout.LayoutState;

/**
 *
 */
public class AbsoluteContainerRenderNode extends ColumnRenderNode {
	
	public AbsoluteContainerRenderNode(ParentRenderNode<?> parent, AbsoluteContainer container) {
		super(parent, container);
	}

	@Override
	protected float determineXOffset(LayoutState layoutState) {
		return ((AbsoluteContainer) element).getX();
	}

	@Override
	protected float determineYOffset(LayoutState layoutState) {
		return ((AbsoluteContainer) element).getY();
	}
}