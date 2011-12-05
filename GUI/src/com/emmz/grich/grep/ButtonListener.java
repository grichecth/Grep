package com.emmz.grich.grep;

import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.player.SpoutPlayer;

public class ButtonListener extends ScreenListener {
	public static grep plugin;

    static String SearchBoxText;

    public ButtonListener(grep instance) {
		plugin = instance;
	}
    
	public void onButtonClick(ButtonClickEvent event) {
    	SpoutPlayer splayer = event.getPlayer();
        if(event.getButton().getText().equals("close")) {
            splayer.getMainScreen().closePopup();
        }     	
    }
}