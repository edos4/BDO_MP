package com.onb.employeereg.service;

import java.util.List;

import com.onb.employeereg.domain.Branch;
 
public interface BranchService {

	List<Branch> getAll();
	
	Branch get( Integer id );
	
	void add(Branch branch) ;
	
	void delete(Integer id);
	
	void edit(Branch branch);
}
