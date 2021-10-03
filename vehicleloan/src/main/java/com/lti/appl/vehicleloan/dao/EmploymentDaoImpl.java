package com.lti.appl.vehicleloan.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.beans.UserRegistration;

@Repository
public class EmploymentDaoImpl implements EmploymentDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Employment> getAllEmployments() {
		String str="select e from Employment e"; 
		Query qry=em.createQuery(str);
		List<Employment> employmentList=qry.getResultList();
		return employmentList;
	}

	@Override
	public Employment getEmploymentById(int employmentId) {
		
		Employment employmentDetail=em.find(Employment.class,employmentId); 
		return employmentDetail;
	}

	@Transactional
	@Override
	public String saveEmployment(Employment e, int userId) {
		UserRegistration ur = em.find(UserRegistration.class, userId);
		Employment emp = new Employment(e.getEmploymentType(),e.getAnnualSalary(),ur);
		em.persist(emp);
		return "Emp Added";
		
		
	}
	@Transactional
	@Override
	public String updateEmployment(Employment e,int userId) {
		//UserRegistration ur = em.find(UserRegistration.class, userId);
		String str = "Select e from Employment e where e.userRegistration.userID=: userid";
		Query qry = em.createQuery(str);
		//int userid = e.getUserRegistration().getUserID();
		//System.out.println(userid);
		qry.setParameter("userid", userId);
		//int i = qry.getFirstResult();
		Employment emp = (Employment) qry.getSingleResult();
		System.out.println("Emp inn conntroller"+emp);
		emp.setAnnualSalary(e.getAnnualSalary());
		emp.setEmploymentType(e.getEmploymentType());
		em.merge(emp);
		System.out.println("Emp inn conntroller after updating"+emp);
		return "Emp Updated";
	}

//	@Override
//	public String updateEmployment(Employment e, int userId) {
//		// TODO Auto-generated method stub
//		return null;
//	} 
	@Override
	public Employment getEmploymentByUserId(int userId) {
		// TODO Auto-generated method stub
		String str="select e from Employment e where e.userRegistration="+userId+" order by e.employmentId"; 
		Query qry=em.createQuery(str);
		
		List<Employment> employmentList=qry.getResultList(); 
		if(employmentList.size()==0)
		{ 
			Employment e=new Employment(); 
			System.out.println(e);
			 return e;
		} 
	
		Employment updatedEmploymentDetails=employmentList.get(employmentList.size()-1); 
		System.out.println(updatedEmploymentDetails);
		
		return updatedEmploymentDetails;
	}

}