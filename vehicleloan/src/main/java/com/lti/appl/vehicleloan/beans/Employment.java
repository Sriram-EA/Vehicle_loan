package com.lti.appl.vehicleloan.beans;
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
@Table(name="EMPLOYMENTS")
public class Employment {
	
	@Id
	@Column(name="EMPLOYMENT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYMENTS_SEQUENCE")
	@SequenceGenerator(name="EMPLOYMENTS_SEQUENCE", sequenceName="EMPLOYMENTS_SEQUENCE",allocationSize=1)
	private int employmentId;
	
	@Column(name="EMPLOYMENT_TYPE")
	private String employmentType;
	
	@Column(name="ANNUAL_SALARY")
	private int annualSalary;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL) 
	@JoinColumn(name="USER_ID")
	private UserRegistration userRegistration;
	
	public Employment() {
		super();
	}

	public Employment(String employmentType, int annualSalary, UserRegistration userRegistration) {
		super();
		this.employmentType = employmentType;
		this.annualSalary = annualSalary;
		this.userRegistration = userRegistration;
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

	public UserRegistration getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(UserRegistration userRegistration) {
		this.userRegistration = userRegistration;
	}

	@Override
	public String toString() {
		return "Employment [employmentId=" + employmentId + ", employmentType=" + employmentType + ", annualSalary="
				+ annualSalary + ", userRegistration=" + userRegistration + "]";
	}

}
