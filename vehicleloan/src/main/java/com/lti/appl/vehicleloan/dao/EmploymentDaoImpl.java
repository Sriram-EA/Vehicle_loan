package com.lti.appl.vehicleloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.Employment;

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

}
