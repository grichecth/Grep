package com.emmz.grich.grep.Gui;

import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class GuiTexture extends GenericTexture {
	
	public GuiTexture(int X, int Y, int W, int H, String URL) {
		super();	  
		this.setUrl(URL);
		this.setWidth(W).setHeight(H).setX(X).setY(Y);
		this.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.setPriority(RenderPriority.Highest);
		this.setDrawAlphaChannel(true);
	}
}
