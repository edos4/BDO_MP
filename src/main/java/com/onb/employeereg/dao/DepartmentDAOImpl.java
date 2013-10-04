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
public class DepartmentDAOImpl implements DepartmentDAO {

	protected static Logger logger = Logger.getLogger("service");

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public List<Department> getAll() {
		logger.debug("Retrieving all departments");

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("FROM  Department");

		return query.list();
	}

	public Department get(Integer id) {
		Session session = sessionFactory.getCurrentSession();

		Department department = (Department) session.get(Department.class, id);

		return department;
	}

	public void add(Department department) {
		logger.debug("Adding new department");

		Session session = sessionFactory.getCurrentSession();

		session.save(department);
	}

	public void delete(Integer id) {
		logger.debug("Deleting existing department");

		Session session = sessionFactory.getCurrentSession();

		Department department = (Department) session.get(Department.class, id);

		session.delete(department);
	}

	public void edit(Department department) {
		logger.debug("Editing existing department");

		Session session = sessionFactory.getCurrentSession();

		Department existingDepartment = (Department) session.get(
				Department.class, department.getId());

		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setDepartmentBonus(department.getDepartmentBonus());

		session.save(existingDepartment);
	}

}
