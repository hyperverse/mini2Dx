/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

/**
 *
 */
public class TextBox {
	private String value = "";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		if(value == null) {
			return;
		}
		this.value = value;
	}
}
