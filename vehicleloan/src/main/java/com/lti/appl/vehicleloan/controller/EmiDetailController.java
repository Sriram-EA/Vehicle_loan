package com.lti.appl.vehicleloan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.vehicleloan.beans.EmiDetail;
import com.lti.appl.vehicleloan.services.EmiDetailServiceImpl;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/emi")
public class EmiDetailController {

	@Autowired
	private EmiDetailServiceImpl emiDetailService;
	
	//http://localhost:8090/emi/emilist
	@GetMapping("/emilist")
	public List<EmiDetail> getEmiList()
	{
		List<EmiDetail> emiList= emiDetailService.getEmiList();
		return emiList;
	}
	
	//http://localhost:8090/emi/emibyid/100001
	@GetMapping("/emibyid/{id}")
	public EmiDetail getEmiById(@PathVariable(value="id") int emiId)
	{
		return emiDetailService.getEmiById(emiId);
	}
	
	//http://localhost:8090/emi/emilist

}