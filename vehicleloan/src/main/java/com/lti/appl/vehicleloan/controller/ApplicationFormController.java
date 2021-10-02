package com.lti.appl.vehicleloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.ApplicationDetails;
import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.FetchDetail;
import com.lti.appl.vehicleloan.services.ApplicationFormService;
import com.lti.appl.vehicleloan.services.ApplicationFormServiceImpl;

//http://localhost:8050/app/applicationform/10000002
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/app") 
public class ApplicationFormController {
	
	@Autowired
	private ApplicationFormServiceImpl applicationService;
	//10000002
	//@RequestMapping(value="/applicationform/{id}")
//	public ResponseEntity<Product> getProductById(@PathVariable("id") int pid){
//		Product p =dao.findById(pid);
//		if(p!=null)
//		{
//			return new ResponseEntity<Product>(p,HttpStatus.OK);
//			
//		}
//		return new ResponseEntity(HttpStatus.NOT_FOUND);
//	}
	
//	@RequestMapping(path = "/mno/objectKey/{id}/{name}", method = RequestMethod.GET)
//	public Book getBook(@PathVariable int id, @PathVariable String name) {
//	    // code here
//	}
//	
	@GetMapping(value="/applicationform/{id}")
	public ApplicationForm getApplicationById(@PathVariable("id") int appid)
	{
		
		return applicationService.getApplicationById(appid);
		
	}
	//http://localhost:8050/app/status/1001
	@GetMapping(value="/status/{id}")
	public List<ApplicationForm> getApplicationStatusById(@PathVariable("id") int userId)
	{
		//List<ApplicationForm> appFormList = applicationService.getApplicationStatusById(userId);
		//GetStatus status = new GetStatus(appForm.getApplicationId(),appForm.getStatus());
		return applicationService.getApplicationStatusById(userId);
		
	} 
	
	@GetMapping(value="/applicationform/admin")
	public List<ApplicationForm> getApplicationList()
	{
		List<ApplicationForm> applist= applicationService.getApplicationList();
		return applist;
		
	}  
	@GetMapping(value="/fetch/{userid}/{vehicleid}/{empid}/{bankid}/{principle}/{tenure}/{emi}",produces="application/json")
	public FetchDetail fetchdetails(@PathVariable(value="userid") int userId ,@PathVariable(value="vehicleid") int vehicleId,@PathVariable(value="empid") int empId,@PathVariable(value="bankid") int bankId,@PathVariable(value="principle") int principle,@PathVariable(value="tenure") int tenure,@PathVariable(value="emi") int emi)
	{
		return applicationService.fetch(userId,vehicleId,empId,bankId,principle,tenure,emi);
	}
	
	//http://localhost:8050/app/fetch/1001/101/10001
	
	@PostMapping(value="/addapp/{userid}/{vehicleid}/{empid}/{bankid}/{principle}/{tenure}/{emi}")
	public String fill(@RequestBody ApplicationDetails app,@PathVariable(value="userid") int userId ,@PathVariable(value="vehicleid") int vehicleId,@PathVariable(value="empid") int empId,@PathVariable(value="bankid") int bankId,@PathVariable(value="principle") int principle,@PathVariable(value="tenure") int tenure,@PathVariable(value="emi") int emi)
	{
		return applicationService.fill(app,userId,vehicleId,empId,bankId,principle,tenure,emi);
	}
	
	
}