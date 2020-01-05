<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">
    <%@include file="WEB-INF/lib/bootstrap.min.css" %>
</style>  
</head>
<body>
	<%@ include file = "banner.html" %>
	<%if (request.getParameter("invalid") != null) { %>
		<font color="red">Invalid User ID or Password</font>
	<%} %>
	<% if(request.getParameter("logout") != null) {
		session.invalidate(); %>
	<font color="blue">Logged out successfully</font>
	<% } %>
	
	<h3>Login </h3>
	<form action="User.do">
		<table class="table">
			<tr>
				<td>User Name: </td>
				<td> <input type="text" name="userid" class="form-control" required> </td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="text" name="password" class="form-control" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>