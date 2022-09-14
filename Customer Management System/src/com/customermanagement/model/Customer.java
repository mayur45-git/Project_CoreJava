package com.customermanagement.model;

public class Customer {
	
	private int cid;
	private String cname;
	private int cage;
	private long cmobno;
	private boolean status;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public long getCmobno() {
		return cmobno;
	}
	public void setCmobno(long cmobno) {
		this.cmobno = cmobno;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

}
