/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

/**
 *
 */
public class TextButton {
	private String text = "";
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		if(text == null) {
			return;
		}
		this.text = text;
	}
}
