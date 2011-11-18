package com.emmz.grich.grep;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
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
		PluginManager pm = this.getServer().getPluginManager();
		private grep plugin;
		SpoutManager.getFileManager().addToPreLoginCache(plugin, "https://lh5.googleusercontent.com/-lw_R5n0cGQc/TsRncG-grAI/AAAAAAAAAI4/3KHQ4sc20eM/s300/msgb.png");
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
    			    		
    		GenericButton button = new GenericButton("Button");		//Next lines define GUI display
    		GenericTexture texture = new GenericTexture();
    		GenericLabel title = new GenericLabel();
    		
    		texture
    		.setUrl("https://lh5.googleusercontent.com/-lw_R5n0cGQc/TsRncG-grAI/AAAAAAAAAI4/3KHQ4sc20eM/s300/msgb.png")
    		.setWidth(300)
    		.setHeight(150); 
    		
    		title.setText(ChatColor.AQUA+"G"+ChatColor.WHITE+"rief " + ChatColor.AQUA+"Rep"+ChatColor.WHITE+"orter by Grichecth");
    		
    		texture.setAnchor(WidgetAnchor.CENTER_CENTER).setX(-150).setY(-75);
    		button.setWidth(40).setHeight(20).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-20);
    		title.setWidth(140).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-70).setY(-64);
    		
    		texture.setPriority(RenderPriority.Highest);
    		title.setPriority(RenderPriority.High);
    		button.setPriority(RenderPriority.Normal);

    		popup.attachWidget(texture);
    		popup.attachWidget(title);
    		popup.attachWidget(button);
    		
    		splayer.getMainScreen().attachPopupScreen(popup);
    		return true;	
	    } 															//GREP End
	    return false;
	}	
	
}

