package com.onb.employeereg.dao;

import java.util.List;

import com.onb.employeereg.domain.Department;
 
public interface DepartmentDAO {

	List<Department> getAll();
	
	Department get( Integer id );
	
	void add(Department branch) ;
	
	void delete(Integer id);
	
	void edit(Department branch);
}
