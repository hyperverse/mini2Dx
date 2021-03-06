/**
 * Copyright (c) 2016 See AUTHORS file
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

import org.mini2Dx.core.graphics.NinePatch;
import org.mini2Dx.core.serialization.annotation.Field;
import org.mini2Dx.ui.element.Column;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * Extends {@link StyleRule} for {@link Column} styling
 */
public class ColumnStyleRule extends StyleRule {
	@Field(optional=true)
	private String background;
	@Field(optional=true)
	private int ninePatchTop, ninePatchBottom, ninePatchLeft, ninePatchRight;
	
	private NinePatch backgroundNinePatch;
	
	@Override
	public void validate(UiTheme theme) {
	}
	
	@Override
	public void loadDependencies(UiTheme theme, Array<AssetDescriptor> dependencies) {
		if(background != null) {
			dependencies.add(new AssetDescriptor<Texture>(background, Texture.class));
		}
	}
	
	@Override
	public void prepareAssets(UiTheme theme, FileHandleResolver fileHandleResolver, AssetManager assetManager) {
		if(background != null) {
			backgroundNinePatch = new NinePatch(assetManager.get(background, Texture.class), getNinePatchLeft(),
					getNinePatchRight(), getNinePatchTop(), getNinePatchBottom());
		}
	}

	public NinePatch getBackgroundNinePatch() {
		return backgroundNinePatch;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public int getNinePatchTop() {
		if(ninePatchTop <= 0) {
			return getPaddingTop();
		}
		return ninePatchTop;
	}

	public int getNinePatchBottom() {
		if(ninePatchBottom <= 0) {
			return getPaddingBottom();
		}
		return ninePatchBottom;
	}

	public int getNinePatchLeft() {
		if(ninePatchLeft <= 0) {
			return getPaddingLeft();
		}
		return ninePatchLeft;
	}

	public int getNinePatchRight() {
		if(ninePatchRight <= 0) {
			return getPaddingRight();
		}
		return ninePatchRight;
	}
}
