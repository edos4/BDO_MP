<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Salary Configurations</title>
</head>
<body>

<h1>Salary Configurations</h1>

<c:url var="saveUrl" value="/settings/edit?id=0" />
<form:form modelAttribute="settingsAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="tax">Tax:</form:label></td>
			<td><form:input path="tax"/></td>
		</tr>
	
		<tr>
			<td><form:label path="pagibig">Pagibig:</form:label></td>
			<td><form:input path="pagibig"/></td>
		</tr>

		<tr>
			<td><form:label path="sss">SSS</form:label></td>
			<td><form:input path="sss"/></td>
		</tr>
		
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>