<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First JSP</title>
</head>
<body>
	<h1>Hello World</h1>
	<h2>Welcome to Java Server Pages</h2>
	<% Date now = new Date(); %>
	<h3>Visit Time : <%= now  %></h3>
	
	<%! int visitCount = 1001; %>
	<h3>Visitor Number: <%= visitCount++ %></h3>
</body>
</html>