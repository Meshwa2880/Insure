package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
	
	Properties properties;
	
	public Database() {
		
		try {
			// load the db properties and read from there
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			// go to /WEB-INF/properties/db.properties
			// seems like current folder is in /WEB-INF/classes/
			InputStream input = classLoader.getResourceAsStream("../properties/db.properties");
			
			properties = new Properties();
			properties.load(input);
			
			// allocate a Connection object
			Class.forName((String) properties.getProperty("driver"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private Connection getConnection() {
		Connection connection = null;
		try {
			String dbUrl= properties.getProperty("dbUrl");
			String user = properties.getProperty("user");
			String pw = properties.getProperty("password");
						
			connection = DriverManager.getConnection(dbUrl, user, pw);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}

}
		