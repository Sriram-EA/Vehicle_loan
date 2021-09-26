package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.UserRegistration;
import com.lti.appl.exception.RecordAlreadyExists;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String checkEmail(UserRegistration userRegistration) throws RecordAlreadyExists {
	   
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userList=qry.getResultList(); 
		int emailFlag=0;        // Initially no Record in database;
		for(UserRegistration userRegisterList:userList)
		{ 
			if(userRegistration.getEmailId().equals(userRegisterList.getEmailId()))
			{
				emailFlag=1; 
				break;
			}
		}
        if(emailFlag==0)
        {
        	return "No Email Exists";
        } 
        else 
        {
        	return "Email already Exists";
        }
	}

}
