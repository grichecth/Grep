package com.emmz.grich.grep;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.emmz.grich.grep.Gui.GrepPopup;

public class TextboxInputListener extends InputListener {
	public Grep plugin;
	public HashMap<String, String> Results = new HashMap<String,String>();

	public void onKeyPressedEvent(KeyPressedEvent event) {

		if (event.getKey() == Keyboard.KEY_RETURN) {	
			//if(Grep.SearchBox.isFocused()){
				//plugin.ModifyResults(splayer);
				//System.out.print(popup.getSearchBox());
				//popup.getResults().setText(MySqlPull.MySQL("name","users",popup.getSearchBox()));
			//}
		}
	}
}
