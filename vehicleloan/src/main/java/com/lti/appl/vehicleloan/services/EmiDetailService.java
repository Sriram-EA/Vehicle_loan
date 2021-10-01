package com.lti.appl.vehicleloan.services;

import java.util.List;

import com.lti.appl.vehicleloan.beans.EmiDetail;

public interface EmiDetailService {
	
	public abstract List<EmiDetail> getEmiList();
	public abstract EmiDetail getEmiById(int emiId);

}