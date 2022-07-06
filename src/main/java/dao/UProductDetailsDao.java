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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.UserProduct;

public class UProductDetailsDao {

	private static Connection connection;
	 private ResultSet results;
	 private ResultSet resultsCount;
	
	 public UProductDetailsDao( ) throws ClassNotFoundException, SQLException {  

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
		
		public void doReadUserProduct(String serialno, String username) {
			 try {
			 String query = "SELECT * FROM userproduct where serialno=? and username = ?;";
			 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
			 ps.setString(1, serialno);
			 ps.setString(2, username);
			 this.results = ps.executeQuery();
			 }catch(SQLException e) {
				 java.util.logging.Logger.getLogger(UProductDao.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");
			 } 
		 }
 
		
		public String getHTMLTable() throws SQLException {
			 String table = "";
			 table += "<table width=100% border=1 style='border-collapse: collapse;text-align:center'>"; 
			 table +=  "<thead>";
			 table +=   "<tr>";
			 table +=   "<th>User Name</th>";
			 table +=  "<th>Product Name</th>";
			 table +=  "<th>Serial No</th>";
			 table +=  "<th>Purchase Date</th>";
			 table +=  "</thead>";
			 while(this.results.next()) {
				 UserProduct userproduct = new UserProduct();
				 userproduct.setProductid(this.results.getInt("productid"));
				 userproduct.setUsername(this.results.getString("username"));
				 userproduct.setProductname(this.results.getString("productname"));
				 userproduct.setSerialno(this.results.getString("serialno"));
				 userproduct.setPurchasedate(this.results.getDate("purchasedate"));
					 table += "<tr>";
					  table += "<td>";
					    table += userproduct.getUsername();
					  table += "</td>";
						table += "<td>";
						  table += userproduct.getProductname();
						 table += "</td>";
					    table += "<td>";
					     table += userproduct.getSerialno();
					     table += "</td>";
					     table += "<td>";
					      table += userproduct.getPurchasedate();
					    table += "</td>";
					 table += "</tr>";  
			 }
			 table += "</table>";
			 return table;
			 }  
	}

