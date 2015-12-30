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
public class ContainerStyleRule extends StyleRule {
	@Field
	private String active;
	@Field
	private String inactive;
	
	private NinePatch activeNinePatch, inactiveNinePatch;

	@Override
	public void validate(UiTheme theme) {}
	
	@Override
	public void loadDependencies(UiTheme theme, Array<AssetDescriptor> dependencies) {
		dependencies.add(new AssetDescriptor<Texture>(active, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(inactive, Texture.class));
	}
	
	@Override
	public void prepareAssets(UiTheme theme, FileHandleResolver fileHandleResolver, AssetManager assetManager) {
		activeNinePatch = new NinePatch(assetManager.get(active, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		inactiveNinePatch = new NinePatch(assetManager.get(inactive, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
	}

	public NinePatch getActiveNinePatch() {
		return activeNinePatch;
	}

	public NinePatch getInactiveNinePatch() {
		return inactiveNinePatch;
	}
}
