package com.emmz.grich.grep;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;



import org.getspout.spoutapi.player.SpoutPlayer;

public class grep extends JavaPlugin {
	private final ButtonListener ScreenListener = new ButtonListener(this);

	Logger log = Logger.getLogger("Minecraft");

	Plugin plugin;

	public void onEnable(){ 
		log.info("Grep enabled!");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.CUSTOM_EVENT, ScreenListener, Event.Priority.Normal, this);

	}

	
	public void onDisable(){	
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player =(Player) sender;
		SpoutPlayer splayer = SpoutManager.getPlayer(player);
		if(cmd.getName().equalsIgnoreCase("whereami")){				//whereami START
    		player.sendMessage(ChatColor.YELLOW + "You're in: " + player.getWorld().getName() + ".");
    		return true;	
		}															//whereami END
	    if(cmd.getName().equalsIgnoreCase("grep")){					//GREP START
	    	GenericPopup popup = new GenericPopup();
    		popup.setTransparent(true);
    			    		
    		GenericButton search = new GenericButton("Search");		//Next lines define GUI display
    		GenericButton reset_search = new GenericButton("Reset");
    		GenericTexture texture = new GenericTexture();
    		GenericLabel title = new GenericLabel();
    		GenericTextField searchbox = new GenericTextField();
    		
    		texture
    		.setUrl("https://lh4.googleusercontent.com/-HXp3NY01Eok/TsclEts-qaI/AAAAAAAAAJo/bz6Qdo57iJw/s300/msgb.png")
    		.setWidth(300)
    		.setHeight(150); 
    		
    		title.setText(ChatColor.AQUA+"G"+ChatColor.WHITE+"rief " + ChatColor.AQUA+"Rep"+ChatColor.WHITE+"orter by Grichecth");
    		
    		texture.setAnchor(WidgetAnchor.CENTER_CENTER).setX(-150).setY(-75);
    		search.setWidth(40).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(10).setY(-50);
    		reset_search.setWidth(40).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(55).setY(-50);
    		title.setWidth(140).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-70).setY(-64);
    		searchbox.setWidth(105).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-100).setY(-50);
    		
    		texture.setPriority(RenderPriority.Highest);
    		title.setPriority(RenderPriority.High);
    		search.setPriority(RenderPriority.Normal);
    		reset_search.setPriority(RenderPriority.Normal);
    		searchbox.setPriority(RenderPriority.Lowest);
    		
    		popup.attachWidget(reset_search);
    		popup.attachWidget(searchbox);
    		popup.attachWidget(texture);
    		popup.attachWidget(title);
    		popup.attachWidget(search);
    		
    		splayer.getMainScreen().attachPopupScreen(popup);
    		return true;	
	    } 															//GREP End
	    return false;
	}	

}

