package com.onb.employeereg.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onb.employeereg.domain.Employee;
import com.onb.employeereg.dao.BranchDAO;
import com.onb.employeereg.dao.DepartmentDAO;
import com.onb.employeereg.dao.EmployeeDAO;
import com.onb.employeereg.dao.SalaryConfigDAO;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	private BranchDAO branchDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private SalaryConfigDAO salaryConfigDAO;

	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	public Employee get(Integer id) {
		return employeeDAO.get(id);
	}

	public void add(Employee employee) {
		employeeDAO.add(employee);
	}

	public void delete(Integer id) {
		employeeDAO.delete(id);
	}

	public void edit(Employee employee) {
		employeeDAO.edit(employee);
	}

	public List<Employee> getAll(Integer id) {
		// TODO Auto-generated method stub
		return employeeDAO.getAll();
	}

}
