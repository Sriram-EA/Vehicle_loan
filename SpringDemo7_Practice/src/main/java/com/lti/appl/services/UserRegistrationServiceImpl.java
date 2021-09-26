package com.lti.appl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.beans.UserRegistration;
import com.lti.appl.dao.UserRegistrationDao;
import com.lti.appl.exception.RecordAlreadyExists;

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
	public String checkEmail(UserRegistration userRegistration) {
		String msg = null;
		try {
			msg = userRegistrationDao.checkEmail(userRegistration);
		} catch (RecordAlreadyExists e) {
			msg = "Email already Exists";
		}
		return msg;
	}

}
