package com.lti.appl.vehicleloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao{
 
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Vehicle> getAllVehicles() {
		
		String str="select v from Vehicle v";
		Query qry=em.createQuery(str);
		List<Vehicle> vehicleList=qry.getResultList();
		return vehicleList;
	}

	@Override
	public Vehicle getVehicleById(int vehicleId) {
		
		Vehicle vehicleDetail=em.find(Vehicle.class,vehicleId);
		return vehicleDetail;
	}

}
