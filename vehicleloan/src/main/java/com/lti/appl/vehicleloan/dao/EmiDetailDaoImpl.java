package com.lti.appl.vehicleloan.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;


import com.lti.appl.vehicleloan.beans.EmiDetail;

@Repository
public class EmiDetailDaoImpl implements EmiDetailDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<EmiDetail> getEmiList() {
		String sql="select e from EmiDetail e";
		Query qry=em.createQuery(sql);
		List<EmiDetail> emiList=qry.getResultList();
		
		return emiList;
		
	}

	@Override
	public EmiDetail getEmiById(int emiId) {
		String sql="select e from EmiDetail e where e.emiId"+ emiId;
		Query qry=em.createQuery(sql);
		EmiDetail emi=(EmiDetail) qry.getSingleResult();
		return emi;
	} 
	
	@Override
	public int getEmiByUserId(int userId) {
		// TODO Auto-generated method stub
		int existingEmiAmount=0;
		
		String sql="select e from EmiDetail e where e.user="+ userId;
		Query qry=em.createQuery(sql);
		List<EmiDetail> emi=(List<EmiDetail>) qry.getResultList();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate= formatter.format(date);
		
		
		for(EmiDetail existingEmi:emi)
		{
			String emiEndDate=""+existingEmi.getEmiEndDate();
			
			
			
			
			SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		      Date currentDate = null;
			try {
				currentDate = sdformat.parse(strDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      Date emiEndDate1 = null;
			try {
				emiEndDate1 = sdformat.parse(emiEndDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		      System.out.println("The date 1 is: " + sdformat.format(currentDate));
//		      System.out.println("The date 2 is: " + sdformat.format(emiEndDate1));
		      if(currentDate.compareTo(emiEndDate1) > 0) {
//		         System.out.println("eligible");
		         
		      } else if(currentDate.compareTo(emiEndDate1) < 0) {
                 existingEmiAmount+=existingEmi.getEmi();		    	  
//		         System.out.println("Not Eligible");
		      } else if(currentDate.compareTo(emiEndDate1) == 0) {
//		         System.out.println("Eligible");
		      }
			
			
		}
		
		return existingEmiAmount;
		


	}

}
