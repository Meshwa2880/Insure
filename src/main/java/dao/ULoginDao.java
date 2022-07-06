package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ULoginDao {
	
	private static Connection connection;
	 public ULoginDao( ) throws ClassNotFoundException, SQLException {  

				InputStream inputStream = getClass().getResourceAsStream("property.txt");
				
				Properties prop = new Properties();
				try {
					prop.load(inputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String username = prop.getProperty("username");
				String driver  = prop.getProperty("driver");
				String server = prop.getProperty("server");
				String password = prop.getProperty("password");
				Class.forName(driver);
				   connection =
						  DriverManager.getConnection(server, username, password);		   
	 }

	 
	 public String doLogin(String username, String password) throws SQLException {
			
			String result = "failure";
			
				String sqlQuery = "select * from user where username = ? AND password = ?";
				PreparedStatement ps = connection.prepareStatement(sqlQuery);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {

					if ((resultSet.getString(1).equals(username)) && (resultSet.getString(2).equals(password))) {
						result = "success";
					} else {
						result = "failure";
					}
				}
				resultSet.close();
				connection.close();
	
			return result;
		}	
	 
	 public String doAdminCheck(String username, String password) throws SQLException {
			
			String result = "failure";
			
				String sqlQuery = "select * from user where username = ? AND password = ? AND isadmin=1";
				PreparedStatement ps = connection.prepareStatement(sqlQuery);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {

					if ((resultSet.getString(1).equals(username)) && (resultSet.getString(2).equals(password))) {
						result = "success";
					} else {
						result = "failure";
					}
				}
				resultSet.close();
				connection.close();
	
			return result;
		}

}
