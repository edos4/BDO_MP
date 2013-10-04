package com.onb.employeereg.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import com.onb.employeereg.domain.Branch;
import com.onb.employeereg.service.BranchService;
import com.onb.employeereg.service.DepartmentService;

public class BranchControllerTest {
	public BranchControllerTest(){}
	
	@Mock
	private DepartmentService departmentService;
	
	@Mock
	private BranchService branchService;
	
	private Branch branch;
	
	@Before
	public void onSetup() {
		Branch branch = new Branch();
		branch.setBranchContactNumber((long)123);
		branch.setBranchLocation("Here");
		branch.setBranchName("AwesomeBank");
		branch.setId(1);
		branchService.add(branch);
	}
	
	@After
	public void onTearDown() {
		/*branch.setBranchContactNumber(null);
		branch.setBranchLocation(null);
		branch.setBranchName(null);
		branch.setId(null);*/
	}
	
	@Test
	public void getBranches() {
		// given
		Branch br = new Branch();

		// when
		List<Branch> branches = branchService.getAll();

		// then
		
		System.out.println(branches.size());
	}
	
}
