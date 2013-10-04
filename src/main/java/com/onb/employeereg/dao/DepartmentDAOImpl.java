package com.onb.employeereg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onb.employeereg.domain.Department;

@Service("departmentServices")
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO{

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/**
	 * Retrieves all departments
	 * 
	 * @return a list of departments
	 */
	public List<Department> getAll() {
		logger.debug("Retrieving all departments");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Department");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single department
	 */
	public Department get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing department first
		Department department = (Department) session.get(Department.class, id);
		
		return department;
	}
	/**
	 * Adds a new department
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
		
		// Retrieve existing department first
		Department department = (Department) session.get(Department.class, id);
		
		// Delete 
		session.delete(department);
	}
	
	/**
	 * Edits an existing department
	 */
	public void edit(Department department) {
		logger.debug("Editing existing department");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing department via id
		Department existingDepartment = (Department) session.get(Department.class, department.getId());
		
		// Assign updated values to this department
		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setDepartmentBonus(department.getDepartmentBonus());

		// Save updates
		session.save(existingDepartment);
	}

}
