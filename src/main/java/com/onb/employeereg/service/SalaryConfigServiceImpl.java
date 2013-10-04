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

import com.onb.employeereg.domain.SalaryConfig;
import com.onb.employeereg.dao.BranchDAO;
import com.onb.employeereg.dao.DepartmentDAO;
import com.onb.employeereg.dao.EmployeeDAO;
import com.onb.employeereg.dao.SalaryConfigDAO;

@Service("salaryConfigService")
@Transactional
public class SalaryConfigServiceImpl implements SalaryConfigService {

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

	public SalaryConfig get(Integer id) {
		return salaryConfigDAO.get(id);
	}

	public void edit(SalaryConfig salaryConfig) {
		salaryConfigDAO.edit(salaryConfig);
	}
}
