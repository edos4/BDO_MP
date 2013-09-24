package com.onb.employeereg.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeereg.domain.Department;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all departments
	 * 
	 * @return a list of departments
	 */
	public List<Department> getAll(Integer id) {
		logger.debug("Retrieving all departments");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Department where branch_id = ?");
		query.setParameter(0, id);
		
		// Retrieve all
		
		return  query.list();
	}
	
	/**
	 * Retrieves a single branch
	 */
	public Department get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch first
		Department department = (Department) session.get(Department.class, id);
		
		return department;
	}
	/**
	 * Adds a new branch
	 */
	public void add(Department department) {
		logger.debug("Adding new department");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(department);
	}
	
	/**
	 * Deletes an existing department
	 * @param id the id of the existing department
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing department");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch first
		Department department = (Department) session.get(Department.class, id);
		
		// Delete 
		session.delete(department);
	}
	
	/**
	 * Edits an existing branch
	 */
	public void edit(Department department) {
		logger.debug("Editing existing department");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch via id
		Department existingDepartment = (Department) session.get(Department.class, department.getId());
		
		// Assign updated values to this branch
		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setDepartmentDescription(department.getDepartmentDescription());

		// Save updates
		session.save(existingDepartment);
	}
}
