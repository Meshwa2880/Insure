package model;

import java.sql.Date;

public class Claim {

	private int id;
	private String username;
	private String serialno;
	private Date dateofclaim;
	private String descriptions;
	private int approvalstatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSerialno() {
		return serialno;
	}
	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public Date getDateofclaim() {
		return dateofclaim;
	}
	public void setDateofclaim(Date dateofclaim) {
		this.dateofclaim = dateofclaim;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public int getApprovalstatus() {
		return approvalstatus;
	}
	public void setApprovalstatus(int approvalstatus) {
		this.approvalstatus = approvalstatus;
	}
	@Override
	public String toString() {
		return "Claim [id=" + id + ", username=" + username + ", serialno=" + serialno + ", dateofclaim=" + dateofclaim
				+ ", descriptions=" + descriptions + ", approvalstatus=" + approvalstatus + "]";
	}
}
