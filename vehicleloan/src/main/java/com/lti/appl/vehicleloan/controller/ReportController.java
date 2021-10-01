package com.lti.appl.vehicleloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.Report;
import com.lti.appl.vehicleloan.services.ReportServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/admin")
public class ReportController { 
	
	@Autowired
	private ReportServiceImpl reportService; 
	
	//http://localhost:8090/admin/report/10000001
	@GetMapping("/report/{id}") 
	public Report getReport(@PathVariable("id") int applicationId)
	{ 
		System.out.println(applicationId);
		Report report=reportService.getReport(applicationId); 
		
		return report;
	}
	

}
