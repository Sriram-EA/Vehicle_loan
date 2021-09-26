package com.lti.appl.dao;

import com.lti.appl.beans.UserRegistration;
import com.lti.appl.exception.RecordAlreadyExists;

public interface UserRegistrationDao {
	
	public abstract String checkEmail(UserRegistration userRegistration) throws RecordAlreadyExists;
	
}
