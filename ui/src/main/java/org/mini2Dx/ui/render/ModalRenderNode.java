/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.render;

import java.util.Map;

import org.mini2Dx.core.controller.button.ControllerButton;
import org.mini2Dx.ui.element.Column;
import org.mini2Dx.ui.element.Modal;
import org.mini2Dx.ui.layout.LayoutState;
import org.mini2Dx.ui.style.ContainerStyleRule;

/**
 *
 */
public class ModalRenderNode extends AbstractColumnRenderNode<ContainerStyleRule> {
	private Map<Integer, ActionableRenderNode> keyboardHotkeys;
	private Map<String, ActionableRenderNode> controllerHotkeys;

	public ModalRenderNode(ParentRenderNode<?, ?> parent, Column column) {
		super(parent, column);
	}
	
	public ActionableRenderNode hotkey(int keycode) {
		if(keyboardHotkeys == null) {
			return null;
		}
		return keyboardHotkeys.get(keycode);
	}
	
	public ActionableRenderNode hotkey(ControllerButton controllerButton) {
		if(controllerHotkeys == null) {
			return null;
		}
		return controllerHotkeys.get(controllerButton.getAbsoluteValue());
	}
	
	public ActionableRenderNode navigate(int keycode) {
		return ((Modal) element).getNavigation().navigate(keycode);
	}
	
	public ActionableRenderNode navigate(ControllerButton button) {
		return ((Modal) element).getNavigation().navigate(button);
	}

	@Override
	protected ContainerStyleRule determineStyleRule(LayoutState layoutState) {
		return layoutState.getTheme().getStyleRule(((Modal) element), layoutState.getScreenSize());
	}

}
