package com.lti.appl.vehicleloan.services;

import java.util.List;

import com.lti.appl.vehicleloan.beans.EmailStatus;
import com.lti.appl.vehicleloan.beans.UserRegistration;

public interface UserRegistrationService {

	public abstract List<UserRegistration> getAllUserRegistrations(); 
	public abstract UserRegistration getUserById(int userId); 
	public abstract EmailStatus checkEmail(String email); 
	public abstract String createUser(UserRegistration userRegistration);
}