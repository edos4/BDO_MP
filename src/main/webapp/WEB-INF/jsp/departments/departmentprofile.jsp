<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${departmentAttribute.departmentName}</title>
<style>
	th{
		color: rgb(255, 178, 12);
	}
</style>
</head>
<body>

	<c:url var="branches" value="/branches/" />
	<c:url var="branchProfile" value="/branches/view?id=${branchAttribute.id}" />
	<h1>
		<a href="${branches}">Branches</a>\ <a href="${branchProfile}">${branchAttribute.branchName}</a> \ ${departmentAttribute.departmentName}
		<c:url var="addUrl2" value="/employees/add?id=${departmentAttribute.id}" />
	</h1>
	<hr>
	<table width="100%">
		<tr>
			<td width="30%"><c:url var="saveUrl"
					value="/departments/view?id=${departmentAttribute.id}" /> <form:form
					modelAttribute="departmentAttribute" method="POST" action="${saveUrl}">
					<table>
						<tr>
							<td><form:label path="id">Id: ${departmentAttribute.id}</form:label></td>
						</tr>

						<tr>
							<td><form:label path="departmentName">Name: ${departmentAttribute.departmentName}</form:label></td>
						</tr>
						
						<tr>
							<td><form:label path="departmentBonus">Bonus: ${departmentAttribute.departmentBonus}</form:label></td>
						</tr>

					</table>

				</form:form></td>
			<td width="70%" align="center" valign="top">
				<align="left"><a href="${addUrl2}">Add</a> an employee.</align><br>
				<table style="border: 1px solid; width: 500px; text-align: center">
					<thead style="background: #0b276e;">
						<tr>
							<th>Name</th>
							<th>Gross Salary</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="employees">
							<c:url var="editUrl"
								value="/employees/edit?id=${employees.id}" />
							<c:url var="deleteUrl"
								value="/employees/delete?id=${employees.id}" />
							<c:url var="viewUrl"
								value="/employees/view?id=${employees.id}" />
							
							<tr>
								<td><a href="${viewUrl}"><c:out
											value="${employees.employeeName}" /></a></td>
								<td><c:out value="${employees.employeeGrossSalary}" /></td>
								<td><a href="${editUrl}">Edit</a></td>
								<td><a href="${deleteUrl}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 
					<c:if test="${empty employees}">
					There are currently no employees in this department.
				</c:if>			
			</td>
		</tr>
	</table>
</body>
</html>