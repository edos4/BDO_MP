package com.onb.employeereg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onb.employeereg.domain.Employee;

@Service("employeeServices")
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public List<Employee> getAll() {
		logger.debug("Retrieving all departments");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  Employee");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single department
	 */
	public Employee get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing department first
		Employee employee = (Employee) session.get(Employee.class, id);
		
		return employee;
	}
	
	public void add(Employee employee) {
		logger.debug("Adding new employee");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(employee);
	}
	
	/**
	 * Deletes an existing employee
	 * @param id the id of the existing employee
	 */
	public void delete(Integer id) {
		logger.debug("Deleting existing employee");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing department first
		Employee employee = (Employee) session.get(Employee.class, id);
		
		// Delete 
		session.delete(employee);
	}
	
	/**
	 * Edits an existing employee
	 */
	public void edit(Employee employee) {
		logger.debug("Editing existing department");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing department via id
		Employee existingEmployee = (Employee) session.get(Employee.class, employee.getId());
		
		// Assign updated values to this department
		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setEmployeeGrossSalary(employee.getEmployeeGrossSalary());

		// Save updates
		session.save(existingEmployee);
	}

}
