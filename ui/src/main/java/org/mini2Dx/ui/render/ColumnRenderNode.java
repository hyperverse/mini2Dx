/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.ui.element.Column;
import org.mini2Dx.ui.layout.LayoutState;

/**
 *
 */
public class ColumnRenderNode extends ParentRenderNode<Column> {

	public ColumnRenderNode(ParentRenderNode<?> parent, Column column) {
		super(parent, column);
	}

	@Override
	public void layout(LayoutState layoutState) {
		if (!isDirty()) {
			return;
		}
		float parentWidth = layoutState.getParentWidth();
		xOffset = determineXOffset(layoutState);
		preferredWidth = determinePreferredWidth(layoutState);
		layoutState.setParentWidth(preferredWidth);

		float startX = 0f;
		float startY = 0f;
		for (int i = 0; i < children.size(); i++) {
			RenderNode<?> node = children.get(i);
			node.layout(layoutState);
			if(!node.isIncludedInLayout()) {
				continue;
			}
			
			node.setRelativeX(startX + node.getXOffset());
			node.setRelativeY(startY + node.getYOffset());

			startX += node.getPreferredWidth() + node.getXOffset();
			if (startX >= preferredWidth) {
				float maxHeight = 0f;
				for (int j = i; j >= 0; j--) {
					RenderNode<?> previousNode = children.get(j);
					if (previousNode.getRelativeY() == startY) {
						float height = previousNode.getPreferredHeight() + node.getYOffset();
						if (height > maxHeight) {
							maxHeight = height;
						}
					}
				}
				startY += maxHeight;
			}
		}
		layoutState.setParentWidth(parentWidth);

		yOffset = determineYOffset(layoutState);
		preferredHeight = determinePreferredHeight(layoutState);
		setDirty(false);
		childDirty = false;
	}

	@Override
	protected float determinePreferredHeight(LayoutState layoutState) {
		float maxHeight = 0f;

		for (int i = 0; i < children.size(); i++) {
			float height = children.get(i).getRelativeY() + children.get(i).getPreferredHeight()
					+ children.get(i).getYOffset();
			if (height > maxHeight) {
				maxHeight = height;
			}
		}
		return maxHeight;
	}

	@Override
	protected float determinePreferredWidth(LayoutState layoutState) {
		return element.getLayout().getPreferredWidth(layoutState);
	}

	@Override
	protected float determineXOffset(LayoutState layoutState) {
		return element.getLayout().getXOffset(layoutState);
	}

	@Override
	protected float determineYOffset(LayoutState layoutState) {
		return 0f;
	}
}
