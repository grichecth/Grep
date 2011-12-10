package com.emmz.grich.grep;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ButtonListener extends ScreenListener {
	Grep plugin;

public ButtonListener(Grep instance) {
		plugin = instance;
	}
    
	public void onButtonClick(ButtonClickEvent event) {
    	SpoutPlayer splayer = event.getPlayer();
        if(event.getButton().getText().equals("Close")) {
            splayer.getMainScreen().closePopup();
        }     	
    }
}