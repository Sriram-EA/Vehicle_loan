package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.EmailStatus;
import com.lti.appl.vehicleloan.beans.UserRegistration;
import com.lti.appl.vehicleloan.dao.UserRegistrationDao;

@Service("userRegistrationService")
public class UserRegistrationServiceImpl implements UserRegistrationService {
 
	@Autowired
	private UserRegistrationDao userRegistrationDao;
	
	public UserRegistrationServiceImpl() {
		super();
	}


	public UserRegistrationServiceImpl(UserRegistrationDao userRegistrationDao) {
		super();
		this.userRegistrationDao = userRegistrationDao;
	} 

	public UserRegistrationDao getUserRegistrationDao() {
		return userRegistrationDao;
	}


	public void setUserRegistrationDao(UserRegistrationDao userRegistrationDao) {
		this.userRegistrationDao = userRegistrationDao;
	}


	@Override
	public List<UserRegistration> getAllUserRegistrations() {
		 
		List<UserRegistration> userRegistrationList=userRegistrationDao.getAllUserRegistrations();
		return userRegistrationList;
	}


	@Override
	public UserRegistration getUserById(int userId) {
		
		UserRegistration userDetail=userRegistrationDao.getUserById(userId);
		return userDetail;
	}


	@Override 
	public String checkEmail(String email) {
		
		String emailMsg=userRegistrationDao.checkEmail(email); 
		return emailMsg;

	}

	@Override
	public String createUser(UserRegistration userRegistration) {
		String msg=userRegistrationDao.createUser(userRegistration); 
		return msg;
	}


	@Override
	public boolean validateUser(String email, String password) {
		
		boolean validate=userRegistrationDao.validateUser(email, password);
		return validate;
	}


	@Override
	public int getUserAdminStatus(String email) {

        int userAdminStatus=userRegistrationDao.getUserAdminStatus(email);
		return userAdminStatus;
	}


	@Override
	public int getUserId(String email) {
		int userId=userRegistrationDao.getUserId(email);
		return userId;
	} 
	
	@Override
	public String getUserNameById(int userId) {
		// TODO Auto-generated method stub
		
		String userName=userRegistrationDao.getUserNameById(userId);
		
		return userName;
	}


	@Override
	public boolean checkEmailExists(String email) {
		boolean status=userRegistrationDao.checkEmailExists(email);
		return status;
	}

}
