package com.onb.employeereg.service;

import java.util.List;

import com.onb.employeereg.domain.Department;
 
public interface DepartmentService {

	List<Department> getAll(Integer id);
	
	Department get( Integer id );
	
	void add(Department department) ;
	
	void delete(Integer id);
	
	void edit(Department department);
}
