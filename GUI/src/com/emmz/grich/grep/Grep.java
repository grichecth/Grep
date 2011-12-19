package com.emmz.grich.grep;

import java.util.logging.Logger;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.emmz.grich.grep.Gui.GrepPopup;

public class Grep extends JavaPlugin {
	public MySqlPull mysqlpull;
	public static String BgTex = "https://lh4.googleusercontent.com/-FjwSATb36Rs/Tt0_5tzA3wI/AAAAAAAAAR4/9NXcJ5_1TUw/s402/Main.png";
	private final ButtonListener ScreenListener = new ButtonListener(this);
	private final TextboxInputListener InputListener = new TextboxInputListener();
	public static GrepConfigManager conf = new GrepConfigManager();
	Grep plugin = this;
	Logger log = Logger.getLogger("Minecraft");

	public void onEnable(){ 
		log.info("Grep enabled!");
		conf.load();
		PluginManager pm = getServer().getPluginManager();
		SpoutManager.getFileManager().addToPreLoginCache(plugin, BgTex);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, ScreenListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.CUSTOM_EVENT, InputListener, Event.Priority.Normal, this);

		new Thread(){
			public void run(){
				Grep.this.mysqlpull = new MySqlPull();
			}
		}.start();

	}

	public void onDisable(){	
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("grep")){	
			new GrepPopup(this, (SpoutPlayer)sender);
			return true;	
		} 	
		return false;
	}
}

