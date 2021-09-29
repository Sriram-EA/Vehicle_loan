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
	
	//http://localhost:8090/userregistration/addusers
	@PostMapping("/addusers")
	public String createUser(@RequestBody UserRegistration userRegistration)
	{
		String createUserMsg=userRegistrationService.checkEmail(userRegistration);
		return createUserMsg;
	}
	

}
