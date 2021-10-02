package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.Vehicle;

public interface VehicleDao {

	public abstract List<Vehicle> getAllVehicles();
	public abstract Vehicle getVehicleById(int vehicleId);
	public abstract List<Vehicle> getTwoWheelerVehicles();
	public abstract List<Vehicle> getThreeWheelerVehicles(); 
	public abstract List<Vehicle> getFourWheelerVehicles();
}
