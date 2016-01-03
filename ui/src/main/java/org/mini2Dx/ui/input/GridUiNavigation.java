/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.input;

import org.mini2Dx.core.controller.button.ControllerButton;
import org.mini2Dx.ui.render.ActionableRenderNode;

import com.badlogic.gdx.Input.Keys;

/**
 *
 */
public class GridUiNavigation implements UiNavigation {
	private int cursor;

	@Override
	public void set(int index, ActionableRenderNode actionable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActionableRenderNode navigate(int keycode) {
		switch(keycode) {
		case Keys.UP:
			break;
		case Keys.DOWN:
			break;
		case Keys.LEFT:
			break;
		case Keys.RIGHT:
			break;
		}
		return null;
	}

	@Override
	public ActionableRenderNode navigate(ControllerButton button) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetCursor() {
		cursor = 0;
	}
}