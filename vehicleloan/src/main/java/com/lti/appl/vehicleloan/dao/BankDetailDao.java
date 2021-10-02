package com.lti.appl.vehicleloan.dao;

import java.util.List;

import com.lti.appl.vehicleloan.beans.AccountType;
import com.lti.appl.vehicleloan.beans.BankDetail;

public interface BankDetailDao {

public abstract List<BankDetail> getBankDetailsList();
	
	public abstract BankDetail getBankDetailsById(int userId);
	
	public abstract String updateBankDetails(int bankId,String accountType);
	
	public abstract String addBank(BankDetail b , int userId);
	
	public abstract String updateBank(AccountType acc, int userId); 
	
	public abstract BankDetail getBankByUserId(int userId);
}