package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.Employment;

public interface EmploymentDao { 
	
	public abstract List<Employment> getAllEmployments(); 
	public abstract Employment getEmploymentById(int employmentId);

}
