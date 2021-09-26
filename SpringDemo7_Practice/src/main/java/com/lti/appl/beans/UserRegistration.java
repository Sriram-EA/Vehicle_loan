package com.lti.appl.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_REGISTRATIONS")
public class UserRegistration {  
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_REGISTRATIONS_SEQUENCE")
	@SequenceGenerator(name="USER_REGISTRATIONS_SEQUENCE", sequenceName="USER_REGISTRATIONS_SEQUENCE",allocationSize=1)
	@Column(name="USER_ID")
	private int userID;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="USER_ADMIN")
	private int userAdminStatus; 
	

	public UserRegistration() {
		super();
	}

	public UserRegistration(String firstName, String lastName, String emailId, String password, int userAdminStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.userAdminStatus = userAdminStatus;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserAdminStatus() {
		return userAdminStatus;
	}

	public void setUserAdminStatus(int userAdminStatus) {
		this.userAdminStatus = userAdminStatus;
	}

	@Override
	public String toString() {
		return "UserRegistration [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", password=" + password + ", userAdminStatus=" + userAdminStatus + "]";
	}
	
	
	
	
	
	

}
