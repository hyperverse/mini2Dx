/**
 * Copyright 2015 Thomas Cashman
 */
package org.mini2Dx.ui.style;

import org.mini2Dx.core.serialization.annotation.Field;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.utils.Array;

/**
 *
 */
public class TextBoxStyleRule extends StyleRule {
	@Field
	private String normal;
	@Field
	private String hover;
	@Field
	private String action;
	@Field
	private String disabled;
	@Field
	private int fontSize;
	@Field
	private String font;
	
	private NinePatch normalNinePatch, hoverNinePatch, actionNinePatch, disabledNinePatch;
	
	@Override
	public void validate(UiTheme theme) {}
	
	@Override
	public void loadDependencies(UiTheme theme, Array<AssetDescriptor> dependencies) {
		dependencies.add(new AssetDescriptor<Texture>(normal, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(hover, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(action, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(disabled, Texture.class));
	}
	
	@Override
	public void prepareAssets(UiTheme theme, FileHandleResolver fileHandleResolver, AssetManager assetManager) {
		normalNinePatch = new NinePatch(assetManager.get(normal, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		hoverNinePatch = new NinePatch(assetManager.get(hover, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		actionNinePatch = new NinePatch(assetManager.get(action, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		disabledNinePatch = new NinePatch(assetManager.get(disabled, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
	}
	
	public NinePatch getNormalNinePatch() {
		return normalNinePatch;
	}

	public NinePatch getHoverNinePatch() {
		return hoverNinePatch;
	}

	public NinePatch getActionNinePatch() {
		return actionNinePatch;
	}

	public NinePatch getDisabledNinePatch() {
		return disabledNinePatch;
	}
}
