/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class IdAllocator {
	private static final String ID_PREFIX = "ui-element-";
	private static final AtomicInteger NEXT_ID = new AtomicInteger();
	
	public static String getNextId() {
		return ID_PREFIX + NEXT_ID.incrementAndGet();
	}
}
