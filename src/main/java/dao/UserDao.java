package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import model.User;

public class UserDao {
	private static Connection connection;
	 public UserDao( ) throws ClassNotFoundException, SQLException {  

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

	 
	 public void doAddUser(User user){ 	 	
		 try {
				 String query = "insert into user (username,password,celno,email,name,address,isadmin) values(?, ?, ?, ?, ?, ?, ?);";
				 PreparedStatement ps = connection.prepareStatement(query);
				 ps.setString(1, user.getUsername());
				 ps.setString(2, user.getPassword());
				 ps.setString(3, user.getCelno());
				 ps.setString(4, user.getEmail());
				 ps.setString(5, user.getName());
				 ps.setString(6, user.getAddress());
				 ps.setInt(7, user.getIsadmin());
				 ps.executeUpdate();
		 }catch(SQLException e) {
				 e.printStackTrace();
		 } 
    }  
}
