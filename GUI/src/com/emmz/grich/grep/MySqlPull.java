package com.emmz.grich.grep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.configuration.ConfigurationSection;
import com.emmz.grich.grep.Gui.GrepPopup;

public class MySqlPull {
	private Statement statement;
	private ConfigurationSection config;
	public MySqlPull() {
	}

	public void MySql(String what, String from, GrepPopup activePopup) {
		try	{
			Class.forName("com.mysql.jdbc.Driver");
			this.config = Grep.conf.getDatabaseSettings();
			Connection connection = DriverManager.getConnection("jdbc:" + this.config.getString("address") + ":" + this.config.getString("port") + "/" + this.config.getString("dbname"), this.config.getString("user"), this.config.getString("pass"));
			this.statement = connection.createStatement();
			ResultSet rs = this.statement.executeQuery("SELECT "+what+" FROM "+from+" WHERE name = '"+activePopup.getSearchBox()+"'");
			while (rs.next()) {
				activePopup.setResults(rs.getString(1) + "\n");
			}	
			
			//Close Connections
			rs.close();statement.close();connection.close();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();  
		}

	}

}