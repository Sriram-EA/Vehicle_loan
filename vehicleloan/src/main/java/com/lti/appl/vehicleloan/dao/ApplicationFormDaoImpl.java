package com.lti.appl.vehicleloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.EmiDetail;
import com.lti.appl.vehicleloan.beans.Employment;

import com.lti.appl.vehicleloan.beans.UserRegistration;
import com.lti.appl.vehicleloan.beans.Vehicle;

@Repository
public class ApplicationFormDaoImpl implements ApplicationFormDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public String fillApplication(ApplicationForm a,int userId,int vehicleId,int emiId,int empId,int bankId)
	 {
		UserRegistration user = em.find(UserRegistration.class, userId);
		Vehicle vehicle = em.find(Vehicle.class, vehicleId);
		EmiDetail emi = em.find(EmiDetail.class, emiId);
		Employment emp = em.find(Employment.class, empId);
		BankDetail bank = em.find(BankDetail.class, bankId);
		ApplicationForm appForm = new ApplicationForm(a.getApplicationId(),a.getAge(),a.getGender(),a.getMobileNo(),a.getAddress(),a.getCity(),a.getState(),a.getPincode(),a.getStatus(),a.getApprovalDate(),a.getAdminId(),user,vehicle,emi,emp,bank);
		em.persist(appForm);
		return "Application Filled";
	}

	@Override
	public ApplicationForm getApplicationById(int appId) {
		ApplicationForm app = em.find(ApplicationForm.class, appId);
		
		return app;
	}

	@Override
	public List<ApplicationForm> getApplicationStatusById(int userId) {
		String str="Select a from ApplicationForm a where a.userRegistration.userID=:userId";		
		Query qry = em.createQuery(str);
		qry.setParameter("userId",userId);
		List<ApplicationForm> applist =  qry.getResultList();
		//System.out.println(applist);
		//ApplicationForm appStatus = new ApplicationForm(app.getApplicationId(),app.getStatus());
		//GetStatus status = new GetStatus(appStatus.getApplicationId(),appStatus.getStatus());
		//List<GetStatus> statuslist = 
		
		//System.out.println(applist.toString());
		return applist;
	} 
	
	@Override
	public List<ApplicationForm> getApplicationList() {
		
		String str="Select a from ApplicationForm a";
		Query qry = em.createQuery(str); 
		
		List<ApplicationForm> applist =  qry.getResultList();
		return applist;
	}
	
	

}