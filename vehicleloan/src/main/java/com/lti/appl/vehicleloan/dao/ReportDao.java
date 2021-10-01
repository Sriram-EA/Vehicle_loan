package com.lti.appl.vehicleloan.dao;

import com.lti.appl.vehicleloan.beans.Report;

public interface ReportDao {
	
	public abstract Report getReport(int applicationId);

}