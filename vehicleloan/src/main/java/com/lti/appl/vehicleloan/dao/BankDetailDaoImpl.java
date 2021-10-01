package com.lti.appl.vehicleloan.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.vehicleloan.beans.AccountType;
import com.lti.appl.vehicleloan.beans.BankDetail;
import com.lti.appl.vehicleloan.beans.UserRegistration;

@Repository
public class BankDetailDaoImpl implements BankDetailDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<BankDetail> getBankDetailsList() {
		// TODO Auto-generated method stub
		
		System.out.println("bankDetailsDao");
		String listSql="Select b from BankDetail b";
		Query qry=em.createQuery(listSql);
		List<BankDetail> bankDetailsList=qry.getResultList();
		return bankDetailsList;	
	}

	@Override
	public BankDetail getBankDetailsById(int userId) {
		UserRegistration ur = em.find(UserRegistration.class, userId);
		String str = "Select b from BankDetail b where b.userId.userID=:userId";
		Query qry = em.createQuery(str);
		qry.setParameter("userId", userId);
		BankDetail b = (BankDetail) qry.getSingleResult();
		
		return b;
	}

	@Transactional
	@Override
	public String updateBankDetails(int bankId, String accountType) {
		// TODO Auto-generated method stub
		BankDetail updateBankDetail=em.find(BankDetail.class,bankId);	
		String updateString="update BankDetail set accountType=:accountType where bankId=:bankId";	
		Query q=em.createQuery(updateString);
		q.setParameter("accountType",accountType);
		q.setParameter("bankId",bankId);
		int i=q.executeUpdate();
		String updatedSalaryStatus="Accountype successfully updated";
		return updatedSalaryStatus;
	}

	@Override
	public String addBank(BankDetail b, int userId) {
		UserRegistration ur = em.find(UserRegistration.class, userId);
		BankDetail bank = new BankDetail(b.getAccountNumber(),b.getIfscCode(),b.getBankBranch(),b.getAccountType(),ur);
		em.persist(bank);
				
		return "Bank Added";
	}

	@Override
	public String updateBank(AccountType acc, int userId) {
		UserRegistration ur = em.find(UserRegistration.class, userId);
		String str = "Select b from BankDetail b where b.userId.userID=:userId";
		Query qry = em.createQuery(str);
		qry.setParameter("userId", userId);
		BankDetail bank = (BankDetail) qry.getSingleResult();
		System.out.println("Bank"+bank);
		bank.setAccountType(acc.getAccountType());
		em.merge(bank);
		System.out.println(bank);
		return "Bank Updated";
		
	}

	
//	@Override
//	public String updateBank(BankDetail b, int userId) {
//		UserRegistration ur = em.find(UserRegistration.class, userId);
//		return null;
//	}


	


}