package com.lti.appl.vehicleloan.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.ApplicationDetails;
import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.EmiDetail;
import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.beans.FetchDetail;
import com.lti.appl.vehicleloan.beans.Report;
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
	@Override
	public FetchDetail fetch(int userId, int vehicleId, int empId,int bankId,int principle,int tenure,int emi) {
		UserRegistration ur = em.find(UserRegistration.class, userId);
		Vehicle vh = em.find(Vehicle.class, vehicleId);
		Employment e = em.find(Employment.class, empId);
		BankDetail bd = em.find(BankDetail.class, bankId);
		FetchDetail fd = new FetchDetail(vh.getVehicleType(),vh.getVehicleModel(),vh.getVehicleBrand(),vh.getInterest(),e.getEmploymentType(),e.getAnnualSalary(),ur.getFirstName(),ur.getLastName(),ur.getEmailId(),bd.getIfscCode(),bd.getBankBranch(),emi,principle,tenure,bd.getAccountNumber(),bd.getAccountType());
		System.out.println(fd);
		return fd;
	}

	@Transactional
	@Override
	public String fill(ApplicationDetails app, int userId, int vehicleId, int empId, int bankId, int principle,
			int tenure, int emi) {
		UserRegistration ur = em.find(UserRegistration.class, userId);
		Vehicle vh = em.find(Vehicle.class, vehicleId);
		Employment emp = em.find(Employment.class, empId);
		BankDetail bd = em.find(BankDetail.class, bankId);
		EmiDetail emidetail = new EmiDetail();
		emidetail.setPrinciple(principle);
		emidetail.setTenure(tenure);
		emidetail.setEmi(emi);
		emidetail.setEmployment(emp);
		emidetail.setUser(ur);
		emidetail.setVehicle(vh);
		System.out.println(emidetail);
		em.persist(emidetail);
		System.out.println("Emi added");
		int emiId= emidetail.getEmiId();
		EmiDetail ed = em.find(EmiDetail.class, emiId);
		ApplicationForm appl = new ApplicationForm();
		appl.setAge(app.getAge());
		appl.setGender(app.getGender());
		appl.setMobileNo(app.getMobileNumber());
		appl.setAddress(app.getAddress());
		appl.setCity(app.getCity());
		appl.setState(app.getState());
		appl.setPincode(app.getPinCode());
		appl.setUserRegistration(ur);
		appl.setVehicle(vh);
		appl.setEmi(ed);
		appl.setEmp(emp);
		appl.setBank(bd); 
		appl.setStatus("PENDING");
		System.out.println("App"+appl);
		em.persist(appl);
		return "Application Uploaded";
	} 
	
	// Sonali's Part 
	
	@Transactional
	@Override
	public Boolean updateStatusApprove(int applicationId) {
		
			// TODO Auto-generated method stub
		    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			ApplicationForm updateStatusApprove=em.find(ApplicationForm.class,applicationId);
			
			String updateString="update ApplicationForm set status=:status where applicationId=:applicationId";	
			Query qry=em.createQuery(updateString);
			qry.setParameter("status","APPROVED");
			qry.setParameter("applicationId",applicationId);
			int i=qry.executeUpdate();
			
			String updateApprovalDate="update ApplicationForm set approvalDate=:approvalDate where applicationId=:applicationId";
			Query q=em.createQuery(updateApprovalDate);
			q.setParameter("approvalDate",date);
			q.setParameter("applicationId",applicationId);
			int j=q.executeUpdate();  
			
			String emi="select a from ApplicationForm a where a.applicationId="+ applicationId;
			Query emiQry=em.createQuery(emi);
			ApplicationForm a=(ApplicationForm) emiQry.getSingleResult(); 
			int emiId=a.getEmi().getEmiId();
			
			EmiDetail emiDetail=em.find(EmiDetail.class,emiId);
			emiDetail.setEmiStartDate(date); 
			em.merge(emiDetail);
			
			if(i==1 && j==1)
			return true;
		return false;
	}
 
	@Transactional
	@Override
	public Boolean updateStatusReject(int applicationId) {
		
		
		ApplicationForm updateStatusReject=em.find(ApplicationForm.class,applicationId);	
		String updateString="update ApplicationForm set status=:status where applicationId=:applicationId";
		
		Query qry=em.createQuery(updateString);
		
		
		qry.setParameter("status","REJECTED");
		qry.setParameter("applicationId",applicationId);
		int i=qry.executeUpdate(); 
		
		String updateApprovalDate="update ApplicationForm set approvalDate=:approvalDate where applicationId=:applicationId";
		Query q=em.createQuery(updateApprovalDate);
		q.setParameter("approvalDate",null);
		q.setParameter("applicationId",applicationId);
		int j=q.executeUpdate();
		
		if(i==1 && j==1)
		return true;
		return false;
	} 
	
	@Override
	public List<ApplicationForm> getApprovedList() {
		String sql="select a from ApplicationForm a where a.status=:status";
		Query qry=em.createQuery(sql);
		qry.setParameter("status", "APPROVED");
		List<ApplicationForm> rep=qry.getResultList();
		
		return rep;
	} 
	
	@Override
	public List<ApplicationForm> getRejectedList() {
		String sql="select a from ApplicationForm a where a.status=:status";
		Query qry=em.createQuery(sql);
		qry.setParameter("status", "REJECTED");
		List<ApplicationForm> rep=qry.getResultList();
		
		return rep;
	}
}