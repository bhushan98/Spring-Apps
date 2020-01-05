<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Details:</h1><hr>
	<h2>User ID: ${login.userid}</h2>
	<h2>Password: ${login.password} </h2>
	<hr>
	<a href="logout.do">Logout</a>
</body>
</html>