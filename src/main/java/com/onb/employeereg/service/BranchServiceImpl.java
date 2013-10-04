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

//import com.onb.employeereg.domain.Branch;
import com.onb.employeereg.dao.BranchDAO;
import com.onb.employeereg.dao.DepartmentDAO;
import com.onb.employeereg.dao.EmployeeDAO;
import com.onb.employeereg.dao.SalaryConfigDAO;
import com.onb.employeereg.domain.Branch;

@Service("branchService")
@Transactional
public class BranchServiceImpl implements BranchService {

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

	public List<Branch> getAll() {

		return branchDAO.getAll();
	}

	public Branch get(Integer id) {
		return branchDAO.get(id);
	}

	public void add(Branch branch) {
		branchDAO.add(branch);
	}

	public void delete(Integer id) {
		branchDAO.delete(id);
	}

	public void edit(Branch branch) {
		branchDAO.edit(branch);
	}
}
