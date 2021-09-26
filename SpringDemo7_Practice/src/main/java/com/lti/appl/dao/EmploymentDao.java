package com.lti.appl.dao;

import com.lti.appl.beans.Employment;
import com.lti.appl.exception.RecordAlreadyExists;

public interface EmploymentDao { 
	
	public abstract String addUsers(Employment employment) throws RecordAlreadyExists;

}
