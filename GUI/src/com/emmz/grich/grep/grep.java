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
	Logger log = Logger.getLogger("Minecraft");
	
	public void onEnable(){ 
		log.info("Your plugin has been enabled!");

	}
	
	public void onDisable(){ 
	
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    if(cmd.getName().equalsIgnoreCase("ignite")){
			Player player =(Player) sender;
			//if(args[1].equalsIgnoreCase("help")){
			//	player.sendMessage(ChatColor.DARK_RED + "helpmenu");	
			//	return true;
			//} else {
			//	player.sendRawMessage(server.getWorlds());
			List<String> worldNames = new ArrayList<String>();
			for(World w : this.getServer().getWorlds()) {
			worldNames.add(w.getName());
			}
			player.sendRawMessage(worldNames);
				return true;
			//}
	    }
	    return false;
	}	
	
}

