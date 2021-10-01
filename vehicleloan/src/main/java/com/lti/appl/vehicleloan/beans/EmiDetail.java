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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMI_DETAILS")
public class EmiDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMI_DETAILS_SEQUENCE")
	@SequenceGenerator(name = "EMI_DETAILS_SEQUENCE", sequenceName = "EMI_DETAILS_SEQUENCE", allocationSize = 1)
	@Column(name = "EMI_ID")
	private int emiId;

	@Column(name = "PRINCIPLE")
	private int principle;

	@Column(name = "TENURE")
	private int tenure;

	@Column(name = "EMI")
	private int emi;

	@Column(name = "EMI_STARTDATE")
	private Date emiStartDate;

	@Column(name = "EMI_ENDDATE")
	private Date emiEndDate;


	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private UserRegistration user;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMPLOYMENT_ID")
	private Employment employment;

	public EmiDetail(int emiId, int principle, int tenure, int emi, Date emiStartDate, Date emiEndDate,
			UserRegistration user, Vehicle vehicle, Employment employment) {
		super();
		this.emiId = emiId;
		this.principle = principle;
		this.tenure = tenure;
		this.emi = emi;
		this.emiStartDate = emiStartDate;
		this.emiEndDate = emiEndDate;
		this.user = user;
		this.vehicle = vehicle;
		this.employment = employment;
	}

	public EmiDetail() {
		super();
	}

	public int getEmiId() {
		return emiId;
	}

	public void setEmiId(int emiId) {
		this.emiId = emiId;
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

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public Date getEmiStartDate() {
		return emiStartDate;
	}

	public void setEmiStartDate(Date emiStartDate) {
		this.emiStartDate = emiStartDate;
	}

	public Date getEmiEndDate() {
		return emiEndDate;
	}

	public void setEmiEndDate(Date emiEndDate) {
		this.emiEndDate = emiEndDate;
	}

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	@Override
	public String toString() {
		return "EmiDetail [emiId=" + emiId + ", principle=" + principle + ", tenure=" + tenure + ", emi=" + emi
				+ ", emiStartDate=" + emiStartDate + ", emiEndDate=" + emiEndDate + ", user=" + user + ", vehicle="
				+ vehicle + ", employment=" + employment + "]";
	}

}