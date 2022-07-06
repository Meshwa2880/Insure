package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.User;


public class AUserSearchDao extends Database {

	public ResultSet results;
	
	private static Connection connection;
	public AUserSearchDao() throws ClassNotFoundException, SQLException { 

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
	
	
	public void doRead() {
		try {
			String query = "select * from user";
			PreparedStatement ps = connection.prepareStatement(query);
			results = ps.executeQuery();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(AUserSearchDao.class.getName()).log(Level.SEVERE, "Error");
		}
	}
	
	public void doReadUsername(String username) {
		try {
			
			String query;
			if (username.isEmpty()) {
				doRead();
				return;
				
			} else {
				query = "select * from user where username = ?";
			}
			
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			results = ps.executeQuery();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(AUserSearchDao.class.getName()).log(Level.SEVERE, "Error");
		}
	}
	
	public String getHTMLTable() {
		String table = "";
		table += "<table width=100% border=1 style='border-collapse: collapse;text-align:center'>"
				+ "<thead>"
				+ "<tr>"
				+ "<th >Username</th>"
				+ "<th >Phone Number</th>"
				+ "<th >Email</th>"
				+ "<th >Name</th>"
				+ "<th >Address</th>"
				+ "</tr>"
				+ "</thead>"
				+ "<tbody>";
		
		try {
			while(this.results.next()) {
				User u = new User();
				u.setUsername(results.getString("username"));
				u.setCelno(results.getString("celno"));
				u.setEmail(results.getString("email"));
				u.setName(results.getString("name"));
				u.setAddress(results.getString("address"));
				
				table += "<tr>"
						+ "<td>"
						+ u.getUsername()
						+ "</td>"
						+ "<td>"
						+ u.getCelno()
						+ "</td>"
						+ "<td>"
						+ u.getEmail()
						+ "</td>"
						+ "<td>"
						+ u.getName()
						+ "</td>"
						+ "<td>"
						+ u.getAddress()
						+ "</td>"
				;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(AUserSearchDao.class.getName()).log(Level.SEVERE, "Error");
		}
		
		table += "</tbody>"
				+ "</table>";
		
		return table;
		
	}

	
	
}
