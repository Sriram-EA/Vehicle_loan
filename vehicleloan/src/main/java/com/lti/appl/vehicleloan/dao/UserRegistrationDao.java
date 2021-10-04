package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.EmailStatus;
import com.lti.appl.vehicleloan.beans.UserRegistration;

public interface UserRegistrationDao { 
	
	public abstract List<UserRegistration> getAllUserRegistrations(); 
	public abstract UserRegistration getUserById(int userId); 
	public abstract String checkEmail(String email); 
	public abstract String createUser(UserRegistration userRegistration); 
	public abstract boolean validateUser(String email,String password); 
	public abstract int getUserAdminStatus(String email); 
	public abstract int getUserId(String email);
	public abstract String getUserNameById(int userId); 
	public abstract boolean checkEmailExists(String email); 
	public abstract boolean resetPassword(String emailId, String password);
    
}
