/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import java.util.LinkedList;
import java.util.Queue;

import org.mini2Dx.ui.effect.UiEffect;
import org.mini2Dx.ui.render.ParentRenderNode;
import org.mini2Dx.ui.util.IdAllocator;

/**
 *
 */
public abstract class UiElement {
	private final String id;
	private final Queue<UiEffect> effects = new LinkedList<UiEffect>();
	
	protected Visibility visibility = Visibility.HIDDEN;
	
	public UiElement() {
		this(null);
	}
	
	public UiElement(String id) {
		if(id == null) {
			id = IdAllocator.getNextId();
		}
		this.id = id;
	}
	
	public abstract void attach(ParentRenderNode<?> parentRenderNode);
	
	public abstract void detach(ParentRenderNode<?> parentRenderNode);
	
	public void applyEffect(UiEffect effect) {
		effects.offer(effect);
	}

	public String getId() {
		return id;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public abstract void setVisibility(Visibility visibility);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UiElement other = (UiElement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
