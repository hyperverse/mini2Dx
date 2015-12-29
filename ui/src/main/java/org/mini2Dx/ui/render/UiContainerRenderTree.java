/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.game.GameResizeListener;
import org.mini2Dx.ui.UiContainer;
import org.mini2Dx.ui.layout.LayoutState;
import org.mini2Dx.ui.layout.ScreenSize;

/**
 *
 */
public class UiContainerRenderTree extends ParentRenderNode<UiContainer> implements GameResizeListener {
	private final GameContainer gc;
	
	private ScreenSize currentScreenSize = ScreenSize.XS;

	public UiContainerRenderTree(UiContainer uiContainer, GameContainer gc) {
		super(null, uiContainer);
		this.gc = gc;
		gc.addResizeListener(this);
		onResize(gc.getWidth(), gc.getHeight());
	}
	
	public void layout() {
		layout(new LayoutState(currentScreenSize, 12, gc.getWidth()));
	}
	
	@Override
	public void layout(LayoutState layoutState) {
		if(!isDirty()) {
			return;
		}
		preferredWidth = determinePreferredWidth(layoutState);
		preferredHeight = determinePreferredHeight(layoutState);
		xOffset = determineXOffset(layoutState);
		yOffset = determineYOffset(layoutState);
		
		for (int i = 0; i < children.size(); i++) {
			RenderNode<?> node = children.get(i);
			node.layout(layoutState);
			if(!node.isIncludedInLayout()) {
				continue;
			}
			
			node.setRelativeX(node.getXOffset());
			node.setRelativeY(node.getYOffset());
		}
		
		setDirty(false);
	}

	@Override
	public void onResize(int width, int height) {
		ScreenSize screenSize = ScreenSize.XS;
		if(width >= ScreenSize.SM.getMinSize()) {
			screenSize = ScreenSize.SM;
		}
		if(width >= ScreenSize.MD.getMinSize()) {
			screenSize = ScreenSize.MD;
		}
		if(width >= ScreenSize.LG.getMinSize()) {
			screenSize = ScreenSize.LG;
		}
		if(width >= ScreenSize.XL.getMinSize()) {
			screenSize = ScreenSize.XL;
		}
		if(screenSize != currentScreenSize) {
			setDirty(true);
		}
		this.currentScreenSize = screenSize;
	}
	
	@Override
	protected float determinePreferredWidth(LayoutState layoutState) {
		return gc.getWidth();
	}
	
	@Override
	protected float determinePreferredHeight(LayoutState layoutState) {
		return gc.getHeight();
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
