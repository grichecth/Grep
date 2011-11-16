package com.emmz.grich.grep;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class grep extends JavaPlugin {
	private static final String String = null;
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
	    	} else {
				player.sendMessage("Wrong usage, See /grep help");
				return true;
			}
	    	
		} 
	    return false;
	}	
	
}

