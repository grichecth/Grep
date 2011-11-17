package com.emmz.grich.grep;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;


import org.getspout.spoutapi.player.SpoutPlayer;

public class grep extends JavaPlugin {
	//private static final String String = null;
	Logger log = Logger.getLogger("Minecraft");

	
	public void onEnable(){ 
		log.info("Grep enabled!");

	}
	
	public void onDisable(){ 
	
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player =(Player) sender;
	    if(cmd.getName().equalsIgnoreCase("grep")){
	    	if(args.length==1 && args[0].equalsIgnoreCase("whereami")){
	    		player.sendMessage(ChatColor.YELLOW + "You're in world " + player.getWorld().getName() + ".");
	    		return true;
	    	} else if(args.length==1 && args[0].equalsIgnoreCase("gui")){
	    		//player.sendMessage(ChatColor.YELLOW + "GUI!");
	    		SpoutPlayer splayer = SpoutManager.getPlayer(player);
	    		GenericPopup popup = new GenericPopup();
	    		GenericButton button = new GenericButton("Button");
	    		GenericTexture texture = new GenericTexture();
	    		GenericLabel title = new GenericLabel();
	    	
	    		button.setWidth(40).setHeight(20);
	    		popup.setX(10).setY(10).setWidth(30).setHeight(30);
	    		popup.setTransparent(true);

	    		texture.setUrl("https://lh5.googleusercontent.com/-lw_R5n0cGQc/TsRncG-grAI/AAAAAAAAAI4/3KHQ4sc20eM/s300/msgb.png"); 
	    		texture.setWidth(300).setHeight(150);
	    		texture.setAnchor(WidgetAnchor.CENTER_CENTER).setX(-150).setY(-75);
	    		
	    		title.setAnchor(WidgetAnchor.CENTER_CENTER).setY(-65);
	    		title.setText("What is up!");
	    		
	    		button.setAnchor(WidgetAnchor.CENTER_CENTER);
	 //http://wiki.getspout.org/Containers   		
	    		popup.attachWidget(texture).setPriority(RenderPriority.High);
	    		popup.attachWidget(title).setPriority(RenderPriority.Normal);
	    		popup.attachWidget(button).setPriority(RenderPriority.Normal);
	    		
	    		splayer.getMainScreen().attachPopupScreen(popup);
	    		

	    		return true;
	    	} else {
				return false;
			}
	    	
		} 
	    return false;
	}	
	
}

