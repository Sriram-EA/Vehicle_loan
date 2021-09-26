package com.lti.appl.services;

import com.lti.appl.beans.Employment;
import com.lti.appl.exception.RecordAlreadyExists;

public interface EmploymentService { 
	
	public abstract String addUsers(Employment employment) throws RecordAlreadyExists;

}
