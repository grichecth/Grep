package com.emmz.grich.grep.Gui;

import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class GuiLabel extends GenericLabel {

	public GuiLabel(String name, int X, int Y, int W, int H) {
		super();
		this.setWidth(W).setHeight(H).setX(X).setY(Y);
		this.setText(name);
		this.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.setPriority(RenderPriority.Normal);
	}

}