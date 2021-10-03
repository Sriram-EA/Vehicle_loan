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

import com.lti.appl.vehicleloan.beans.AccountType;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.Employment;
import com.lti.appl.vehicleloan.services.BankDetailService;
import com.lti.appl.vehicleloan.services.BankDetailServiceImpl;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/bank")
public class BankDetailController {
	@Autowired
	private BankDetailService bankDetailService;
	@GetMapping("/bankdetails")
	public List<BankDetail>  getBankDetailsList()
	{
	System.out.println("bankDetailsController");
	List<BankDetail> empList=bankDetailService.getBankDetailsList();
	System.out.println(empList);
	return empList;	
	}
	//http:localhost:8050/bank/status/1001
	@GetMapping("/status/{id}")
	public BankDetail getBankDetailsById(@PathVariable(value="id") int userId)
	{
		System.out.println("Inside controller");
		return bankDetailService.getBankDetailsById(userId);
	}
	//http://localhost:8050/bank/bankupdate/1003
	@Transactional
	@PutMapping("/bankupdate/{id}")
	public String updateBank(@RequestBody AccountType acc, @PathVariable(value="id")int userId) 
	{
	return bankDetailService.updateBank(acc,userId);		
	}
	  
	  //http:localhost:8050/bank/addbank/1004
	  @Transactional
	  @PostMapping("/addbank/{id}")
	  public String addBank(@RequestBody BankDetail bank, @PathVariable(value="id")int userId) 
	 {
	   return bankDetailService.addBank(bank,userId);		
	 } 
	  
	  @GetMapping("/bankbyuserid/{userId}")
		public BankDetail getBankByUserId(@PathVariable(value="userId") int userId)
		{
			BankDetail bankDetails=bankDetailService.getBankByUserId(userId);
			return bankDetails;
		} 
	  
	  
}