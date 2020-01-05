<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Info</title>
</head>
<body>
	
	<h2> Electricity Bill for consumer number <%= request.getAttribute("consumer") %> is :</h2> <br>
	Units Consumed : <%= request.getAttribute("units") %> <br>
	Net Amount : <%= request.getAttribute("amount") %>
	
<h3><a href="index.html">Home</a></h3>
</body>
</html>