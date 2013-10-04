<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Branch</title>
</head>
<body>

<h1>Create New Branch</h1>

<c:url var="saveUrl" value="/branches/add" />
<form:form modelAttribute="branchAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="branchName">Name:</form:label></td>
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
<c:url var="back" value="/branches" />
<a href="${back}">Back</a><br>
</body>
</html>