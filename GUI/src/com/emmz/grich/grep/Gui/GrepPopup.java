package com.emmz.grich.grep.Gui;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.*;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.emmz.grich.grep.Grep;

public class GrepPopup extends GenericPopup {
	Plugin plugin;
	GenericLabel Results;
	GenericLabel Title;
	GenericLabel  Search;
	GenericTextField SearchBox;
	GenericTexture Bg;
	GenericTexture Profile;
	GenericButton Settings;
	GenericButton Help;
	GenericButton Close;
	GenericButton SearchButton;

	public GrepPopup(Plugin plugin, SpoutPlayer player){
		this.plugin = plugin;
		createScreen(player);
		setTransparent(true);
		setAnchor(WidgetAnchor.CENTER_CENTER);
	}

	public void createScreen(SpoutPlayer player){
		System.out.print(
		SpoutPlayer splayer = player;
		//Setup TextField Widgets
		this.SearchBox = new GenericTextField();
		this.SearchBox.setWidth(205).setHeight(12).setX(-151).setY(78);
		this.SearchBox.setAnchor(WidgetAnchor.CENTER_CENTER);

		//Setup Texture Widgets
		this.Bg = new GenericTexture(Grep.BgTex);
		this.Bg.setWidth(402).setHeight(194).setX(-201).setY(-97);
		this.Bg.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.Bg.setPriority(RenderPriority.Highest);
		this.Bg.setDrawAlphaChannel(true);
		
		this.Profile = new GenericTexture("http://staff.emmz.com/includes/mcface.php?user="+player.toString().substring(17, player.toString().length()-1).toLowerCase());
		this.Profile.setWidth(402).setHeight(194).setX(-201).setY(-97);	//Need to start from here..
		this.Profile.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.Profile.setPriority(RenderPriority.Highest);
		this.Profile.setDrawAlphaChannel(true);
		
		//Setup Button Widgets
		this.SearchButton = new GenericButton("Search");
		this.SearchButton.setWidth(50).setHeight(14).setX(72).setY(77);
		this.SearchButton.setPriority(RenderPriority.High);
		this.SearchButton.setAnchor(WidgetAnchor.CENTER_CENTER);	

		this.Close = new GenericButton("Close");
		this.Close.setWidth(50).setHeight(14).setX(142).setY(77);
		this.Close.setPriority(RenderPriority.High);
		this.Close.setAnchor(WidgetAnchor.CENTER_CENTER);		

		this.Help = new GenericButton("Help");
		this.Help.setWidth(91).setHeight(20).setX(96).setY(-20);
		this.Help.setPriority(RenderPriority.High);
		this.Help.setAnchor(WidgetAnchor.CENTER_CENTER);		

		this.Settings = new GenericButton("Settings");
		this.Settings.setWidth(91).setHeight(20).setX(96).setY(-50);
		this.Settings.setPriority(RenderPriority.High);
		this.Settings.setAnchor(WidgetAnchor.CENTER_CENTER);

		//Setup Label Widgets
		this.Results = new GenericLabel("Waiting on Query...");
		this.Results.setWidth(40).setHeight(15).setX(-140).setY(-15);
		this.Results.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.Results.setPriority(RenderPriority.Normal);

		this.Title = new GenericLabel("Gui Test Phase: Alpha");
		this.Title.setWidth(140).setHeight(20).setX(-140).setY(-64);
		this.Title.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.Title.setPriority(RenderPriority.Normal);		

		this.Search = new GenericLabel("Search");
		this.Search.setWidth(40).setHeight(15).setX(-191).setY(81);
		this.Search.setAnchor(WidgetAnchor.CENTER_CENTER);
		this.Search.setPriority(RenderPriority.Normal);

		//Attach Gui Widgets	
		attachWidget(this.plugin, this.Results);
		attachWidget(this.plugin, this.Title);
		attachWidget(this.plugin, this.Search);
		attachWidget(this.plugin, this.Bg);
		attachWidget(this.plugin, this.Settings);
		attachWidget(this.plugin, this.Help);
		attachWidget(this.plugin, this.Close);
		attachWidget(this.plugin, this.SearchButton);
		attachWidget(this.plugin, this.SearchBox);

		splayer.getMainScreen().attachPopupScreen(this);
	}

	public String getSearchBox(){
		return this.SearchBox.getText();
	}

	public String getResults(){
		return Results.getText();
	}

	public void setResults(String results){
		Results.setText(results);
	}
}
