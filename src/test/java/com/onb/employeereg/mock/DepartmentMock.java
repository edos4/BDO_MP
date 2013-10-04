package com.onb.employeereg.mock;

import java.math.BigDecimal;

import com.onb.employeereg.domain.Department;

public class DepartmentMock {
	private DepartmentMock(){}
	
	public static Department generateDepartment(){
		Department dep = new Department();
		dep.setBranchId(1);
		dep.setDepartmentBonus(BigDecimal.valueOf(3.14));
		dep.setDepartmentName("Department One");
		dep.setId(1);
		
		return dep;
	}
}
