package com.lti.appl.vehicleloan.services;

import java.util.List;

import com.lti.appl.vehicleloan.beans.Vehicle;

public interface VehicleService { 
	
	public abstract List<Vehicle> getAllVehicles();
	public abstract Vehicle getVehicleById(int vehicleId);
	public abstract List<Vehicle> getTwoWheelerVehicles();
	public abstract List<Vehicle> getThreeWheelerVehicles(); 
	public abstract List<Vehicle> getFourWheelerVehicles();

}
