package com.lti.appl.vehicleloan.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="VEHICLES")
public class Vehicle {  
	
	@Id
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@Column(name="VEHICLE_BRAND")
	private String vehicleBrand; 
	
	@Column(name="VEHICLE_MODEL")
	private String vehicleModel; 
	
	@Column(name="SHOWROOM_PRICE")
	private int showroomPrice;
	
	@Column(name="ONROAD_PRICE")
	private int onroadPrice;
	
	@Column(name="INTEREST")
	private int interest;

	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleId, String vehicleType, String vehicleBrand, String vehicleModel, int showroomPrice,
			int onroadPrice, int interest) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.showroomPrice = showroomPrice;
		this.onroadPrice = onroadPrice;
		this.interest = interest;
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

	public int getShowroomPrice() {
		return showroomPrice;
	}

	public void setShowroomPrice(int showroomPrice) {
		this.showroomPrice = showroomPrice;
	}

	public int getOnroadPrice() {
		return onroadPrice;
	}

	public void setOnroadPrice(int onroadPrice) {
		this.onroadPrice = onroadPrice;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", vehicleBrand=" + vehicleBrand
				+ ", vehicleModel=" + vehicleModel + ", showroomPrice=" + showroomPrice + ", onroadPrice=" + onroadPrice
				+ ", interest=" + interest + "]";
	}

	
	

}
