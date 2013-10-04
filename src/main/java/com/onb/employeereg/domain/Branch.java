package com.onb.employeereg.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH")
public class Branch implements Serializable {
	private static final long serialVersionUID = 7965651249779630993L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "BRANCH_LOCATION")
	private String branchLocation;

	@Column(name = "BRANCH_CONTACT_NUMBER")
	private Long branchContactNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchLocation() {
		return branchLocation;
	}

	public void setBranchLocation(String branchLocation) {
		this.branchLocation = branchLocation;
	}

	public Long getBranchContactNumber() {
		return branchContactNumber;
	}

	public void setBranchContactNumber(Long branchContactNumber) {
		this.branchContactNumber = branchContactNumber;
	}

}
