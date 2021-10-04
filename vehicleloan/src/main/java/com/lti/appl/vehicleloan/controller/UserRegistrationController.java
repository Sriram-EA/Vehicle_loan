package com.lti.appl.vehicleloan.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.EmailStatus;
import com.lti.appl.vehicleloan.beans.Status;
import com.lti.appl.vehicleloan.beans.UserRegistration;
import com.lti.appl.vehicleloan.services.UserRegistrationServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/userregistration")
public class UserRegistrationController {

	@Autowired
	private UserRegistrationServiceImpl userRegistrationService;

	// http://localhost:8090/userregistration/allusers

	@GetMapping("/allusers")
	public List<UserRegistration> getAllUserRegistrations() {
		List<UserRegistration> userRegistrationList = userRegistrationService.getAllUserRegistrations();
		return userRegistrationList;
	}

	// http://localhost:8090/userregistration/userbyid/1001
	@GetMapping("/userbyid/{id}")
	public UserRegistration getUserById(@PathVariable(value = "id") int userId) {
		UserRegistration userDetail = userRegistrationService.getUserById(userId);
		return userDetail;
	}

	// http://localhost:8090/userregistration/checkemail
	@GetMapping("/checkemail/{email}")
	public boolean checkEmail(@PathVariable(value = "email") String email) {
		String checkEmailMessage = userRegistrationService.checkEmail(email); 
		System.out.println(email);
		System.out.println(checkEmailMessage);
		if (checkEmailMessage.equals("Email already Exists")) { 
			return false;
		} 
		else 
		{
			return true;
		}
	}

	// http://localhost:8090/userregistration/register
	@PostMapping(value = "/register", consumes = "application/json")
	public String registerUser(@RequestBody UserRegistration userRegistration) {
		String userRegisterMessage = userRegistrationService.createUser(userRegistration);
		System.out.println(userRegisterMessage);
		return userRegisterMessage;
	}


	//http://localhost:8090/userregistration/sriram@gmail.com/sriram123
	@GetMapping("/validateuser/{email}/{password}")
	public boolean validateEmail(@PathVariable(name ="email") String email, @PathVariable(name="password") String password)
	{ 
		System.out.println(email+" "+password);
		boolean validate= userRegistrationService.validateUser(email, password); 
		System.out.println(validate);
		return validate;
	}
	@GetMapping("/getuseradminstatus/{email}")
	public int getUserAminStatus(@PathVariable(name="email") String email)
	{
		int userAdminStatus= userRegistrationService.getUserAdminStatus(email); 
		System.out.println(userAdminStatus);
		return userAdminStatus;
	}
	
	@GetMapping("/getuserid/{email}") 
	public int getUserId(@PathVariable(name="email") String email)
	{
		int userId=userRegistrationService.getUserId(email);
		System.out.println("userId"+userId); 
		return userId;
	} 
	
	// Sanketh Part 
	
	@GetMapping("/usernamebyid/{id}")
	public Status getUserNameById(@PathVariable(value="id") int userId) 
	{
		String userName=userRegistrationService.getUserNameById(userId);	
		Status user=new Status(userName);
		return user;
	} 
	
	@GetMapping("/checkemaillogin/{email}")
	public boolean checkEmailExists(@PathVariable(value = "email") String email)
	{
		boolean status=userRegistrationService.checkEmailExists(email); 
		System.out.println("Email Exists status"+ status);
		return status;
	}
	
	@PutMapping("/reset/{id}/{password}") 
	public boolean resetPassword(@PathVariable(value="id") String emailId,@PathVariable(value="password") String password)
	{
		boolean status=userRegistrationService.resetPassword(emailId, password);
		return status;
	}
}
