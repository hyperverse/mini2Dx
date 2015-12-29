/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.ui.layout.LayoutRuleset;
import org.mini2Dx.ui.render.ColumnRenderNode;
import org.mini2Dx.ui.render.ParentRenderNode;

/**
 *
 */
public class Column extends UiElement {
	protected final List<UiElement> children = new ArrayList<UiElement>(1);
	protected ColumnRenderNode renderNode;
	private LayoutRuleset layout = LayoutRuleset.DEFAULT_RULESET;
	
	public Column() {
		this(null);
	}
	
	public Column(String id) {
		super(id);
	}
	
	public void add(UiElement element) {
		children.add(element);
		if(renderNode == null) {
			return;
		}
		element.attach(renderNode);
	}
	
	public boolean remove(UiElement element) {
		if(renderNode != null) {
			element.detach(renderNode);
		}
		return children.remove(element);
	}

	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new ColumnRenderNode(parentRenderNode, this);
		for(int i = 0; i < children.size(); i++) {
			children.get(i).attach(renderNode);
		}
		parentRenderNode.addChild(renderNode);
	}
	
	@Override
	public void detach(ParentRenderNode<?> parentRenderNode) {
		if(renderNode == null) {
			return;
		}
		parentRenderNode.removeChild(renderNode);
	}

	public LayoutRuleset getLayout() {
		return layout;
	}

	public void setLayout(LayoutRuleset layoutRuleset) {
		if(layoutRuleset == null) {
			return;
		}
		this.layout = layoutRuleset;
	}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
}
