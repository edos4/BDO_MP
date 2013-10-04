package com.onb.employeereg.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeereg.domain.SalaryConfig;

@Service("salaryConfigService")
@Transactional
public class SalaryConfigServiceImpl implements SalaryConfigService{

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public SalaryConfig get( Integer id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch first
		SalaryConfig salaryConfig = (SalaryConfig) session.get(SalaryConfig.class, id);
		
		return salaryConfig;
	}
	
	public void edit(SalaryConfig salaryConfig) {
		logger.debug("Editing existing branch");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing branch via id
		SalaryConfig presentSalary = (SalaryConfig) session.get(SalaryConfig.class, salaryConfig.getId());
		
		// Assign updated values to this branch
		presentSalary.setPagibig(salaryConfig.getPagibig());
		presentSalary.setTax(salaryConfig.getTax());
		presentSalary.setSss(salaryConfig.getSss());

		// Save updates
		session.save(presentSalary);
	}
}
