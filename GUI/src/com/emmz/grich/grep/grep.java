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

public class grep extends JavaPlugin {
	public static grep plugin;
	private final ButtonListener ScreenListener = new ButtonListener(this);
	private final TextboxInputListener InputListener = new TextboxInputListener();
	Logger log = Logger.getLogger("Minecraft");
		
	public void onEnable(){ 
		log.info("Grep enabled!");
		PluginManager pm = getServer().getPluginManager();
		String MAINBG = "https://lh6.googleusercontent.com/-QVvKoxCorl0/TtuoXVCpA6I/AAAAAAAAARk/cCBREHB3-2w/s402/Main.png";
		SpoutManager.getFileManager().addToPreLoginCache(plugin, "https://lh6.googleusercontent.com/-QVvKoxCorl0/TtuoXVCpA6I/AAAAAAAAARk/cCBREHB3-2w/s402/Main.png");
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
	    	GuiDisplayClass.Popup(splayer);
    		return true;	
	    } 	
	    return false;
	}	

}

