package com.lti.appl.vehicleloan.beans;

public class ApplicationDetails {

	
	private int age;
	private String gender;
	private String mobileNumber;
	private String address;
	private String state;
	private String city;
	private String pinCode;
	public ApplicationDetails() {
		super();
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public ApplicationDetails(int age, String gender, String mobileNumber, String address, String state, String city,
			String pinCode) {
		super();
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "ApplicationDetails [age=" + age + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", state=" + state + ", city=" + city + ", pinCode=" + pinCode + "]";
	}
	
	
	
}