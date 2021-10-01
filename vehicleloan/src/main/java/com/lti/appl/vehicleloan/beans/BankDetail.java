package com.lti.appl.vehicleloan.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_DETAILS")
public class BankDetail {

	@Id
	@Column(name="BANK_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="BANK_DETAILS_SEQUENCE")
	@SequenceGenerator(name="BANK_DETAILS_SEQUENCE",sequenceName="BANK_DETAILS_SEQUENCE",allocationSize=1)
	private int bankId;
	@Column(name="ACCOUNT_NUMBER")
	private int accountNumber;
	@Column(name="IFSC_CODE")
	private String ifscCode;
	@Column(name="BANK_BRANCH")
	private String bankBranch;
	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private UserRegistration userId;

	public BankDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankDetail(int accountNumber, String ifscCode, String bankBranch, String accountType,
			UserRegistration userId) {
		super();
		this.bankId = bankId;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.bankBranch = bankBranch;
		this.accountType = accountType;
		this.userId = userId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public UserRegistration getUserId() {
		return userId;
	}

	public void setUserId(UserRegistration userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BankDetail \n [bankId=" + bankId + ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode
				+ ", bankBranch=" + bankBranch + ", accountType=" + accountType + ", userId=" + userId + "]";
	}
	
	
	
	
	
	
	
}