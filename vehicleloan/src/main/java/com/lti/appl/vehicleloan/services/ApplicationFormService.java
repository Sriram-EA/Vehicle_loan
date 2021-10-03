package com.lti.appl.vehicleloan.services;

import java.util.List;

import com.lti.appl.vehicleloan.beans.ApplicationDetails;
import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.EmiDetail;
import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.beans.FetchDetail;
import com.lti.appl.vehicleloan.beans.Report;
import com.lti.appl.vehicleloan.beans.UserRegistration;
import com.lti.appl.vehicleloan.beans.Vehicle;

public interface ApplicationFormService {
	public abstract String fillApplication(ApplicationForm a,int userId,int vehicleId,int emiId,int empId,int bankId);
	public abstract ApplicationForm getApplicationById(int appId);
	public abstract List<ApplicationForm> getApplicationStatusById(int userId);
	//public abstract fillApplicationForm(ApplicationForm a,Bank b,EmiDetail emi,) 
	public abstract List<ApplicationForm> getApplicationList(); 
	public abstract FetchDetail fetch(int userId,int vehicleId,int empId,int bankId,int principle,int tenure,int emi);
	public abstract String fill(ApplicationDetails app,int userId,int vehicleId,int empId, int bankId,int principle,int tenure,int emi);
	public abstract Boolean updateStatusApprove(int applicationId);
	public abstract Boolean updateStatusReject(int applicationId); 
	
public abstract List<ApplicationForm> getApprovedList();
	
	public abstract List<ApplicationForm> getRejectedList();
}