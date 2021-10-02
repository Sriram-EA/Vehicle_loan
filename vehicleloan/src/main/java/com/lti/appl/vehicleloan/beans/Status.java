package com.lti.appl.vehicleloan.beans;

public class Status {
 
	private String userName;

	public Status() {
		super();
	}

	public Status(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Status [userName=" + userName + "]";
	}
	
}
