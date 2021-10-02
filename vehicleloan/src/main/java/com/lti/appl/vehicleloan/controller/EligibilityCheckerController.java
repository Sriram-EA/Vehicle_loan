package com.lti.appl.vehicleloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.EligibilityChecker;
import com.lti.appl.vehicleloan.services.EligibilityCheckerService;

@CrossOrigin(origins="*",value="*")
@RestController
@RequestMapping("/eligibility")
public class EligibilityCheckerController {

	
	@Autowired
	private EligibilityCheckerService eligibilityChecker;
	
	
//	ResponseEntity<String>
	@PostMapping(value="/eligibilityChecker",consumes="application/json")
	public  EligibilityChecker checkEligibility(@RequestBody EligibilityChecker eligibilityInputDetails)
	{

	
		System.out.println(eligibilityInputDetails);
		
		EligibilityChecker eligibilityStatus=eligibilityChecker.checkEligibility(eligibilityInputDetails);
		
		System.out.println("eligibility Status"+ eligibilityStatus);
		return eligibilityStatus;
		
		
		
		
		
		
		
		
	
//		return ResponseEntity.ok("eligibilityChecked");

//		return eligibilityInputDetails;
	}
//	 {
//		 "vehicleType":"4W",
//		 "vehicleBrand":"Audi",
//			 "vehicleModel":"itnotexits",
//			 "showRoomPrice":2000,
//			 "onRoadPrice":3000,
//			 "interest":8.0,
//			 "applicantName":"Sanketh Reddy",
//			 "age":21,
//			 "gender":"Male",
//		 "typeOfEmployment":"Private",
//			 "annualIncome":40000,
//			 "existingEmi":1000,
//			 "mobileNo":9701742205,
//			 "emailId":"p.sankethreddy2000@gmail.com"
//
//		    }
	
	
	@GetMapping("/test")
	public String checkEligibility()
	{

		
		
	
		return "Hello I am good";
		
	}
	
	
	
	
}