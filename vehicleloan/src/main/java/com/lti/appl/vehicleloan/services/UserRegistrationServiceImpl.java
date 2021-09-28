package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
