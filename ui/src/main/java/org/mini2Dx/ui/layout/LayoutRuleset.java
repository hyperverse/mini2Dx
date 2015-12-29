/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.layout;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LayoutRuleset {
	public static final LayoutRuleset DEFAULT_RULESET = new LayoutRuleset("xs-12");
	
	private final Map<ScreenSize, SizeRule> sizeRules = new HashMap<ScreenSize, SizeRule>();
	private final Map<ScreenSize, OffsetRule> offsetRules = new HashMap<ScreenSize, OffsetRule>();

	public LayoutRuleset(String rules) {
		String[] rule = rules.split(" ");
		for (int i = 0; i < rule.length; i++) {
			String[] ruleDetails = rule[i].split("-");
			switch (ruleDetails.length) {
			case 1:
				break;
			case 2:
				storeWidthRule(ruleDetails);
				break;
			case 3:
				storeOffsetRule(ruleDetails);
				break;
			}
		}
	}

	private void storeWidthRule(String[] ruleDetails) {
		ScreenSize screenSize = ScreenSize.fromString(ruleDetails[0]);
		sizeRules.put(screenSize, new SizeRule(Integer.parseInt(ruleDetails[1])));
	}

	private void storeOffsetRule(String[] ruleDetails) {
		ScreenSize screenSize = ScreenSize.fromString(ruleDetails[0]);
		offsetRules.put(screenSize, new OffsetRule(Integer.parseInt(ruleDetails[2])));
	}

	public float getPreferredWidth(LayoutState layoutState) {
		return layoutState.getColumnWidth() * sizeRules.get(layoutState.getScreenSize()).getColumns();
	}
	
	public float getXOffset(LayoutState layoutState) {
		return layoutState.getColumnWidth() * offsetRules.get(layoutState.getScreenSize()).getColumns();
	}
}
