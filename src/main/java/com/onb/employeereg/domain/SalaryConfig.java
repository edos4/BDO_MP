package com.onb.employeereg.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALARYCONFIG")
public class SalaryConfig implements Serializable {

	private static final long serialVersionUID = -4366347118219819662L;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "TAX")
	private BigDecimal tax;
	
	@Column(name = "PAGIBIG")
	private BigDecimal pagibig;
	
	@Column(name = "SSS")
	private BigDecimal sss;

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getPagibig() {
		return pagibig;
	}

	public void setPagibig(BigDecimal pagibig) {
		this.pagibig = pagibig;
	}

	public BigDecimal getSss() {
		return sss;
	}

	public void setSss(BigDecimal sss) {
		this.sss = sss;
	}

}
