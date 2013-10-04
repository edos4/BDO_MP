package com.onb.employeereg.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

	private static final long serialVersionUID = -2593606228673929777L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Column(name = "BRANCH_ID")
	private Integer branchId;

	@Column(name = "DEPARTMENT_NAME")
	private String departmentName;

	@Column(name = "DEPARTMENT_Bonus")
	private BigDecimal departmentBonus;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public BigDecimal getDepartmentBonus() {
		return departmentBonus;
	}

	public void setDepartmentBonus(BigDecimal departmentBonus) {
		this.departmentBonus = departmentBonus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
