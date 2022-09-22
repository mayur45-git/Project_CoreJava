package com.customermanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	public Connection getConnection() 
	{
		try {
			 {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcconnect","root","root");
			
			return con;
			
			}
		}catch(Exception e) {
			System.out.println("Exception ="+e);
		}
		return null;
		
	}
	
	
	
	
	
	
	
	

}
