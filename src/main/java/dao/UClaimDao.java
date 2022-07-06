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
import model.UserProduct;

public class UClaimDao {
	private static Connection connection;
	private ResultSet results;

	public UClaimDao() throws ClassNotFoundException, SQLException {

		InputStream inputStream = getClass().getResourceAsStream("property.txt");

		Properties prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = prop.getProperty("username");
		String driver = prop.getProperty("driver");
		String server = prop.getProperty("server");
		String password = prop.getProperty("password");
		Class.forName(driver);
		connection = DriverManager.getConnection(server, username, password);
	}

	public void doReadClaim(String serialno, String username) {
		try {
			String query = "Select * from claim where serialno = ? and username = ?;";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, serialno);
			ps.setString(2, username);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(UProductDao.class.getName()).log(Level.SEVERE,
					"Cannot Establish Connection");
		}
	}

	public String getHTMLTable() throws SQLException {
		String tableClaim = "";
		tableClaim += "<table width=100% border=1 style='border-collapse: collapse;text-align:center'>";
		tableClaim +=  "<thead>";
		tableClaim +=   "<tr>";
		tableClaim +=  "<th>Date Of Claim</th>";
		tableClaim +=  "<th>Description</th>";
		tableClaim +=  "<th>Approval Status</th>";
		tableClaim +=  "</thead>";
		if (this.results == null) {
			return "<p>no claim</p>";
		} else {
			while (this.results.next()) {
				Claim claim = new Claim();
				claim.setUsername(this.results.getString("username"));
				claim.setSerialno(this.results.getString("serialno"));
				claim.setDateofclaim(this.results.getDate("dateofclaim"));
				claim.setDescriptions(this.results.getString("description"));
				claim.setApprovalstatus(this.results.getInt("approvalstatus"));
				tableClaim += "<tr>";
				tableClaim += "<td>";
				tableClaim += claim.getDateofclaim();
				tableClaim += "</td>";
				tableClaim += "<td>";
				tableClaim += claim.getDescriptions();
				tableClaim += "</td>";
				tableClaim += "<td>";
//				tableClaim += claim.getApprovalstatus();
				if(claim.getApprovalstatus() == 2)
				{
					tableClaim += "Pending";
				}
				else if(claim.getApprovalstatus() == 1)
				{
					tableClaim += "Approved";
				}
				else
				{
					tableClaim += "Rejected";
				}
				tableClaim += "</td>";
				tableClaim += "</tr>";
			}
			tableClaim += "</table>";
		}
		return tableClaim;

	}
}
