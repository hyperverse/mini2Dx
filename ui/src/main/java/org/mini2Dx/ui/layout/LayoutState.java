/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.layout;

/**
 *
 */
public class LayoutState {
	private final ScreenSize screenSize;
	private final int totalColumns;
	private float parentWidth;
	private float columnWidth;
	
	public LayoutState(ScreenSize screenSize, int totalColumns, float parentWidth) {
		this.screenSize = screenSize;
		this.totalColumns = totalColumns;
		setParentWidth(parentWidth);
	}

	public float getParentWidth() {
		return parentWidth;
	}

	public void setParentWidth(float parentWidth) {
		this.parentWidth = parentWidth;
		this.columnWidth = parentWidth / totalColumns;
	}

	public ScreenSize getScreenSize() {
		return screenSize;
	}

	public int getTotalColumns() {
		return totalColumns;
	}

	public float getColumnWidth() {
		return columnWidth;
	}
}
