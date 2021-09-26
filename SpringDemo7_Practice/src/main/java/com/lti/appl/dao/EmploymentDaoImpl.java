package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.Employment;
import com.lti.appl.exception.RecordAlreadyExists;

@Repository
public class EmploymentDaoImpl implements EmploymentDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override 
	@Transactional
	public String addUsers(Employment employment) throws RecordAlreadyExists {
		 
		em.persist(employment); 
		return "Record Inserted";
	}

}
