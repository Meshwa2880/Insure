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


public class AReportsDao extends Database {

	public ResultSet results;
	

	private static Connection connection;
	public AReportsDao() throws ClassNotFoundException, SQLException {

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
			String query = "select "
					+ "u.username, "
					+ "celno, "
					+ "email, "
					+ "name, "
					+ "address, "
					+ "p.serialno, "
					+ "productname, "
					+ "model, "
					+ "dateofclaim, "
					+ "description, "
					+ "approvalstatus "
					+ "from user u "
					+ "    left join claim c on c.username=u.username "
					+ "    left join product p on p.serialno=c.serialno "
					+ "order by username";
			PreparedStatement ps = connection.prepareStatement(query);
			results = ps.executeQuery();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(AReportsDao.class.getName()).log(Level.SEVERE, "Error");
		}
	}
		
	public String getHTMLTable() {
		String table = "";
		table += "<table class=\"table\">"
				+ "<thead>"
				+ "<tr>"
				+ "<th colspan=5>User</th>"
				+ "<th colspan=3>Product</th>"
				+ "<th colspan=3>Claim</th>"
				+ "<tr>"
				+ "<tr>"
				+ "<th scope=\"col\">Username</th>"
				+ "<th scope=\"col\">Phone Number</th>"
				+ "<th scope=\"col\">Email</th>"
				+ "<th scope=\"col\">Name</th>"
				+ "<th scope=\"col\">Address</th>"
				+ "<th scope=\"col\">Serial Number</th>"
				+ "<th scope=\"col\">Product Name</th>"
				+ "<th scope=\"col\">Model</th>"
				+ "<th scope=\"col\">Date of Claim</th>"
				+ "<th scope=\"col\">Description</th>"
				+ "<th scope=\"col\">Approval Status</th>"
				+ "</tr>"
				+ "</thead>"
				+ "<tbody>";
		
		try {
			while(this.results.next()) {
				
				
				table += "<tr>"
						+ "<td>"
						+ results.getString("username")
						+ "</td>"
						+ "<td>"
						+ results.getString("celno")
						+ "</td>"
						+ "<td>"
						+ results.getString("email")
						+ "</td>"
						+ "<td>"
						+ results.getString("name")
						+ "</td>"
						+ "<td>"
						+ results.getString("address")
						+ "</td>"
						+ "<td>"
						+ getString(results.getString("serialno"))
						+ "</td>"
						+ "<td>"
						+ getString(results.getString("productname"))
						+ "</td>"
						+ "<td>"
						+ getString(results.getString("model"))
						+ "</td>"
						+ "<td>"
						+ getString(results.getString("dateofclaim"))
						+ "</td>"
						+ "<td>"
						+ getString(results.getString("description"))
						+ "</td>"
						+ "<td>"
						+ getApprovalStatusDesc(results.getString("approvalstatus"))
						+ "</td>"
				;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.getLogger(AReportsDao.class.getName()).log(Level.SEVERE, "Error");
		}
		
		table += "</tbody>"
				+ "</table>";
		
		return table;
		
	}
	
	private String getApprovalStatusDesc (String i) {
		if (i == null) 
			return "";
		else if (i.equals("0"))
			return "Rejected";
		else if (i.equals("1"))
			return "Approved";
		else 
			return "Pending";

	}
	
	private String getString (String s) {
		
		if (s == null)
			return "";
		return s;
	}

	
	
}
