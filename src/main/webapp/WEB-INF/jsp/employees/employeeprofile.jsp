<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${employeeAttribute.employeeName}</title>
</head>
<body>

<c:url var="saveUrl" value="/employees/view?id=${employeeAttribute.id}" />
<form:form modelAttribute="employeeAttribute" method="POST" action="${saveUrl}">
	<table>
	
		<tr>
			<td><form:label path="employeeName">Name: ${employeeAttribute.employeeName}</form:label></td>
			
		</tr>

		<tr>
			<td><form:label path="employeeGrossSalary">Gross Salary: ${employeeAttribute.employeeGrossSalary}</form:label></td>
			
		</tr>
		
	</table>
	
</form:form><br>
Salary Computation:<br>

<table border="1" bordercolor="#0b276e" style="background-color:#FFFFFF" width="100%" cellpadding="3" cellspacing="3">
	<tr>
		<td>Gross Salary:</td>
		<td>${ employeeAttribute.employeeGrossSalary }</td>
		<td></td>
	</tr>
	<tr>
		<td>Tax Deduction: (Gross(${employeeAttribute.employeeGrossSalary}) * Tax(${salaryAttribute.tax}))</td>
		<td></td>
		<td><font color="red">${ employeeAttribute.employeeGrossSalary * salaryAttribute.tax}</font></td>
	</tr>
	<tr>
		<td>Pagibig Deduction: (Gross(${employeeAttribute.employeeGrossSalary}) * Pagibig(${salaryAttribute.pagibig}))</td>
		<td></td>
		<td><font color="red">${ employeeAttribute.employeeGrossSalary * salaryAttribute.pagibig}</font></td>
	</tr>
	<tr>
		<td>SSS Deduction: (Gross(${employeeAttribute.employeeGrossSalary}) * SSS(${salaryAttribute.sss}))</td>
		<td></td>
		<td><font color="red">${ employeeAttribute.employeeGrossSalary * salaryAttribute.pagibig}</font></td>
	</tr>
	<tr>
		<td>Department Bonus: (Gross(${employeeAttribute.employeeGrossSalary}) * Department Bonus(${departmentAttribute.departmentBonus}))</td>
		<td>${ employeeAttribute.employeeGrossSalary * departmentAttribute.departmentBonus}</td>
		<td></td>
	</tr>
	<tr></tr>
	<tr>
		<td>Subtotal: </td>
		<td>${ employeeAttribute.employeeGrossSalary + (employeeAttribute.employeeGrossSalary * departmentAttribute.departmentBonus) }</td>
		<td><font color="red">${ (employeeAttribute.employeeGrossSalary * salaryAttribute.tax) + (employeeAttribute.employeeGrossSalary * salaryAttribute.pagibig) + (employeeAttribute.employeeGrossSalary * salaryAttribute.pagibig) }</font></td>
	</tr>
	<tr>
		<td>Net Salary: </td>
		<td></td>
		<td>${ (employeeAttribute.employeeGrossSalary + (employeeAttribute.employeeGrossSalary * departmentAttribute.departmentBonus)) -((employeeAttribute.employeeGrossSalary * salaryAttribute.tax) + (employeeAttribute.employeeGrossSalary * salaryAttribute.pagibig) + (employeeAttribute.employeeGrossSalary * salaryAttribute.pagibig)) }</td>
	</tr>
</table>

</body>
</html>