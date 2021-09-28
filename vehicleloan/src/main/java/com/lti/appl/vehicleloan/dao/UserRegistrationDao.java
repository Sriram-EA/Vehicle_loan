package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.UserRegistration;

public interface UserRegistrationDao { 
	
	public abstract List<UserRegistration> getAllUserRegistrations(); 
	public abstract UserRegistration getUserById(int userId);

}
