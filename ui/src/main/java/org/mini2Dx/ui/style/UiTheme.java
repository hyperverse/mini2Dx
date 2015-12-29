/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.style;

import java.util.Map;

import org.mini2Dx.core.serialization.annotation.Field;
import org.mini2Dx.ui.element.Button;
import org.mini2Dx.ui.element.Column;
import org.mini2Dx.ui.element.Container;
import org.mini2Dx.ui.element.Image;
import org.mini2Dx.ui.element.Label;
import org.mini2Dx.ui.element.Row;
import org.mini2Dx.ui.element.Select;
import org.mini2Dx.ui.element.TextBox;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.layout.ScreenSize;

/**
 *
 */
public class UiTheme {
	public static final String DEFAULT_THEME_FILENAME = "default-mdx-theme.json";
	public static final String DEFAULT_STYLE_ID = "default";
	
	@Field
	private String id;
	@Field
	private Map<String, StyleRuleset> buttons;
	@Field
	private Map<String, StyleRuleset> columns;
	@Field
	private Map<String, StyleRuleset> containers;
	@Field
	private Map<String, StyleRuleset> images;
	@Field
	private Map<String, StyleRuleset> labels;
	@Field
	private Map<String, StyleRuleset> rows;
	@Field
	private Map<String, StyleRuleset> selects;
	@Field
	private Map<String, StyleRuleset> textboxes;
	
	public StyleRule getStyleRule(Button button, ScreenSize screenSize) {
		return getStyleRule(button, screenSize, buttons);
	}
	
	public StyleRule getStyleRule(Column column, ScreenSize screenSize) {
		return getStyleRule(column, screenSize, columns);
	}
	
	public StyleRule getStyleRule(Container container, ScreenSize screenSize) {
		return getStyleRule(container, screenSize, containers);
	}
	
	public StyleRule getStyleRule(Label label, ScreenSize screenSize) {
		return getStyleRule(label, screenSize, labels);
	}
	
	public StyleRule getStyleRule(Image image, ScreenSize screenSize) {
		return getStyleRule(image, screenSize, images);
	}
	
	public StyleRule getStyleRule(Row row, ScreenSize screenSize) {
		return getStyleRule(row, screenSize, rows);
	}
	
	public StyleRule getStyleRule(Select select, ScreenSize screenSize) {
		return getStyleRule(select, screenSize, selects);
	}
	
	public StyleRule getStyleRule(TextBox textbox, ScreenSize screenSize) {
		return getStyleRule(textbox, screenSize, textboxes);
	}
	
	private StyleRule getStyleRule(UiElement element, ScreenSize screenSize, Map<String, StyleRuleset> rules) {
		StyleRuleset ruleset = rules.get(element.getStyleId());
		if(ruleset == null) {
			ruleset = rules.get(DEFAULT_STYLE_ID);
		}
		return ruleset.getStyleRule(screenSize);
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
