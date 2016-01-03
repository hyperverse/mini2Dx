/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.input;

import org.mini2Dx.core.controller.button.ControllerButton;
import org.mini2Dx.ui.render.ActionableRenderNode;

/**
 *
 */
public interface UiNavigation {

	public void resetCursor();
	
	public void set(int index, ActionableRenderNode actionable);
	
	public ActionableRenderNode navigate(int keycode);
	
	public ActionableRenderNode navigate(ControllerButton button);
}
