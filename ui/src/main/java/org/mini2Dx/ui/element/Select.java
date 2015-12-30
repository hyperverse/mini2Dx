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
package org.mini2Dx.ui.element;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.ui.render.ParentRenderNode;
import org.mini2Dx.ui.render.SelectRenderNode;

/**
 *
 */
public class Select<V> extends UiElement {
	private final List<SelectOption<V>> options = new ArrayList<SelectOption<V>>(1);
	
	private SelectRenderNode renderNode;
	private int selectedIndex = 0;
	
	public Select() {
		this(null);
	}
	
	public Select(String id) {
		super(id);
	}

	@Override
	public void attach(ParentRenderNode<?, ?> parentRenderNode) {
		if(renderNode != null) {
			return;
		}
		renderNode = new SelectRenderNode(parentRenderNode, this);
		parentRenderNode.addChild(renderNode);
	}

	@Override
	public void detach(ParentRenderNode<?, ?> parentRenderNode) {
		if(renderNode == null) {
			return;
		}
		parentRenderNode.removeChild(renderNode);
	}
	
	@Override
	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
	
	@Override
	public void setStyleId(String styleId) {
		if(styleId == null) {
			return;
		}
		this.styleId = styleId;
		
		if(renderNode == null) {
			return;
		}
		renderNode.setDirty(true);
	}
	
	@Override
	public void pushEffectsToRenderNode() {
		while(!effects.isEmpty()) {
			renderNode.applyEffect(effects.poll());
		}
	}
	
	public void addOption(String label, V value) {
		options.add(new SelectOption<V>(label, value));
	}
	
	public void removeOption(SelectOption<V> option) {
		options.remove(option);
	}
	
	public void removeOptionByLabel(String label) {
		for(int i = 0; i < options.size(); i++) {
			if(options.get(i).getLabel().equals(label)) {
				options.remove(i);
				return;
			}
		}
	}
	
	public void removeOptionByValue(V value) {
		for(int i = 0; i < options.size(); i++) {
			if(options.get(i).getValue().equals(value)) {
				options.remove(i);
				return;
			}
		}
	}
	
	public SelectOption<V> getSelectedOption() {
		return options.get(selectedIndex);
	}
	
	public V getSelectedValue() {
		return options.get(selectedIndex).getValue();
	}
	
	public int getTotalOptions() {
		return options.size();
	}
	
	public int getSelectedIndex() {
		return selectedIndex;
	}
}
