package com.lti.appl.vehicleloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.EmailStatus;
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

	@Override
	public EmailStatus checkEmail(String email) {
		
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userList=qry.getResultList(); 
		int emailFlag=0;        // Initially no Record in database;
		for(UserRegistration userRegisterList:userList)
		{ 
			if(email.equals(userRegisterList.getEmailId()))
			{
				emailFlag=1; 
				break;
			}
		} 
		EmailStatus status=new EmailStatus(); 
		
		if(emailFlag==0)
        {  
			 status.setEmailStatus("No Email Exists");
			 return status;
        } 
        else 
        { 
        	status.setEmailStatus("Email already Exists");
			 return status;
        }
	}

	@Override 
	@Transactional
	public String createUser(UserRegistration userRegistration) {
	
		em.persist(userRegistration); 
		return "New User Added";
	}

}