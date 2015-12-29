/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.element.Visibility;
import org.mini2Dx.ui.layout.LayoutState;

/**
 *
 */
public abstract class RenderNode<T extends UiElement> {
	protected final CollisionBox currentPosition = new CollisionBox();
	protected final Rectangle targetPosition = new Rectangle();
	protected final ParentRenderNode<?> parent;
	protected final T element;
	
	protected float preferredWidth, preferredHeight;
	protected float xOffset, yOffset;
	private float relativeX, relativeY;
	private boolean dirty;
	
	public RenderNode(ParentRenderNode<?> parent, T element) {
		this.parent = parent;
		this.element = element;
		setDirty(true);
	}
	
	public void update(float delta) {
		if(parent == null) {
			targetPosition.set(relativeX, relativeY, preferredWidth, preferredHeight);
		} else {
			targetPosition.set(parent.getX() + relativeX, parent.getY() + relativeY, preferredWidth, preferredHeight);
		}
		currentPosition.preUpdate();
		
		
	}
	
	public void interpolate(float alpha) {
		currentPosition.interpolate(null, alpha);
	}
	
	public void render(Graphics g) {
		
	}
	
	protected abstract float determinePreferredWidth(LayoutState layoutState);
	
	protected abstract float determinePreferredHeight(LayoutState layoutState);
	
	protected abstract float determineXOffset(LayoutState layoutState);
	
	protected abstract float determineYOffset(LayoutState layoutState);
	
	public void layout(LayoutState layoutState) {
		if(!isDirty()) {
			return;
		}
		switch(element.getVisibility()) {
		case HIDDEN:
			preferredWidth = 0f;
			preferredHeight = 0f;
			xOffset = 0f;
			yOffset = 0f;
			return;
		default:
			preferredWidth = determinePreferredWidth(layoutState);
			preferredHeight = determinePreferredHeight(layoutState);
			xOffset = determineXOffset(layoutState);
			yOffset = determineYOffset(layoutState);
			break;
		}
		dirty = false;
	}
	
	public boolean isIncludedInLayout() {
		return element.getVisibility() != Visibility.HIDDEN;
	}
	
	public boolean isDirty() {
		return dirty;
	}
	
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
		if(parent == null) {
			return;
		}
		parent.setChildDirty(dirty);
	}

	public float getRelativeX() {
		return relativeX;
	}

	public void setRelativeX(float relativeX) {
		this.relativeX = relativeX;
	}

	public float getRelativeY() {
		return relativeY;
	}

	public void setRelativeY(float relativeY) {
		this.relativeY = relativeY;
	}

	public float getPreferredWidth() {
		return preferredWidth;
	}

	public float getPreferredHeight() {
		return preferredHeight;
	}

	public float getXOffset() {
		return xOffset;
	}

	public float getYOffset() {
		return yOffset;
	}
	
	public float getX() {
		return currentPosition.getX();
	}
	
	public float getY() {
		return currentPosition.getY();
	}
	
	public float getWidth() {
		return currentPosition.getWidth();
	}
	
	public float getHeight() {
		return currentPosition.getHeight();
	}
	
	public int getRenderX() {
		return currentPosition.getRenderX();
	}
	
	public int getRenderY() {
		return currentPosition.getRenderY();
	}
	
	public int getRenderWidth() {
		return currentPosition.getRenderWidth();
	}
	
	public int getRenderHeight() {
		return currentPosition.getRenderHeight();
	}
}
