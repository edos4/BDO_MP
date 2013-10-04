package com.onb.employeereg.service;

import java.util.List;

import com.onb.employeereg.domain.SalaryConfig;
 
public interface SalaryConfigService {

	SalaryConfig get( Integer id );
	
	void edit(SalaryConfig salaryConfig);
}
