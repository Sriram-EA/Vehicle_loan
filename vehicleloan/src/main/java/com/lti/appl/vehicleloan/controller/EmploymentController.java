package com.lti.appl.vehicleloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	

}
