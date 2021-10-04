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
	public String checkEmail(String email) {
		
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
			 return "No Email Exists";  
        } 
        else 
        { 
        	 return "Email already Exists";
        }
	}

	@Override 
	@Transactional
	public String createUser(UserRegistration userRegistration) {
	
		em.persist(userRegistration); 
		return "New User Added";
	}

	@Override
	public boolean validateUser(String email, String password) {
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userList=qry.getResultList(); 
		int emailFlag=0;        // Initially no Record in database; 
		boolean validate=false; 
//		for(UserRegistration userRegisterList:userList)
//		{ 
//			System.out.println(userRegisterList.getEmailId()+" "+userRegisterList.getPassword());
//		}
		for(int i=0;i<userList.size();i++)
		{
//			System.out.println(email+" "+password); 
//			System.out.println(userList.get(i).getEmailId()+" "+userList.get(i).getPassword()); 
			if(email.equals(userList.get(i).getEmailId()))
			{  
				if(password.equals(userList.get(i).getPassword())) 
				{  
					System.out.println(email+" "+password);
					System.out.println("true");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int getUserAdminStatus(String email) {
		 
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userList=qry.getResultList();  
		int userAdminStatus=0;
		for(int i=0;i<userList.size();i++)
		{ 
			if(email.equals(userList.get(i).getEmailId()))
			{
				userAdminStatus=userList.get(i).getUserAdminStatus();
			}
		} 
		return userAdminStatus;
	}

	@Override
	public int getUserId(String email) {
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userList=qry.getResultList();  
		int userId=0; 
		for(int i=0;i<userList.size();i++)
		{ 
			if(email.equals(userList.get(i).getEmailId()))
			{
				userId=userList.get(i).getUserID();
			}
		} 
		return userId;
		
	}  
	// Sanketh Part
	@Override
	public String getUserNameById(int userId) {
		// TODO Auto-generated method stub
		
		String str="select concat(u.firstName,' ',u.lastName) from UserRegistration u where u.userID="+userId; 
		Query qry=em.createQuery(str);
		String userName =(String)qry.getSingleResult();
		return userName;
		
	}

	@Override
	public boolean checkEmailExists(String email) {
		String str="select u from UserRegistration u"; 
		Query qry=em.createQuery(str);
		List<UserRegistration> userList=qry.getResultList();  
		boolean status=false; 
		for(int i=0;i<userList.size();i++)
		{ 
			if(email.equals(userList.get(i).getEmailId())) 
			{
				status=true;
			} 
		}
		return status;
	} 
	
	@Transactional
	@Override
	public boolean resetPassword(String emailId,String password) {
			
		String updateString="update UserRegistration set password=:password where emailId=:emailId";
		
		Query qry=em.createQuery(updateString);
		
		qry.setParameter("emailId",emailId);
		qry.setParameter("password",password);
		int i=qry.executeUpdate();
		if(i==1)
		return true;
		return false;
		
	}

}
