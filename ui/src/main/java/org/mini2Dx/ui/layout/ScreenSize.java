/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.layout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public enum ScreenSize {
	XS(0),
	SM(768),
	MD(992),
	LG(1200),
	XL(1600);
	
	private static final List<ScreenSize> smallestToLargest = new ArrayList<ScreenSize>() {
		{
			add(XS);
			add(SM);
			add(MD);
			add(LG);
			add(XL);
		}
	};
	private static final List<ScreenSize> largestToSmallest = new ArrayList<ScreenSize>() {
		{
			add(XL);
			add(LG);
			add(MD);
			add(SM);
			add(XS);
		}
	};
	
	private final int minSize;
	
	private ScreenSize(int minSize) {
		this.minSize = minSize;
	}

	public int getMinSize() {
		return minSize;
	}
	
	public static Iterator<ScreenSize> smallestToLargest() {
		return smallestToLargest.iterator();
	}
	
	public static Iterator<ScreenSize> largestToSmallest() {
		return largestToSmallest.iterator();
	}
	
	public static ScreenSize fromString(String value) {
		switch(value.toLowerCase()) {
		case "xs":
			return ScreenSize.XS;
		case "sm":
			return ScreenSize.SM;
		case "md":
			return ScreenSize.MD;
		case "lg":
			return ScreenSize.LG;
		case "xl":
			return ScreenSize.XL;
		}
		return ScreenSize.XS;
	}
}
