package com.emmz.grich.grep.Gui;

import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.WidgetAnchor;

public class GuiPopup extends GenericPopup {
	
	public GuiPopup() {
		super();	  
		this.setTransparent(true);
		this.setAnchor(WidgetAnchor.CENTER_CENTER);
	}
}
