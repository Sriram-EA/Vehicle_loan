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
	
	public VehicleServiceImpl() {
		super();
	}

	public VehicleServiceImpl(VehicleDao vehicleDao) {
		super();
		this.vehicleDao = vehicleDao;
	}

	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

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

}
