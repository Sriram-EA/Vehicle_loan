package com.lti.appl.vehicleloan.beans;

public class EligibilityChecker {


	private String applicantName;
	private int vehicleId;
	private String vehicleType;
	private long showRoomPrice;
	private long onRoadPrice;
	private float interest;
	private int age;
	private String gender;
	private String typeOfEmployment;
	private long annualIncome;
	private long existingEmi;
	private String eligibilityStatus;
	
	
	
	public EligibilityChecker() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EligibilityChecker(String applicantName, int vehicleId, String vehicleType, long showRoomPrice,
			long onRoadPrice, float interest, int age, String gender, String typeOfEmployment, long annualIncome,
			long existingEmi, String eligibilityStatus) {
		super();
		this.applicantName = applicantName;
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.showRoomPrice = showRoomPrice;
		this.onRoadPrice = onRoadPrice;
		this.interest = interest;
		this.age = age;
		this.gender = gender;
		this.typeOfEmployment = typeOfEmployment;
		this.annualIncome = annualIncome;
		this.existingEmi = existingEmi;
		this.eligibilityStatus = eligibilityStatus;
	}



	public String getApplicantName() {
		return applicantName;
	}



	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}



	public int getVehicleId() {
		return vehicleId;
	}



	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}



	public String getVehicleType() {
		return vehicleType;
	}



	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}



	public long getShowRoomPrice() {
		return showRoomPrice;
	}



	public void setShowRoomPrice(long showRoomPrice) {
		this.showRoomPrice = showRoomPrice;
	}



	public long getOnRoadPrice() {
		return onRoadPrice;
	}



	public void setOnRoadPrice(long onRoadPrice) {
		this.onRoadPrice = onRoadPrice;
	}



	public float getInterest() {
		return interest;
	}



	public void setInterest(float interest) {
		this.interest = interest;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getTypeOfEmployment() {
		return typeOfEmployment;
	}



	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}



	public long getAnnualIncome() {
		return annualIncome;
	}



	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}



	public long getExistingEmi() {
		return existingEmi;
	}



	public void setExistingEmi(long existingEmi) {
		this.existingEmi = existingEmi;
	}



	public String getEligibilityStatus() {
		return eligibilityStatus;
	}



	public void setEligibilityStatus(String eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}



	@Override
	public String toString() {
		return "EligibilityChecker [applicantName=" + applicantName + ", vehicleId=" + vehicleId + ", vehicleType="
				+ vehicleType + ", showRoomPrice=" + showRoomPrice + ", onRoadPrice=" + onRoadPrice + ", interest="
				+ interest + ", age=" + age + ", gender=" + gender + ", typeOfEmployment=" + typeOfEmployment
				+ ", annualIncome=" + annualIncome + ", existingEmi=" + existingEmi + ", eligibilityStatus="
				+ eligibilityStatus + "]";
	}
	
	
	
}
