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

import com.emmz.grich.grep.Gui.GuiButton;
import com.emmz.grich.grep.Gui.GuiLabel;
import com.emmz.grich.grep.Gui.GuiPopup;
import com.emmz.grich.grep.Gui.GuiTextField;
import com.emmz.grich.grep.Gui.GuiTexture;

public class Grep extends JavaPlugin {
	Grep plugin = this;
	public static GuiLabel results = new GuiLabel("Query",1,1,1,1);

	public static String BgTex = "https://lh4.googleusercontent.com/-FjwSATb36Rs/Tt0_5tzA3wI/AAAAAAAAAR4/9NXcJ5_1TUw/s402/Main.png";
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
	    //Popup, Textfield, & Texture	
	    	GuiPopup popup = new GuiPopup();
			GuiTextField SearchBox = new GuiTextField(-151,78,205,12);
			GuiTexture Bg = new GuiTexture(-201,-97,402,194, BgTex);
		//Labels	
			GuiLabel Title = new GuiLabel("Gui Test Phase: Alpha",-140,-64,140,20);
			GuiLabel Search = new GuiLabel("Search",-191,81,40,15);
		//Buttons	
		 	GuiButton Settings = new GuiButton("Settings",96,-50,91,20);
		 	GuiButton Help = new GuiButton("Help",96,-20,91,20);
		 	GuiButton Close = new GuiButton("Close",142,77,50,14); 	
		 //Attach Gui Widgets	
		 	popup.attachWidget(plugin, SearchBox);
		 	popup.attachWidget(plugin, Bg);
		 	popup.attachWidget(plugin, Title);
		 	popup.attachWidget(plugin, Search);
		 	popup.attachWidget(plugin, Settings);
		 	popup.attachWidget(plugin, Help);
		 	popup.attachWidget(plugin, Close);
		 //Launch!
	    	splayer.getMainScreen().attachPopupScreen(popup);
	    	
    		return true;	
	    } 	
	    return false;
	}	
}

