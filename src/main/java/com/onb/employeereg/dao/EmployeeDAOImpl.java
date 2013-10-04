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
public class EmployeeDAOImpl implements EmployeeDAO {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public List<Employee> getAll() {
		logger.debug("Retrieving all departments");

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM  Employee");

		return query.list();
	}
public Employee get(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Employee employee = (Employee) session.get(Employee.class, id);

		return employee;
	}

	public void add(Employee employee) {
		logger.debug("Adding new employee");

		Session session = sessionFactory.getCurrentSession();

		session.save(employee);
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing employee");

		Session session = sessionFactory.getCurrentSession();

		Employee employee = (Employee) session.get(Employee.class, id);

		session.delete(employee);
	}

	public void edit(Employee employee) {
		logger.debug("Editing existing department");

		Session session = sessionFactory.getCurrentSession();

		Employee existingEmployee = (Employee) session.get(Employee.class,
				employee.getId());

		existingEmployee.setEmployeeName(employee.getEmployeeName());
		existingEmployee.setEmployeeGrossSalary(employee
				.getEmployeeGrossSalary());

		session.save(existingEmployee);
	}

}
