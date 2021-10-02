package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.ApplicationDetails;
import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.EmiDetail;
import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.beans.FetchDetail;
import com.lti.appl.vehicleloan.beans.UserRegistration;
import com.lti.appl.vehicleloan.beans.Vehicle;
import com.lti.appl.vehicleloan.dao.ApplicationFormDao;
import com.lti.appl.vehicleloan.dao.ApplicationFormDaoImpl;


@Service("applicationService")
public class ApplicationFormServiceImpl implements ApplicationFormService {

	@Autowired
	private ApplicationFormDao applicationFormDao; 
	
	@Override
	public String fillApplication(ApplicationForm a,int userId,int vehicleId,int emiId,int empId,int bankId) {
		String applicationFill = applicationFormDao.fillApplication(a, userId, vehicleId, emiId, empId, bankId);
		return applicationFill;
	}

	@Override
	public ApplicationForm getApplicationById(int appId) {
		// TODO Auto-generated method stub
		return applicationFormDao.getApplicationById(appId);
	}

	@Override
	public List<ApplicationForm> getApplicationStatusById(int userId) {
		
		return applicationFormDao.getApplicationStatusById(userId);
	} 
	
	@Override
	public List<ApplicationForm> getApplicationList() {
		
		List<ApplicationForm> app= (List<ApplicationForm>) applicationFormDao.getApplicationList();
		return app;
	} 
	
	@Override
	public  FetchDetail fetch(int userId,int vehicleId,int empId,int bankId,int principle,int tenure,int emi) {
		// TODO Auto-generated method stub
		return applicationFormDao.fetch(userId, vehicleId, empId,bankId,principle,tenure,emi);
	}

	@Override
	public String fill(ApplicationDetails app, int userId, int vehicleId, int empId, int bankId, int principle,
			int tenure, int emi) {
		// TODO Auto-generated method stub
		return applicationFormDao.fill(app, userId, vehicleId, empId, bankId, principle, tenure, emi);
	}

}