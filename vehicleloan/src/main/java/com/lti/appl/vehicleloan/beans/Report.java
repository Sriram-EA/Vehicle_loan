package com.lti.appl.vehicleloan.beans;

public class Report {
	
    private String firstName;
    private String lastName;
    private String emailId;
    private String vehicleType;
    private String vehicleBrand;
    private String vehicleModel;
    private String employmentType;
    private int annualSalary;
    private int emi;
	private String accountType;
	private String status; 
	
	
	public Report() {
		super();
	}
	
	
	
	public Report(String firstName, String lastName, String emailId, String vehicleType, String vehicleBrand,
			String vehicleModel, String employmentType, int annualSalary, int emi, String accountType, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.employmentType = employmentType;
		this.annualSalary = annualSalary;
		this.emi = emi;
		this.accountType = accountType;
		this.status = status;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
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
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Report [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + ", vehicleType="
				+ vehicleType + ", vehicleBrand=" + vehicleBrand + ", vehicleModel=" + vehicleModel
				+ ", employmentType=" + employmentType + ", annualSalary=" + annualSalary + ", emi=" + emi
				+ ", accountType=" + accountType + ", status=" + status + "]";
	}




}