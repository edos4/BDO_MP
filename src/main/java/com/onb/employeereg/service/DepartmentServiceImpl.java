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

import com.onb.employeereg.domain.Branch;
import com.onb.employeereg.domain.Department;
import com.onb.employeereg.dao.BranchDAO;
import com.onb.employeereg.dao.DepartmentDAO;
import com.onb.employeereg.dao.EmployeeDAO;
import com.onb.employeereg.dao.SalaryConfigDAO;

@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

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

	public List<Department> getAll(Integer id) {
		return departmentDAO.getAll();
	}

	public Department get(Integer id) {
		return departmentDAO.get(id);
	}

	public void add(Department department) {
		departmentDAO.add(department);
	}

	public void delete(Integer id) {
		departmentDAO.delete(id);
	}

	public void edit(Department department) {
		departmentDAO.edit(department);
	}
}
