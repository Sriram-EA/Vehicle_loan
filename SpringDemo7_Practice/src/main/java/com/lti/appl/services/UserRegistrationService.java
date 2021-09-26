package com.lti.appl.services;

import com.lti.appl.beans.UserRegistration;
import com.lti.appl.exception.RecordAlreadyExists;

public interface UserRegistrationService {
	
	public abstract String checkEmail(UserRegistration userRegistration) throws RecordAlreadyExists;

}
