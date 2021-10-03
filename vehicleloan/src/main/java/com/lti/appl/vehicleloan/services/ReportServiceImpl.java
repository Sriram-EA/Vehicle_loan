package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.Report;
import com.lti.appl.vehicleloan.dao.ReportDao;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDao reportDao;

	@Override
	public Report getReport(int applicationId) {
		
		System.out.println("inside service");
		return reportDao.getReport(applicationId);
		
	} 
	


}