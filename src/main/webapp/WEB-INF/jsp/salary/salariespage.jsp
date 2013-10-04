<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Salary Configuration</title>
<style>
	th{
		color: rgb(255, 178, 12);
	}
</style>
</head>
<body>
<h1>Salary Configuration</h1>

<br>
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#0b276e;">
		<tr>
			<th>Tax</th>
			<th>Pagibig</th>
			<th>SSS</th>
			<th colspan="2">Action</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${branches}" var="branches">
			<c:url var="editUrl" value="/branch/branches/edit?id=${branches.id}" />
			<c:url var="deleteUrl" value="/branch/branches/delete?id=${branches.id}" />
			<c:url var="viewUrl" value="/branch/branches/view?id=${branches.id}" />
		<tr>
			<td><a href="${viewUrl}"><c:out value="${branches.branchName}" /></a></td>
			<td><c:out value="${branches.branchLocation}" /></td>
			<td><c:out value="${branches.money}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty branches}">
	There are currently no branches in the list. <a href="${addUrl}">Add</a> a Branch.
</c:if>

</body>
</html>