package com.onb.employeereg.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;

import com.onb.employeereg.domain.Branch;

public class Test implements BranchService{
	
	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public List<Branch> getAll() {
		logger.debug("Retrieving all branches");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Branch");
		
		// Retrieve all
		return  query.list();
	}

	public Branch get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Branch branch) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void edit(Branch branch) {
		// TODO Auto-generated method stub
		
	}

}
