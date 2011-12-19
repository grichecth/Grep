package com.emmz.grich.grep;

import java.util.HashMap;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.gui.PopupScreen;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.emmz.grich.grep.Gui.GrepPopup;

public class TextboxInputListener extends InputListener {
	public Grep plugin;
	public HashMap<String, String> Results = new HashMap<String,String>();

	public void onKeyPressedEvent(KeyPressedEvent event) {
		SpoutPlayer splayer = event.getPlayer();
    	PopupScreen activePopup = splayer.getMainScreen().getActivePopup();
		if (event.getKey() == Keyboard.KEY_RETURN) {	
			//if(Grep.SearchBox.isFocused()){
			this.plugin.mysqlpull.MySql("bio","users",(GrepPopup)activePopup);
			//}
		}
	}
}
