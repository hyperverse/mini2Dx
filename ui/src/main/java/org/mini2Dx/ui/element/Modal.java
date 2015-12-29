/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.ui.layout.VerticalAlignment;

/**
 *
 */
public class Modal extends Container {
	private VerticalAlignment verticalAlignment = VerticalAlignment.MIDDLE;
	
	public Modal() {
		this(null);
	}
	
	public Modal(String id) {
		super(id);
	}

	public VerticalAlignment getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(VerticalAlignment verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}
}
