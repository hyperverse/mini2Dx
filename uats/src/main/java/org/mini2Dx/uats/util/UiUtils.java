/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.uats.util;

import org.mini2Dx.ui.element.Button;
import org.mini2Dx.ui.element.Label;
import org.mini2Dx.ui.element.Row;
import org.mini2Dx.ui.element.Select;
import org.mini2Dx.ui.element.TextBox;
import org.mini2Dx.ui.element.TextButton;
import org.mini2Dx.ui.listener.ActionListener;

import com.badlogic.gdx.graphics.Color;

/**
 *
 */
public class UiUtils {

	public static Label createHeader(String text) {
		return createLabel(text, "xs-0", "xs-12", Label.COLOR_BLACK);
	}
	
	public static Label createLabel(String text, String xRules, String widthRules) {
		return createLabel(text, xRules, widthRules, Label.COLOR_BLACK);
	}

	private static Label createLabel(String text, Color color) {
		Label label = new Label();
		label.setText(text);
		return label;
	}

	public static TextButton createButton(String text, ActionListener listener) {
		TextButton button = new TextButton();
		button.setText(text);
		button.addActionListener(listener);
		return button;
	}
	
	public static TextBox createTextBox(ActionListener listener) {
		TextBox textBox = new TextBox();
		textBox.addActionListener(listener);
		return textBox;
	}
	
	public static Select<String> createSelect(ActionListener listener) {
		Select<String> select = new Select<String>();
		select.setXRules(xRules);
		select.setWidthRules(widthRules);
		select.addActionListener(listener);
		return select;
	}
}
