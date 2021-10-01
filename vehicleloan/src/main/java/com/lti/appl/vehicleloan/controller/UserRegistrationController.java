package com.lti.appl.vehicleloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.EmailStatus;
import com.lti.appl.vehicleloan.beans.UserRegistration;
import com.lti.appl.vehicleloan.services.UserRegistrationServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/userregistration")
public class UserRegistrationController {  
	
	@Autowired
	private UserRegistrationServiceImpl userRegistrationService; 
	
	
	//http://localhost:8090/userregistration/allusers
	
	@GetMapping("/allusers")
	public List<UserRegistration> getAllUserRegistrations()
	{  
		List<UserRegistration> userRegistrationList=userRegistrationService.getAllUserRegistrations();	 
		return userRegistrationList;
	} 
	
	//http://localhost:8090/userregistration/userbyid/1001
	@GetMapping("/userbyid/{id}")
	public UserRegistration getUserById(@PathVariable(value="id") int userId)
	{
		UserRegistration userDetail=userRegistrationService.getUserById(userId);
		return userDetail;
	} 
	
	//http://localhost:8090/userregistration/checkemail
	@PostMapping(value="/checkemail/{email}",consumes="application/json")
	public EmailStatus checkEmail(@PathVariable(value="email") String email)
	{ 
		System.out.println("My favorite person is sanketh");
		EmailStatus checkEmailMessage=userRegistrationService.checkEmail(email); 
		System.out.println(checkEmailMessage);
		return checkEmailMessage;
	}  
	
	//http://localhost:8090/userregistration/register
	@PostMapping(value="/register",consumes="application/json")
	public String registerUser(@RequestBody UserRegistration userRegistration)
	{
		String userRegisterMessage=userRegistrationService.createUser(userRegistration); 
		System.out.println(userRegisterMessage);
		return userRegisterMessage;
	}
	
//	//http://localhost:8090/userregistration/addDetails
//	@PostMapping("/adduser")
//	public void addPersonalDetails(@RequestBody UserRegistration e) 
//	{
//		System.out.println("insde cotroller "+e);
//		userRegistrationService.createUser(e);
//	}
	

}
