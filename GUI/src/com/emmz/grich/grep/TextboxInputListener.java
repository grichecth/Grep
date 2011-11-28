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
    	Player player = event.getPlayer();
		SpoutPlayer splayer = SpoutManager.getPlayer(player);

    	if (event.getKey() == Keyboard.KEY_RETURN) {
    		//if(ButtonListener.searchbox.isFocused()){
    			//ButtonListener.TextChange(splayer);

    			try {
    				con = DriverManager.getConnection(url, user, password);
    				st = con.createStatement();
    				System.out.print("SELECT * FROM users WHERE name = '" + ButtonListener.searchbox.getText() + "'");
    				ResultSet rs = st.executeQuery("SELECT * FROM users WHERE name = '" + ButtonListener.searchbox.getText() + "'");
    				String theresult = "";
    				while (rs.next()) {
    					theresult += rs.getString(1) + "\n";
    				}
    				String Name = ButtonListener.searchbox.getText();
    				//ButtonListener.results.setText(theresult);
    				System.out.print(Name);
    				//ButtonListener.results.setText(Name);
    				ButtonListener.TextChange(Name);
    				splayer.getMainScreen().updateWidget(ButtonListener.results);

		  	  
    				rs.close();st.close();con.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			
    			} 
    		//}
    		
    	}
    }
}
