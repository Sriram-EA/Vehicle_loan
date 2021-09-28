package com.lti.appl.vehicleloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.UserRegistration;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<UserRegistration> getAllUserRegistrations() {
		
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userRegistrationList=qry.getResultList();
		return userRegistrationList;
	}

	@Override
	public UserRegistration getUserById(int userId) {
		
		UserRegistration userDetail=em.find(UserRegistration.class,userId);
		return userDetail;
	}

}
