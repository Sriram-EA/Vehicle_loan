package com.lti.appl.vehicleloan.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.vehicleloan.beans.AccountType;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.dao.BankDetailDao;

@Service("bankDetailService")
public class BankDetailServiceImpl implements BankDetailService {

	@Autowired
	private BankDetailDao bankDetailDao;
	
	@Override
	public List<BankDetail> getBankDetailsList() {
		// TODO Auto-generated method stub
		System.out.println("bankDetailsService");
		List<BankDetail> bankDetailsList=bankDetailDao.getBankDetailsList();
		return bankDetailsList;	
	}
	@Override
	public BankDetail getBankDetailsById(int userId) {
		// TODO Auto-generated method stub
		BankDetail bankDetails=bankDetailDao.getBankDetailsById(userId);
		return bankDetails;
	}

	@Override
	public String updateBankDetails(int bankId, String accountType) {
		// TODO Auto-generated method stub
		String updatedSalStatus=bankDetailDao.updateBankDetails(bankId, accountType);
		return updatedSalStatus;
	}
	
	@Override
	public String addBank(BankDetail b, int userId) {
		// TODO Auto-generated method stub
		return bankDetailDao.addBank(b, userId);
	}
	@Override
	public String updateBank(AccountType acc, int userId) {
		// TODO Auto-generated method stub
		return bankDetailDao.updateBank(acc, userId);
	}
	


	
}