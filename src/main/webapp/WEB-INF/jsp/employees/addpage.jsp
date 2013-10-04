<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Employee</title>
</head>
<body>

<h1>Add New Employee</h1>

<c:url var="saveUrl" value="/employees/add" />
<form:form modelAttribute="employeeAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="employeeName">Name: </form:label></td>
			<td><form:input path="employeeName"/></td>
		</tr>

		<tr>
			<td><form:label path="employeeGrossSalary">Gross Salary: </form:label></td>
			<td><form:input path="employeeGrossSalary"/></td>
			<form:hidden path="departmentId" value="${ id }"/>
		</tr>
		
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>