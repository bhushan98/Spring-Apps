<%@page import="org.apache.taglibs.standard.tag.el.core.ForEachTag"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Flights</title>
</head>
<body>
	<form action="all.do">
		<input type="submit" value="Get All Flights">
	</form>
	 ${flights}
</body>
</html>