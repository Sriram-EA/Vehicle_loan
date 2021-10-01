package com.lti.appl.vehicleloan.dao;

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

}
