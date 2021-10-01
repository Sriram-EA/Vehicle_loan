package com.lti.appl.vehicleloan.services;

import java.util.List;

import com.lti.appl.vehicleloan.beans.Employment;

public interface EmploymentService {
	
	public abstract List<Employment> getAllEmployments(); 
	public abstract Employment getEmploymentById(int employmentId);
	public abstract String updateEmployment(Employment e, int userId);
	public abstract String saveEmployment(Employment e ,int userId);
	
}