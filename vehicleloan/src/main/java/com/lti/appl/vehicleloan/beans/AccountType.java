package com.lti.appl.vehicleloan.beans;

public class AccountType {

	private int bankId;
	private String accountNumber;
	private String accountType;
	private int userID;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public AccountType(int bankId, String accountNumber, String accountType, int userID) {
		super();
		this.bankId = bankId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.userID = userID;
	}
	public AccountType() {
		super();
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "AccountType [bankId=" + bankId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", userID=" + userID + "]";
	}
	
	
}