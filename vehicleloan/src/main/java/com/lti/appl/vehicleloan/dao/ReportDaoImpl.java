package com.lti.appl.vehicleloan.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.Report;

@Repository
public class ReportDaoImpl implements ReportDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Report getReport(int applicationId) {
		
		System.out.println("Inside dao layer"); 
		System.out.println(applicationId);
//		String sql="Select a.userRegistration.firstName from ApplicationForm a where a.applicationId=:appId ";
		
		ApplicationForm a=em.find(ApplicationForm.class, applicationId);
		String firstName=a.getUserRegistration().getFirstName();
		System.out.println("firstname"+firstName);
		String lastName=a.getUserRegistration().getLastName();
		System.out.println("lastname"+lastName);
		String email=a.getUserRegistration().getEmailId(); 
		System.out.println("email"+email);
		
		String vehicleType=a.getVehicle().getVehicleType();
		String vehicleBrand=a.getVehicle().getVehicleBrand();
		String vehicleModel=a.getVehicle().getVehicleModel();
		String employmentType=a.getEmp().getEmploymentType();
		int annualSalary=a.getEmp().getAnnualSalary();
		int emi=a.getEmi().getEmi();
		String accountType=a.getBank().getAccountType(); 
		System.out.println("firstname"+firstName);
		System.out.println("lastname"+lastName);
		System.out.println("email"+email);
				
		
	    Report report=new Report(firstName,lastName,email,vehicleType,vehicleBrand,vehicleModel,employmentType,annualSalary,emi,accountType);
		return report;
	}

}