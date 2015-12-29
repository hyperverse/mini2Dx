/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.element;

/**
 * The visibility mode for a {@link UiElement}
 */
public enum Visibility {
	/**
	 * Element will be included in layout and rendering
	 */
	VISIBLE,
	/**
	 * Element will be excluded from layout and rendering
	 */
	HIDDEN,
	/**
	 * Element will be included in layout but not rendered
	 */
	NO_RENDER
}
