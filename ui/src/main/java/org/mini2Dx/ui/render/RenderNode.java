/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.render;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.ui.effect.UiEffect;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.element.Visibility;
import org.mini2Dx.ui.layout.LayoutState;
import org.mini2Dx.ui.style.StyleRule;

/**
 *
 */
public abstract class RenderNode<T extends UiElement, S extends StyleRule> {
	protected final List<UiEffect> effects = new ArrayList<UiEffect>(1);
	protected final CollisionBox currentPosition = new CollisionBox();
	protected final Rectangle targetPosition = new Rectangle();
	protected final ParentRenderNode<?, ?> parent;
	protected final T element;
	
	protected S style;
	protected float preferredWidth, preferredHeight;
	protected float xOffset, yOffset;
	private float relativeX, relativeY;
	private boolean dirty;
	
	public RenderNode(ParentRenderNode<?, ?> parent, T element) {
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
		
		element.pushEffectsToRenderNode();
		
		for(int i = 0; i < effects.size(); i++) {
			UiEffect effect = effects.get(i);
			if(effect.isFinished()) {
				effects.remove(i);
				i--;
				continue;
			}
			
			effect.update(null, currentPosition, targetPosition, delta);
		}
	}
	
	public void interpolate(float alpha) {
		currentPosition.interpolate(null, alpha);
	}
	
	public void render(Graphics g) {
		if(!isIncludedInRender()) {
			return;
		}
		
		for(int i = 0; i < effects.size(); i++) {
			effects.get(i).preRender(g);
		}
		renderElement(g);
		for(int i = 0; i < effects.size(); i++) {
			effects.get(i).postRender(g);
		}
	}
	
	protected abstract void renderElement(Graphics g);
	
	protected abstract S determineStyleRule(LayoutState layoutState);
	
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
			style = determineStyleRule(layoutState);
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
	
	public boolean isIncludedInRender() {
		return element.getVisibility() == Visibility.VISIBLE;
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
	
	public void applyEffect(UiEffect effect) {
		effects.add(effect);
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
