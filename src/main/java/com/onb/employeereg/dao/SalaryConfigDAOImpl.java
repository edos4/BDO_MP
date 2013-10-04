package com.onb.employeereg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeereg.domain.SalaryConfig;

@Service("salaryConfigServices")
@Transactional
public class SalaryConfigDAOImpl implements SalaryConfigDAO {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public SalaryConfig get(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		SalaryConfig salaryConfig = (SalaryConfig) session.get(
				SalaryConfig.class, id);

		return salaryConfig;
	}

	public void edit(SalaryConfig salaryConfig) {
		logger.debug("Editing existing branch");

		Session session = sessionFactory.getCurrentSession();

		SalaryConfig presentSalary = (SalaryConfig) session.get(
				SalaryConfig.class, salaryConfig.getId());

		presentSalary.setPagibig(salaryConfig.getPagibig());
		presentSalary.setTax(salaryConfig.getTax());
		presentSalary.setSss(salaryConfig.getSss());

		session.save(presentSalary);
	}
}
