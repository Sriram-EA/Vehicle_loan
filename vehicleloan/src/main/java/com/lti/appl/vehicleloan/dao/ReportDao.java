package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.ApplicationForm;
import com.lti.appl.vehicleloan.beans.Report;

public interface ReportDao {
	
	public abstract Report getReport(int applicationId); 

}