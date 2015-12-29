/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.effect;

import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.ui.UiContainer;

/**
 *
 */
public interface UiEffect {
	public boolean update(UiContainer uiContainer, CollisionBox currentArea, Rectangle targetArea, float delta);
	
	public void preRender(Graphics g);
	
	public void postRender(Graphics g);
	
	public boolean isFinished();
}
