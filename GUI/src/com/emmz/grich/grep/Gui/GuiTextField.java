package com.emmz.grich.grep.Gui;

import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class GuiTextField extends GenericTextField{

	public GuiTextField( int X, int Y, int W, int H) {
		super();
		this.setWidth(W).setHeight(H).setX(X).setY(Y);
		this.setAnchor(WidgetAnchor.CENTER_CENTER);
	}
}
