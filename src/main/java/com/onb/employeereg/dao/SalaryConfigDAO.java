package com.onb.employeereg.dao;

import java.util.List;

import com.onb.employeereg.domain.SalaryConfig;
 
public interface SalaryConfigDAO {

	SalaryConfig get( Integer id );
	
	void edit(SalaryConfig salaryConfig);
}
