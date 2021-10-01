package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.EmiDetail;

public interface EmiDetailDao {
	
	public abstract List<EmiDetail> getEmiList();
	public abstract EmiDetail getEmiById(int emiId);

}