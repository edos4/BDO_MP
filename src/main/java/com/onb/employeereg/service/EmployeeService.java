package com.onb.employeereg.service;

import java.util.List;

import com.onb.employeereg.domain.Employee;
 
public interface EmployeeService {

	List<Employee> getAll( Integer id );
	
	Employee get( Integer id );
	
	void add(Employee employee) ;
	
	void delete(Integer id);
	
	void edit(Employee employee);
}
