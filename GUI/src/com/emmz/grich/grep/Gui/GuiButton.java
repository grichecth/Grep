package com.emmz.grich.grep.Gui;

import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class GuiButton extends GenericButton {

	public GuiButton(String name, int X, int Y, int W, int H) {
		super();
		this.setText(name);
		this.setWidth(W).setHeight(H).setX(X).setY(Y);
		this.setPriority(RenderPriority.High);
		this.setAnchor(WidgetAnchor.CENTER_CENTER);
	}
}
