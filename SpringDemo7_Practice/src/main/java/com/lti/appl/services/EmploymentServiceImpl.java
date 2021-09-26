package com.lti.appl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.beans.Employment;
import com.lti.appl.dao.EmploymentDao;
import com.lti.appl.exception.RecordAlreadyExists;

@Service("employmentService")
public class EmploymentServiceImpl implements EmploymentService{
 
	@Autowired
	private EmploymentDao employmentDao; 
	
	public EmploymentServiceImpl() {
		super();
	}

	public EmploymentServiceImpl(EmploymentDao employmentDao) {
		super();
		this.employmentDao = employmentDao;
	}


	public EmploymentDao getEmploymentDao() {
		return employmentDao;
	}

	public void setEmploymentDao(EmploymentDao employmentDao) {
		this.employmentDao = employmentDao;
	}
	

	@Override
	public String addUsers(Employment employment){
		 
		String msg = null;
		try {
			msg = employmentDao.addUsers(employment);
		} catch (RecordAlreadyExists e) {
			msg="Existing Record Found";
		}
		return msg;
	}

}
