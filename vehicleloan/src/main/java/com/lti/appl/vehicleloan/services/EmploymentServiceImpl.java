package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.dao.EmploymentDao;

@Service("employmentService")
public class EmploymentServiceImpl implements EmploymentService {
 
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
	public List<Employment> getAllEmployments() {
		
		List<Employment> employmentList=employmentDao.getAllEmployments();
		return employmentList;
	}


	@Override
	public Employment getEmploymentById(int employmentId) {

		Employment employmentDetail=employmentDao.getEmploymentById(employmentId);
		return employmentDetail;
	}

}
