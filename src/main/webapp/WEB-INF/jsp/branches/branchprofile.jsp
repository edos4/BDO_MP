<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${branchAttribute.branchName}</title>
<style>
	th{
		color: rgb(255, 178, 12);
	}
</style>
</head>
<body>
	<c:url var="branches" value="/branches/" />
	<h1>
		<a href="${branches}">Branches</a> \ ${branchAttribute.branchName}
		<c:url var="addUrl2"
								value="/departments/add?id=${branchAttribute.id}" />
	</h1>
	<hr>
	<table width="100%">
		<tr>
			<td width="30%"><c:url var="saveUrl"
					value="/branches/view?id=${branchAttribute.id}" /> <form:form
					modelAttribute="branchAttribute" method="POST" action="${saveUrl}">
					<table>
						<tr>
							<td><form:label path="id">Id: ${branchAttribute.id}</form:label></td>
						</tr>

						<tr>
							<td><form:label path="branchName">Name: ${branchAttribute.branchName}</form:label></td>
						</tr>

						<tr>
							<td><form:label path="branchLocation">Location: ${branchAttribute.branchLocation}</form:label></td>
						</tr>

						<tr>
							<td><form:label path="branchContactNumber">Contact Number ${branchAttribute.branchContactNumber}</form:label></td>
						</tr>
					</table>

				</form:form></td>
			<td width="70%" align="center" valign="top">
				<align="left"><a href="${addUrl2}">Add</a> a department.</align><br>
				<table style="border: 1px solid; width: 500px; text-align: center">
					<thead style="background: #0b276e;">
						<tr>
							<th>Name</th>
							<th>Location</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${departments}" var="departments">
							<c:url var="editUrl"
								value="/departments/edit?id=${departments.id}" />
							<c:url var="deleteUrl"
								value="/departments/delete?id=${departments.id}" />
							<c:url var="viewUrl"
								value="/departments/view?id=${departments.id}" />
							
							
							<tr>
								<td><a href="${viewUrl}"><c:out
											value="${departments.departmentName}" /></a></td>
								<td><c:out value="${departments.departmentDescription}" /></td>
								<td><a href="${editUrl}">Edit</a></td>
								<td><a href="${deleteUrl}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 
					<c:if test="${empty departments}">
					There are currently no departments in the lists. <a href="${addUrl2}">Add</a> a department.
				</c:if>			
			</td>
		</tr>
		
		
	</table>
</body>
</html>