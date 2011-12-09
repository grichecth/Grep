package com.emmz.grich.grep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.input.InputListener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

public class TextboxInputListener extends InputListener {
	
   //MySQL Vars	
	Connection con = null;
    Statement st = null;
    String url = "jdbc:mysql://localhost:3306/grepdb"; 
    String user = "root";
    String password = "new_342by";
    
    public void onKeyPressedEvent(KeyPressedEvent event) {

    	if (event.getKey() == Keyboard.KEY_RETURN) {
        	Player player = event.getPlayer();
    		SpoutPlayer splayer = SpoutManager.getPlayer(player);
    		GuiDisplayClass.searchbox.setFocus(true);
    		if(GuiDisplayClass.searchbox.isFocused()){
    			try {
    				con = DriverManager.getConnection(url, user, password);
    				st = con.createStatement();
    				ResultSet rs = st.executeQuery("SELECT name FROM users WHERE name = '" + GuiDisplayClass.searchbox.getText() + "'");
    				String theresult = "";
    				while (rs.next()) {
    					theresult += rs.getString(1) + "\n";
    				}
    				    				
    			//Change Result Label to MySQL Result	
    				System.out.print(player+", "+GuiDisplayClass.searchbox.isFocused());
    				GuiDisplayClass.results.setText(theresult);
    				splayer.getMainScreen().updateWidget(GuiDisplayClass.results);

    		    //Close Connections
    				rs.close();st.close();con.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			
    			} 
    		}
    		
    	}
    }
}
