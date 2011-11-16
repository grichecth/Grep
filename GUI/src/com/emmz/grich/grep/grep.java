package com.emmz.grich.grep;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;


import org.getspout.spoutapi.player.SpoutPlayer;

public class grep extends JavaPlugin {
	//private static final String String = null;
	Logger log = Logger.getLogger("Minecraft");

	
	public void onEnable(){ 
		log.info("Your plugin has been enabled!");

	}
	
	public void onDisable(){ 
	
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player =(Player) sender;
	    if(cmd.getName().equalsIgnoreCase("grep")){
	    	if(args.length==1 && args[0].equalsIgnoreCase("whereami")){
	    		player.sendMessage(ChatColor.YELLOW + "You're in world " + player.getWorld().getName() + ".");
	    		return true;
	    	} else if(args.length==1 && args[0].equalsIgnoreCase("gui")){
	    		//player.sendMessage(ChatColor.YELLOW + "GUI!");
	    		SpoutPlayer splayer = SpoutManager.getPlayer(player); // Get the SpoutPlayer
	    		GenericPopup popup = new GenericPopup(); // Create a new popup
	    		GenericButton button = new GenericButton("Button"); // Read more about creating widgets in Widgets
	    		
	    		
	    		button.setWidth(200).setHeight(20);
	    		popup.attachWidget(button); // Attach the widget to the popup
	    		popup.setX(10).setY(10).setWidth(30).setHeight(30);
	    		popup.setTransparent(true);
	    		GenericTexture texture = new GenericTexture();
	    		texture.setUrl("https://lh6.googleusercontent.com/-gshXWj1VVAk/TsQBWrj3S0I/AAAAAAAAAHA/rK0vnq9pLwM/s176/bg.png"); //Have to be a png or jpg
	    		texture.setWidth(176).setHeight(83); //Use the same size as the png here.
	    		button.setAnchor(WidgetAnchor.CENTER_CENTER);
	    		popup.attachWidget(texture);
	    		splayer.getMainScreen().attachPopupScreen(popup); // Show the player the popup
	    		

	    		return true;
	    	} else {
				return false;
			}
	    	
		} 
	    return false;
	}	
	
}

