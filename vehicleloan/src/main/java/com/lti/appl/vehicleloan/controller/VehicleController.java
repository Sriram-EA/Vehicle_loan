package com.lti.appl.vehicleloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.Vehicle;
import com.lti.appl.vehicleloan.services.VehicleServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/vehicle")
public class VehicleController { 
	
	@Autowired
	private VehicleServiceImpl vehicleService;  
	
	//http://localhost:8090/vehicle/allvehicles
	@GetMapping("/allvehicles") 
	public List<Vehicle> getAllVehicles()
	{
		List<Vehicle> vehicleList=vehicleService.getAllVehicles(); 
		return vehicleList;
	}
	
	//http://localhost:8090/vehicle/vehiclebyid/101
	@GetMapping("/vehiclebyid/{id}") 
	public Vehicle getVehicleById(@PathVariable(value="id") int vehicleId)
	{
		Vehicle vehicleDetail=vehicleService.getVehicleById(vehicleId);
		return vehicleDetail;
	}

}
