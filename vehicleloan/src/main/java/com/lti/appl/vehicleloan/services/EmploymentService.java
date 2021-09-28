package com.lti.appl.vehicleloan.services;

import java.util.List;

import com.lti.appl.vehicleloan.beans.Employment;

public interface EmploymentService {
	
	public abstract List<Employment> getAllEmployments(); 
	public abstract Employment getEmploymentById(int employmentId);

}
