/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.ui.element.ScrollBox;
import org.mini2Dx.ui.layout.LayoutState;

/**
 *
 */
public class ScrollBoxRenderNode extends ColumnRenderNode {
	
	public ScrollBoxRenderNode(ParentRenderNode<?> parent, ScrollBox row) {
		super(parent, row);
	}

	@Override
	protected float determinePreferredWidth(LayoutState layoutState) {
		float result = super.determinePreferredWidth(layoutState);
		
		if(result > ((ScrollBox) element).getMaxWidth()) {
			return ((ScrollBox) element).getMaxWidth();
		}
		return result;
	}
	
	@Override
	protected float determinePreferredHeight(LayoutState layoutState) {
		float result = super.determinePreferredHeight(layoutState);
		
		if(result > ((ScrollBox) element).getMaxHeight()) {
			return ((ScrollBox) element).getMaxHeight();
		}
		return result;
	}
}
