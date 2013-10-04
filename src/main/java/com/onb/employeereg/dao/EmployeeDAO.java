package com.onb.employeereg.dao;

import java.util.List;

import com.onb.employeereg.domain.Employee;
 
public interface EmployeeDAO {

	List<Employee> getAll();
	
	Employee get( Integer id );
	
	void add(Employee employee) ;
	
	void delete(Integer id);
	
	void edit(Employee employee);
}
