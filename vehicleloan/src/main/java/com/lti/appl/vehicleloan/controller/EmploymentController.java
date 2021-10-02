package com.lti.appl.vehicleloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.services.EmploymentServiceImpl;

@CrossOrigin(origins="*")
@RestController 
@RequestMapping("/employment")
public class EmploymentController {
	
	@Autowired
	private EmploymentServiceImpl employmentService; 
	
	//http://localhost:8090/employment/allemployments
	
	@GetMapping("/allemployments")
	public List<Employment> getAllEmployments()
	{ 
		List<Employment> employmentList=employmentService.getAllEmployments();
		return employmentList;
	} 
	
	//http://localhost:8090/employment/employmentbyid/10001
	@GetMapping("/employmentbyid/{id}")
	public Employment getEmploymentById(@PathVariable(value="id") int employmentId)
	{
		Employment employmentDetail=employmentService.getEmploymentById(employmentId); 
		return employmentDetail;
	}
	//http://localhost:8050/employment/addemp/1005
	@PostMapping(value="/addemp/{id}",consumes="application/json")
	public String saveEmployment(@RequestBody Employment e, @PathVariable(value="id")int userId)
	{
		System.out.println("inside con"+e);
		String msg = employmentService.saveEmployment(e,userId);
		return msg;
		
	}
	//http://localhost:8050/employment/updateemp/1005
	@PostMapping(value="/updateemp/{id}",consumes="application/json")
	public String updateEmployment(@RequestBody Employment e,@PathVariable(value="id")int userId)
	{
		System.out.println("Obj"+e);
		String msg = employmentService.updateEmployment(e,userId);
		return msg;
	} 
	
	// Sanketh Part 
	
	@GetMapping("/employmentbyuserid/{userId}")
	public Employment getEmploymentByUserId(@PathVariable(value="userId") int userId)
	{
			
		Employment employmentDetails=employmentService.getEmploymentByUserId(userId);
		return employmentDetails;
		
	}
	

}