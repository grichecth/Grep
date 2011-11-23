package com.emmz.grich.grep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.screen.ScreenListener;

public class ButtonListener extends ScreenListener {
	public static grep plugin;
    Connection con = null;
    Statement st = null;

    //START MYSQL DATA
    String url = "jdbc:mysql://localhost:3306/grepdb";
    String user = "root";
    String password = "new_342by";
    //END MYSQL DATA
	
    public ButtonListener(grep instance) {
		plugin = instance;
	}
    public void onButtonClick(ButtonClickEvent event) {
    	try {
    		con = DriverManager.getConnection(url, user, password);
    		st = con.createStatement();
    		ResultSet rs = st.executeQuery("SELECT name FROM users");
		        
		    while (rs.next()) {
		    	//System.out.println(rs.getString(1));
		    	System.out.println(grep.getlabel());
		    	grep.changeresultdata("Shit");
	        }
		    
		    rs.close();st.close();con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
    }
}