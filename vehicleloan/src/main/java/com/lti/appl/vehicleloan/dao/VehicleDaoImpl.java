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
	
	@Override
	public List<Vehicle> getTwoWheelerVehicles() {
		// TODO Auto-generated method stub
		String twoWheelerSQL="select twoWheeler from Vehicle twoWheeler where twoWheeler.vehicleType='2W'";
		
		Query twoWheeler=em.createQuery(twoWheelerSQL);
	
		List<Vehicle> twoWheelerVehicleList=twoWheeler.getResultList();
		
		return twoWheelerVehicleList;
	}

	@Override
	public List<Vehicle> getThreeWheelerVehicles() {
String threeWheelerSQL="select twoWheeler from Vehicle twoWheeler where twoWheeler.vehicleType='3W'";
		
		Query threeWheeler=em.createQuery(threeWheelerSQL);
	
		List<Vehicle> threeWheelerVehicleList=threeWheeler.getResultList();
		
		return threeWheelerVehicleList;
	}

	@Override
	public List<Vehicle> getFourWheelerVehicles() {
String fourWheelerSQL="select twoWheeler from Vehicle twoWheeler where twoWheeler.vehicleType='4W'";
		
		Query fourWheeler=em.createQuery(fourWheelerSQL);
	
		List<Vehicle> fourWheelerVehicleList=fourWheeler.getResultList();
		
		return fourWheelerVehicleList;
	}

}
