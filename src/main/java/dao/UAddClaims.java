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

import model.Claim;

public class UAddClaims {

	private static Connection connection;
	private static int resultCount;
	
	public  UAddClaims() throws ClassNotFoundException, SQLException {
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
	
	
	 public String doValidate(String username, String serialno) throws SQLException {
			
		        String resultvalid = "failure";	
				String sqlQuery = "select * from user where username = ?;";
				String sqlQuery2 = "select * from product where serialno = ?;";
				PreparedStatement ps = connection.prepareStatement(sqlQuery);
				PreparedStatement ps2 = connection.prepareStatement(sqlQuery2);
				ps.setString(1, username);
				ps2.setString(1, serialno);

				ResultSet resultSet = ps.executeQuery();
				ResultSet resultSet2 = ps2.executeQuery();
				while (resultSet.next() && resultSet2.next()) {

					if ((resultSet.getString(1).equals(username) && (resultSet2.getString(1).equals(serialno)))) {
						resultvalid = "success";
					} else {
						resultvalid = "failure";
					}
				}
				System.out.print(resultvalid);
				System.out.print(username);
			return resultvalid;
		}
	
	
	public void doAddClaim(Claim claim) {
		 try {
		 String query = "insert into claim (username,serialno,dateofclaim,description,approvalstatus) values(?,?,?,?,?);";
		 PreparedStatement ps = connection.prepareStatement(query);
			 ps.setString(1, claim.getUsername());
			 ps.setString(2, claim.getSerialno());
			 ps.setDate(3, claim.getDateofclaim());
			 ps.setString(4, claim.getDescriptions());
			 ps.setInt(5, claim.getApprovalstatus());
			 ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	 public int countClaims(String serialno,String username) throws SQLException {
		try{
		    String query = "select count(*) as count from claim where serialno=? and username=?";
		    PreparedStatement ps = (PreparedStatement)connection.prepareStatement(query);
		    ps.setString(1, serialno);
		    ps.setString(2, username);
		    ResultSet rs = ps.executeQuery();
			  while(rs.next()){ 
				  resultCount = rs.getInt("count"); 
				  }
			 
		}catch (Exception ex){
			 java.util.logging.Logger.getLogger(UProductDao.class.getName()).log(Level.SEVERE, "Cannot Establish Connection");
		}
		System.out.print(resultCount);
		return resultCount;
		}
	
}
