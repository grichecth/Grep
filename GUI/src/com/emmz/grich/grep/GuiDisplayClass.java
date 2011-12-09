package com.emmz.grich.grep;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

public class GuiDisplayClass extends GenericPopup {
	Grep plugin;
	SpoutPlayer sPlayer;
	
	//GUI Widget Features 
		static GenericTextField searchbox = new GenericTextField(); 
		static GenericLabel title = new GenericLabel();
		static GenericLabel results = new GenericLabel();	
		static GenericTexture bg = new GenericTexture();
		static GenericButton Search_Button = new GenericButton("Search");
		static GenericButton Settings_Button = new GenericButton("Settings");
		static GenericButton Reset_Button = new GenericButton("Reset");
		static GenericButton Help_Button = new GenericButton("Help");
		static GenericLabel search = new GenericLabel();
		static GenericPopup popup = new GenericPopup();
	 	
	  public GuiDisplayClass(Player player, SpoutPlayer sPlayer, Grep plugin) {
			super();
			this.sPlayer = sPlayer;
			this.plugin = plugin;
			//Popup Screen
				popup.setTransparent(true);
			//End
			//Reset Button
				GenericButton Close = new GenericButton("close");
				Close.setWidth(40).setHeight(14).setAnchor(WidgetAnchor.CENTER_CENTER).setX(152).setY(77).setPriority(RenderPriority.Normal);
				popup.attachWidget(plugin, Close);
			//End   
			//Textures
			//URLS, Widths, & Positions
				bg.setUrl(Grep.BgTex).setDrawAlphaChannel(true);
				bg.setWidth(402).setHeight(194).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-201).setY(-97);
				Search_Button.setWidth(91).setHeight(26).setAnchor(WidgetAnchor.CENTER_CENTER).setX(96).setY(-80);
				Settings_Button.setWidth(91).setHeight(26).setAnchor(WidgetAnchor.CENTER_CENTER).setX(96).setY(-50);
				Reset_Button.setWidth(91).setHeight(26).setAnchor(WidgetAnchor.CENTER_CENTER).setX(96).setY(-20);
				Help_Button.setWidth(91).setHeight(26).setAnchor(WidgetAnchor.CENTER_CENTER).setX(96).setY(10);
			//End
			//Priorities
				bg.setPriority(RenderPriority.Highest);
				Search_Button.setPriority(RenderPriority.High);
				Settings_Button.setPriority(RenderPriority.High);
				Reset_Button.setPriority(RenderPriority.High);
				Help_Button.setPriority(RenderPriority.High);
			//Attach
				popup.attachWidget(plugin, bg);
				popup.attachWidget(plugin, Search_Button);
				popup.attachWidget(plugin, Reset_Button);
				popup.attachWidget(plugin, Settings_Button);
				popup.attachWidget(plugin, Help_Button);
			//End    	
			//Title Label		
				title.setText(ChatColor.AQUA+"G"+ChatColor.WHITE+"rief " + ChatColor.AQUA+"Rep"+ChatColor.WHITE+"orter by Grichecth");
				title.setWidth(140).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-140).setY(-64).setPriority(RenderPriority.Lowest);
				popup.attachWidget(plugin, title);
			//End    	
			//Search Textbox
				searchbox.setWidth(205).setHeight(12).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-151).setY(78).setPriority(RenderPriority.Normal);
				search.setWidth(40).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-191).setY(81).setPriority(RenderPriority.Normal);
				search.setText("Search");
				popup.attachWidget(plugin, search);
				popup.attachWidget(plugin, searchbox);
			//End    	
			//ResultsBox	
				results.setText("Waiting on Query.");
				results.setWidth(290).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-140).setY(-15).setPriority(RenderPriority.Lowest);
				popup.attachWidget(plugin, results);
			//End
    }
}
