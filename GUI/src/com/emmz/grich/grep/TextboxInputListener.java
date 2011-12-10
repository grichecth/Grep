package com.emmz.grich.grep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TextboxInputListener extends InputListener {
	Grep plugin;
	public HashMap<String, String> Results = new HashMap<String,String>();
	public void onKeyPressedEvent(KeyPressedEvent event) {
    	//MySQL Vars	
    	Connection con = null;
        Statement st = null;
        String url = "jdbc:mysql://localhost:3306/grepdb"; 
        String user = "root";
        String password = "new_342by";
        
    	if (event.getKey() == Keyboard.KEY_RETURN) {
        	Player player = event.getPlayer();
    		SpoutPlayer splayer = SpoutManager.getPlayer(player);
    		GuiDisplayClass.searchbox.setFocus(true);
    		if(GuiDisplayClass.searchbox.isFocused()){
    			try {
    				con = DriverManager.getConnection(url, user, password);
    				st = con.createStatement();
    				ResultSet rs = st.executeQuery("SELECT name FROM users WHERE name = '" + GuiDisplayClass.searchbox.getText() + "'");
    				while (rs.next()) {
    					Results.put(splayer.getName(), rs.getString(1));
    				}
    				    				
    			//Change Result Label to MySQL Result	
    				System.out.print(player+", "+GuiDisplayClass.searchbox.isFocused());
    		    	System.out.print("you got "+Results.get(splayer.getName()));
    				//Grep.results.setText(Results);
    				//splayer.getMainScreen().updateWidget(Grep.results);

    		    //Close Connections
    				rs.close();st.close();con.close();
    				
    			} catch (SQLException e) {
    				e.printStackTrace();  
    				
    			} 
    		}    		
    	}
    }
}
