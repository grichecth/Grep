package com.emmz.grich.grep.Listeners;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.gui.PopupScreen;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.emmz.grich.grep.Grep;
import com.emmz.grich.grep.Gui.GrepPopup;

public class ButtonListener extends ScreenListener {
	private final Grep plugin;
	
public ButtonListener(Grep instance) {
		this.plugin = instance;
	}
    
	public void onButtonClick(ButtonClickEvent event) {
    	SpoutPlayer splayer = event.getPlayer();
    	PopupScreen activePopup = splayer.getMainScreen().getActivePopup();
        if(event.getButton().getText().equals("Close")) {
        	activePopup.close();
        } else if(event.getButton().getText().equals("Search")) {
			this.plugin.mysqlpull.MySql("bio","users",(GrepPopup)activePopup);
        }       	
    }
}