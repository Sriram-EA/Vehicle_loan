package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.Vehicle;
import com.lti.appl.vehicleloan.dao.VehicleDao;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService{
 
	@Autowired
	private VehicleDao vehicleDao; 
	


	@Override
	public List<Vehicle> getAllVehicles() {
		
		List<Vehicle> vehicleList = vehicleDao.getAllVehicles();
		return vehicleList;
	}

	@Override
	public Vehicle getVehicleById(int vehicleId) {
		
		Vehicle vehicleDetail=vehicleDao.getVehicleById(vehicleId);
		return vehicleDetail;
	} 
	
	@Override
	public List<Vehicle> getTwoWheelerVehicles() {
		// TODO Auto-generated method stub
		List<Vehicle> threeWheelerVehicleList=vehicleDao.getTwoWheelerVehicles(); 
		return threeWheelerVehicleList;
		
		
	}

	@Override
	public List<Vehicle> getThreeWheelerVehicles() {
		List<Vehicle> threeWheelerVehicleList=vehicleDao.getThreeWheelerVehicles(); 
		return threeWheelerVehicleList;
	}

	@Override
	public List<Vehicle> getFourWheelerVehicles() {
		List<Vehicle> threeWheelerVehicleList=vehicleDao.getFourWheelerVehicles(); 
		return threeWheelerVehicleList;
	}
	
	

}
