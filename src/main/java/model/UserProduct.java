package model;

import java.sql.Date;

public class UserProduct {
	private int productid;
	private String username;
	private String serialno;
	private Date purchasedate;
	private String productname;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
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
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	@Override
	public String toString() {
		return "UserProduct [productid=" + productid + ", username=" + username + ", serialno=" + serialno
				+ ", purchasedate=" + purchasedate + ", productname=" + productname + "]";
	}
		

}
