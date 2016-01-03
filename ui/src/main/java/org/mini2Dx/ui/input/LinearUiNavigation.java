/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.input;

import java.util.HashMap;
import java.util.Map;

import org.mini2Dx.core.controller.button.ControllerButton;
import org.mini2Dx.ui.render.ActionableRenderNode;

import com.badlogic.gdx.Input.Keys;

/**
 *
 */
public class LinearUiNavigation implements UiNavigation {
	private final Map<Integer, ActionableRenderNode> navigation = new HashMap<Integer, ActionableRenderNode>();
	private int cursor;

	@Override
	public void set(int index, ActionableRenderNode actionable) {
		navigation.put(index, actionable);
	}

	@Override
	public ActionableRenderNode navigate(int keycode) {
		switch (keycode) {
		case Keys.UP:
			cursor = cursor > 0 ? cursor - 1 : navigation.size() - 1;
			break;
		case Keys.DOWN:
			cursor = cursor < navigation.size() - 1 ? cursor + 1 : 0;
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
