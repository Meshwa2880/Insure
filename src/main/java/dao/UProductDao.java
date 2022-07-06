package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import model.UserProduct;

public class UProductDao {

	private static Connection connection;
	 private ResultSet results;
	
	 public UProductDao( ) throws ClassNotFoundException, SQLException {  

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

	 public String doValidateProductName(String serialno, String productname) throws SQLException {
			
			String resultproduct = "failure";		
				String sqlQuery = "select * from product where serialno = ? and productname = ?;";
				PreparedStatement ps = connection.prepareStatement(sqlQuery);
				ps.setString(1, serialno);
				ps.setString(2, productname);

				ResultSet resultSet = ps.executeQuery();
				while (resultSet.next()) {

					if ((resultSet.getString(1).equals(serialno) && resultSet.getString(2).equals(productname))) {
						resultproduct = "success";
					} else {
						resultproduct = "failure";
					}
				}
			return resultproduct;
		}
	 
	 
	   public void doRegisterProduct(UserProduct userproduct){    
			 try {
					 String query = "insert into userproduct (username,productname,serialno,purchasedate) values(?, ?, ?, ?);";
					 PreparedStatement ps = connection.prepareStatement(query);
					 ps.setString(1, userproduct.getUsername());
					 ps.setString(2, userproduct.getProductname());
					 ps.setString(3, userproduct.getSerialno());
					 ps.setDate(4, userproduct.getPurchasedate());
					 ps.executeUpdate();
			 }catch(SQLException e) {
					 e.printStackTrace();
			 }  
	   }
	   
	   public void doReadUserProduct(String usernamecook) {
			 try {
			 String query = "Select * from userproduct where username=?;";
			 PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
			 ps.setString(1, usernamecook);
			 this.results = ps.executeQuery();
			 System.out.print(usernamecook);
			 }catch(SQLException e) {
			 java.util.logging.Logger.getLogger(UProductDao.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");
			 } 
		 }
	   
	   public String getHTMLTable() throws SQLException {
			 String table = "";
			 table += "<table border=1>";
			 while(this.results.next()) {
			 UserProduct userproduct = new UserProduct();
			 userproduct.setProductname(this.results.getString("productname"));
			 userproduct.setSerialno(this.results.getString("serialno"));
			 userproduct.setUsername(this.results.getString("username"));
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
