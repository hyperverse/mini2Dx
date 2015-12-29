/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.ui.element.Image;
import org.mini2Dx.ui.layout.LayoutState;

/**
 *
 */
public class ImageRenderNode extends RenderNode<Image> {

	public ImageRenderNode(ParentRenderNode<?> parent, Image element) {
		super(parent, element);
	}

	@Override
	protected float determinePreferredWidth(LayoutState layoutState) {
		return layoutState.getParentWidth();
	}

	@Override
	protected float determinePreferredHeight(LayoutState layoutState) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected float determineXOffset(LayoutState layoutState) {
		return 0f;
	}

	@Override
	protected float determineYOffset(LayoutState layoutState) {
		return 0f;
	}

}
