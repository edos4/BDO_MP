<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Branch</title>
</head>
<body>

<h1>Edit Branch</h1>

<c:url var="saveUrl" value="/branches/edit?id=${branchAttribute.id}" />
<form:form modelAttribute="branchAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="id">Id:</form:label></td>
			<td><form:input path="id" disabled="true"/></td>
		</tr>
	
		<tr>
			<td><form:label path="branchName">Name: </form:label></td>
			<td><form:input path="branchName"/></td>
		</tr>

		<tr>
			<td><form:label path="branchLocation">Location: </form:label></td>
			<td><form:input path="branchLocation"/></td>
		</tr>
		
		<tr>
			<td><form:label path="branchContactNumber">Contact Number: </form:label></td>
			<td><form:input path="branchContactNumber"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
<a href="http://localhost:8080/employee/branches">Back</a>
<br>
</body>
</html>