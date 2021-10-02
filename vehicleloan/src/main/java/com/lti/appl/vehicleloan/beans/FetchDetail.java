package com.lti.appl.vehicleloan.beans;

public class FetchDetail {

	private String vehicleType;
	private String vehicleModel;
	private String vehicleBrand;
	private int interest;
	private String employmentType;
	private int annualSalary;
	private String firstName;
	private String lastName;
	private String mailId;
	private String ifscCode;
	private String bankBranch;
	private int emi;
	private int principle;
	private int tenure;
	private int accountNumber;
	private String accountType;
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public int getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
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
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public int getPrinciple() {
		return principle;
	}
	public void setPrinciple(int principle) {
		this.principle = principle;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
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
		return "FetchDetail [vehicleType=" + vehicleType + ", vehicleModel=" + vehicleModel + ", vehicleBrand="
				+ vehicleBrand + ", interest=" + interest + ", employmentType=" + employmentType + ", annualSalary="
				+ annualSalary + ", firstName=" + firstName + ", lastName=" + lastName + ", mailId=" + mailId
				+ ", ifscCode=" + ifscCode + ", bankBranch=" + bankBranch + ", emi=" + emi + ", principle=" + principle
				+ ", tenure=" + tenure + ", accountNumber=" + accountNumber + ", accountType=" + accountType + "]";
	}
	public FetchDetail(String vehicleType, String vehicleModel, String vehicleBrand, int interest,
			String employmentType, int annualSalary, String firstName, String lastName, String mailId, String ifscCode,
			String bankBranch, int emi, int principle, int tenure, int accountNumber, String accountType) {
		super();
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.vehicleBrand = vehicleBrand;
		this.interest = interest;
		this.employmentType = employmentType;
		this.annualSalary = annualSalary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.ifscCode = ifscCode;
		this.bankBranch = bankBranch;
		this.emi = emi;
		this.principle = principle;
		this.tenure = tenure;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	public FetchDetail() {
		super();
	}
	
	
	
}
