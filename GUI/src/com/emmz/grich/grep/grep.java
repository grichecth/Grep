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
	    if(cmd.getName().equalsIgnoreCase("grep")){
	    	Player player =(Player) sender;
	    	World here = player.getWorld();
			if(here.getName() == "CraftWorld{name=world_nether}"){
				player.sendMessage(ChatColor.AQUA + "" + here.getName());
				return true;
			} else {
				player.sendMessage("Not sure where you are.");
				return true;
			}	

	    }
	    return false;
	}	
	
}

