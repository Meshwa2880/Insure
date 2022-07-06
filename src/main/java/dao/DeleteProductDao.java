package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;



public class DeleteProductDao {
	
	public int doDelete(String serialno) throws SQLException {
		// READ your Data and save it in ResultSet
		int rs;
		Connection connection;
		
		InputStream inputStream = getClass().getResourceAsStream("property.txt");
		
		Properties prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uname = prop.getProperty("username");
		String driver  = prop.getProperty("driver");
		String server = prop.getProperty("server");
		String password = prop.getProperty("password");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   connection =
				  DriverManager.getConnection(server, uname, password);	
		   
		String query ="DELETE FROM product where serialno = ?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, serialno);
		try
		{
		rs = ps.executeUpdate();
		}
		catch(SQLIntegrityConstraintViolationException e)
		{
			System.out.println("Cannot Delete Product");
			rs= 0;
		}
		return rs;
	}
	


}
