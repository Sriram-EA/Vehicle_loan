package com.lti.appl.vehicleloan.beans;

public class EmailStatus { 
	
	private String emailStatus;

	public EmailStatus() {
		super();
	}

	public String getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(String emailStatus) {
		this.emailStatus = emailStatus;
	}

	public EmailStatus(String emailStatus) {
		super();
		this.emailStatus = emailStatus;
	}

	@Override
	public String toString() {
		return "EmailStatus [emailStatus=" + emailStatus + "]";
	}
	
	

}
