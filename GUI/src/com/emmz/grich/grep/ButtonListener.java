package com.emmz.grich.grep;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTextField;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;


public class ButtonListener extends ScreenListener {
	public static grep plugin;

    static String SearchBoxText;

    public ButtonListener(grep instance) {
		plugin = instance;
	}
    
   //GUI Features 
    static GenericTextField searchbox = new GenericTextField(); 
    static GenericLabel title = new GenericLabel();
    static GenericLabel results = new GenericLabel();	
    
    @SuppressWarnings("deprecation")
    public static void Popup(SpoutPlayer splayer){
    //Popup Screen
    	GenericPopup popup = new GenericPopup();
		popup.setTransparent(true);
		//End    		
	//Search Button
		GenericButton search = new GenericButton("Search");		
		search.setWidth(40).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(10).setY(-50).setPriority(RenderPriority.Normal);
		popup.attachWidget(search);
		//End    		
	//Reset Button
		GenericButton reset_search = new GenericButton("Reset");
		reset_search.setWidth(40).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(55).setY(-50).setPriority(RenderPriority.Normal);
		popup.attachWidget(reset_search);
		//End    		
	//Back Texture Button
		GenericTexture texture = new GenericTexture();
		texture.setUrl("https://lh4.googleusercontent.com/-HXp3NY01Eok/TsclEts-qaI/AAAAAAAAAJo/bz6Qdo57iJw/s300/msgb.png");
		texture.setWidth(300).setHeight(150).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-150).setY(-75);
		texture.setPriority(RenderPriority.High);
		popup.attachWidget(texture);
		//End    		
	//Title Label		
		title.setText(ChatColor.AQUA+"G"+ChatColor.WHITE+"rief " + ChatColor.AQUA+"Rep"+ChatColor.WHITE+"orter by Grichecth");
		title.setWidth(140).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-70).setY(-64).setPriority(RenderPriority.Lowest);
		popup.attachWidget(title);
		//End    		
	//Search Textbox
		searchbox.setWidth(105).setHeight(15).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-100).setY(-50).setPriority(RenderPriority.Normal);
		popup.attachWidget(searchbox);
		//End    		
	//ResultsBox	
    	results.setText("Waiting on Query..");
    	results.setWidth(290).setAnchor(WidgetAnchor.CENTER_CENTER).setX(-140).setY(-15).setPriority(RenderPriority.Lowest);
  	    popup.attachWidget(results);
  	    //End
	//Launch
		splayer.getMainScreen().attachPopupScreen(popup);
		
		//End
    }
    
    public static void TextChange(String sting){
    	results.setText(sting);
    	//splayer.getMainScreen().updateWidget(results);
    	//System.out.print("has");
    
    }

	public void onButtonClick(ButtonClickEvent event) {
    	SpoutPlayer splayer = event.getPlayer();
        if(event.getButton().getText().equals("Reset")) { // if the button says close
            splayer.getMainScreen().closePopup(); // close the players popup

        } else if(event.getButton().getText().equals("Search")) { 
        	//Saerchbutton
        }
    	
    }
}