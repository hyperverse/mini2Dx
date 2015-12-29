/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.ui.render.ParentRenderNode;
import org.mini2Dx.ui.render.RowRenderNode;

/**
 *
 */
public class Row extends Column {
	
	public Row() {
		this(null);
	}
	
	public Row(String id) {
		super(id);
	}

	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new RowRenderNode(parentRenderNode, this);
		for(int i = 0; i < children.size(); i++) {
			children.get(i).attach(renderNode);
		}
		parentRenderNode.addChild(renderNode);
	}
}
