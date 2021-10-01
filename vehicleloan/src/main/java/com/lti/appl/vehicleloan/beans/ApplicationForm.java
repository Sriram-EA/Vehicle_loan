package com.lti.appl.vehicleloan.beans;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="APPLICATION_FORMS")
public class ApplicationForm {
	@Id
	@Column(name="APPLICATION_ID ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPLICATION_FORMS_SEQUENCE ")
	@SequenceGenerator(name="APPLICATION_FORMS_SEQUENCE ", sequenceName="APPLICATION_FORMS_SEQUENCE ",allocationSize=1)
	private int applicationId;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="MOBILE_NO")
	private String mobileNo;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PINCODE")
	private String pincode;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="APPROVAL_DATE")
	private Date approvalDate;
	
	@Column(name="ADMIN_ID")
	private Integer adminId;
	
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinColumn(name="USER_ID")
	private UserRegistration userRegistration;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinColumn(name="EMI_ID")
	private EmiDetail emis;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinColumn(name="EMPLOYMENT_ID")
	private Employment emp;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinColumn(name="BANK_ID")
	private BankDetail bank;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getAge() {
		return age;
	}

	public ApplicationForm(int applicationId, String status) {
		super();
		this.applicationId = applicationId;
		this.status = status;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Date getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}

	public EmiDetail getEmis() {
		return emis;
	}

	public void setEmis(EmiDetail emis) {
		this.emis = emis;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public EmiDetail getEmi() {
		return emis;
	}

	public void setEmi(EmiDetail emi) {
		this.emis = emi;
	}

	public Employment getEmp() {
		return emp;
	}

	public void setEmp(Employment emp) {
		this.emp = emp;
	}

	public BankDetail getBank() {
		return bank;
	}

	public void setBank(BankDetail bank) {
		this.bank = bank;
	}

	public ApplicationForm(int applicationId, int age, String gender, String mobileNo, String address, String city,
			String state, String pincode, String status, Date approvalDate, Integer adminId,
			UserRegistration userRegistration, Vehicle vehicle, EmiDetail emis, Employment emp, BankDetail bank) {
		super();
		this.applicationId = applicationId;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.status = status;
		this.approvalDate = approvalDate;
		this.adminId = adminId;
		this.userRegistration = userRegistration;
		this.vehicle = vehicle;
		this.emis = emis;
		this.emp = emp;
		this.bank = bank;
	}

	public ApplicationForm() {
		super();
	}

	@Override
	public String toString() {
		return "ApplicationForm [applicationId=" + applicationId + ", age=" + age + ", gender=" + gender + ", mobileNo="
				+ mobileNo + ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", status=" + status + ", approvalDate=" + approvalDate + ", adminId=" + adminId
				+ ", userRegistration=" + userRegistration + ", vehicle=" + vehicle + ", emis=" + emis + ", emp=" + emp
				+ ", bank=" + bank + "]";
	}

	

}
