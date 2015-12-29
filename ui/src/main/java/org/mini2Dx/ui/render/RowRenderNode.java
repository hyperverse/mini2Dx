/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.ui.element.Row;
import org.mini2Dx.ui.layout.LayoutState;

/**
 *
 */
public class RowRenderNode extends ColumnRenderNode {
	
	public RowRenderNode(ParentRenderNode<?> parent, Row row) {
		super(parent, row);
	}

	@Override
	protected float determinePreferredWidth(LayoutState layoutState) {
		return layoutState.getParentWidth();
	}
}
