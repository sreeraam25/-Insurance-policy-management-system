package com.management;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnectionManager {
		
	private static Connection con=null;
	private static Properties props=new Properties();
	
	public static Connection getConnection(){
		try {
			FileInputStream fis=null;
			fis=new FileInputStream("data.properties");
			props.load(fis);
			try {
				Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection(props.getProperty("DB_URL"),props.getProperty("DB_USERNAME"),props.getProperty("DB_PASSWORD"));
		}
		catch(IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
