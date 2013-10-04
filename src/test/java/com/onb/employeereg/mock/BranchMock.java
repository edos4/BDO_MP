package com.onb.employeereg.mock;

import com.onb.employeereg.domain.Branch;

public class BranchMock {
	private BranchMock() {
	}

	public static Branch generateBranch() {
		Branch br = new Branch();
		br.setId(1);
		br.setBranchContactNumber((long) 123);
		br.setBranchLocation("Here");
		br.setBranchName("Branch");

		return br;
	}
}
