package com.onb.employeereg.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeereg.domain.Branch;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService{

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all branches
	 * 
	 * @return a list of branches
	 */
	public List<Branch> getAll() {
		logger.debug("Retrieving all branches");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Branch");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single branch
	 */
	public Branch get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch first
		Branch branch = (Branch) session.get(Branch.class, id);
		
		return branch;
	}
	/**
	 * Adds a new branch
	 */
	public void add(Branch branch) {
		logger.debug("Adding new branch");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(branch);
	}
	
	/**
	 * Deletes an existing branch
	 * @param id the id of the existing branch
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing branch");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch first
		Branch branch = (Branch) session.get(Branch.class, id);
		
		// Delete 
		session.delete(branch);
	}
	
	/**
	 * Edits an existing branch
	 */
	public void edit(Branch branch) {
		logger.debug("Editing existing branch");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch via id
		Branch existingBranch = (Branch) session.get(Branch.class, branch.getId());
		
		// Assign updated values to this branch
		existingBranch.setBranchName(branch.getBranchName());
		existingBranch.setBranchLocation(branch.getBranchLocation());
		existingBranch.setBranchContactNumber(branch.getBranchContactNumber());

		// Save updates
		session.save(existingBranch);
	}
}
