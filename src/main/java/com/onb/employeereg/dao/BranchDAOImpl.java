package com.onb.employeereg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onb.employeereg.domain.Branch;

@Service("branchServices")
@Transactional
public class BranchDAOImpl implements BranchDAO {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public List<Branch> getAll() {
		logger.debug("Retrieving all branches");

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM  Branch");

		return query.list();
	}

	public Branch get(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Branch branch = (Branch) session.get(Branch.class, id);

		return branch;
	}

	public void add(Branch branch) {
		logger.debug("Adding new branch");

		Session session = sessionFactory.getCurrentSession();

		session.save(branch);
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing branch");

		Session session = sessionFactory.getCurrentSession();

		Branch branch = (Branch) session.get(Branch.class, id);

		session.delete(branch);
	}

	public void edit(Branch branch) {
		logger.debug("Editing existing branch");

		Session session = sessionFactory.getCurrentSession();

		Branch existingBranch = (Branch) session.get(Branch.class,
				branch.getId());

		existingBranch.setBranchName(branch.getBranchName());
		existingBranch.setBranchLocation(branch.getBranchLocation());
		existingBranch.setBranchContactNumber(branch.getBranchContactNumber());

		session.save(existingBranch);
	}
}
