package com.emmz.grich.grep;
import java.io.File;
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

import com.emmz.grich.grep.Gui.GrepPopup;

public class Grep extends JavaPlugin {
	Grep plugin = this;
	Logger log = Logger.getLogger("Minecraft");
	public MySqlPull mysqlpull;

	public static String BgTex = "https://lh4.googleusercontent.com/-FjwSATb36Rs/Tt0_5tzA3wI/AAAAAAAAAR4/9NXcJ5_1TUw/s402/Main.png";

	private final ButtonListener ScreenListener = new ButtonListener(this);
	private final TextboxInputListener InputListener = new TextboxInputListener();
	public static GrepConfigManager conf = new GrepConfigManager();

	public void onEnable(){ 
		log.info("Grep enabled!");
		conf.createDefaultSettingsFile();
		conf.load();
		PluginManager pm = getServer().getPluginManager();
		SpoutManager.getFileManager().addToPreLoginCache(plugin, BgTex);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, ScreenListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, InputListener, Event.Priority.Normal, this);

		new Thread(){
			public void run(){
				Grep.this.mysqlpull = new MySqlPull(null, null, null);
			}
		}
		.start();

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
			new GrepPopup(this, (SpoutPlayer)sender);
			return true;	
		} 	
		return false;
	}
}

