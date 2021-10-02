package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.EmiDetail;
import com.lti.appl.vehicleloan.dao.EmiDetailDao;

@Service("emiDetailService")
public class EmiDetailServiceImpl implements EmiDetailService{
	
	@Autowired
	private EmiDetailDao emiDetailDao;

	public EmiDetailDao getEmiDetailDao() {
		return emiDetailDao;
	}

	public void setEmiDetailDao(EmiDetailDao emiDetailDao) {
		this.emiDetailDao = emiDetailDao;
	}

	public EmiDetailServiceImpl(EmiDetailDao emiDetailDao) {
		super();
		this.emiDetailDao = emiDetailDao;
	}

    

	public EmiDetailServiceImpl() {
		super();
	}

	@Override
	public List<EmiDetail> getEmiList() {
		List<EmiDetail> emiList=emiDetailDao.getEmiList();
		return emiList;
	}

	@Override
	public EmiDetail getEmiById(int emiId) {
		EmiDetail emi=emiDetailDao.getEmiById(emiId);
	    return emi;
	} 
	
	@Override
	public int getEmiByUserId(int userId) {
		// TODO Auto-generated method stub
		return emiDetailDao.getEmiByUserId(userId);
	}

}