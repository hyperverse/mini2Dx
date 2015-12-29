/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.ui.element.Container;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.element.Visibility;
import org.mini2Dx.ui.render.ParentRenderNode;
import org.mini2Dx.ui.render.UiContainerRenderTree;

/**
 *
 */
public class UiContainer extends UiElement {
	private final List<Container> children = new ArrayList<Container>(1);
	private final UiContainerRenderTree renderTree;
	
	public UiContainer(GameContainer gc) {
		renderTree = new UiContainerRenderTree(this, gc);
	}
	
	public void update(float delta) {
		if(renderTree.isDirty()) {
			renderTree.layout();
		}
		renderTree.update(delta);
	}
	
	public void interpolate(float alpha) {
		renderTree.interpolate(alpha);
	}
	
	public void render(Graphics g) {
		switch (visibility) {
		case HIDDEN:
			return;
		case NO_RENDER:
			return;
		default:
			renderTree.render(g);
			break;
		}
	}
	
	public void addChild(Container container) {
		container.attach(renderTree);
		children.add(container);
	}

	public void removeChild(Container container) {
		children.remove(container);
		container.detach(renderTree);
	}
	
	@Override
	public void attach(ParentRenderNode<?> parentRenderNode) {}

	@Override
	public void detach(ParentRenderNode<?> parentRenderNode) {}
	
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}
}
