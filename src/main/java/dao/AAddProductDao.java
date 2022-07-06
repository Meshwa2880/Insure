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

import model.Product;
import model.User;


public class AAddProductDao extends Database {

	public ResultSet results;
	private static Connection connection;
	public AAddProductDao() throws ClassNotFoundException, SQLException {
		
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
	
	public void doAdd(Product p) {
		try {
			String query = "insert into product (serialno, productname, model) values (?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, p.getSerialno());
			ps.setString(2, p.getProductname());
			ps.setString(3, p.getModel());
			ps.executeUpdate();
			ps.close();
			
			this.connection.close();
			
		} catch (SQLException ex) {
			//Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, "Error");
			ex.printStackTrace();
		}
	}
	
	

	
	
}
