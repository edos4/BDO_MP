
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style>
.layout {
	color: rgb(255, 178, 12);
}
</style>
</head>
<body>
	<table border="1" cellspacing="2" align="center" width="100%">
		<tr>
			<td class="layout" height="30" colspan="2" align="center"
				style="background: #0b276e;"><tiles:insertAttribute
					name="header" /></td>
		</tr>
		<tr>

			<td width="100%" align="center"><tiles:insertAttribute
					name="body" /></td>
		</tr>
		<tr>
			<td class="layout" height="30" colspan="2" style="background: #0b276e;"><br>
			<tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>
