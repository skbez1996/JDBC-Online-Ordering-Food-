package com.cg.myproject.DBUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;


public class DBUtil {

	static Connection conn;
	
	public static Connection getConnection()  {
		Properties prop = new Properties();
	
		try {
			InputStream it = new FileInputStream("src/jdbc.properties");
			prop.load(it);

				if(prop!=null) {
			String driver = prop.getProperty("jdbc.driver");
			String url = prop.getProperty("jdbc.url");
			String uname = prop.getProperty("jdbc.username");
			String upass = prop.getProperty("jdbc.password");
			Class.forName(driver);
			conn=  DriverManager.getConnection(url, uname, upass);
			}
		
		} catch (FileNotFoundException e  ) {
			e.printStackTrace();
			
		}
		catch (ClassNotFoundException |SQLException |IOException e ) {
			e.printStackTrace();
			
			
		} 
		return conn;
		
	}
}
	

