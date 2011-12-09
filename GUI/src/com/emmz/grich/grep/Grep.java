package com.emmz.grich.grep;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class Grep extends JavaPlugin {
	Grep plugin = this;
    public void ButtonListener(Grep instance) {
    	
		plugin = instance;
	}


	public static String BgTex = "http://www.ozjobsguide.com.au/blog/wp-content/uploads/2011/03/sample.jpg";
	private final ButtonListener ScreenListener = new ButtonListener(this);
	private final TextboxInputListener InputListener = new TextboxInputListener();
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){ 
		log.info("Grep enabled!");
		PluginManager pm = getServer().getPluginManager();
		SpoutManager.getFileManager().addToPreLoginCache(this.plugin, BgTex);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, ScreenListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, InputListener, Event.Priority.Normal, this);
		
		
	}

	public void onDisable(){	
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player =(Player) sender;
		SpoutPlayer splayer = SpoutManager.getPlayer(player);
		if(cmd.getName().equalsIgnoreCase("whereami")){	
    		player.sendMessage(ChatColor.YELLOW + "World = " + player.getWorld().getName() + ".");
    		return true;	
		}													
	    if(cmd.getName().equalsIgnoreCase("grep")){	
	    	
	    	GuiDisplayClass popup = new GuiDisplayClass(player, splayer, plugin);

			splayer.getMainScreen().attachPopupScreen(popup);
    		return true;	
	    } 	
	    return false;
	}	

}

