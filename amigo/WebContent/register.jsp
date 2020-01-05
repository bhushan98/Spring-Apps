<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

<link href="WEB-INF/lib/bootstrap.min.css" rel="stylesheet" type="text/css" >
<style type="text/css">
    <%@include file="WEB-INF/lib/bootstrap.min.css" %>
</style> 
</head>

<body>
	<%@ include file = "banner.html" %>
	<h3>Register</h3>
	<form action="User.do">
		<table class="table">
			<tr>
				<td>Name </td>
				<td> <input type="text" name="name" class="form-control" required> </td>
			</tr>
			<tr>
				<td>Age: </td>
				<td>
					<select name="age" class="form-control">
						<% for(int i=18; i<=60; i++) { %>
						<option value="<%=i%>"><%=i%></option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td>
					<input type="radio" name="gender" value="male" required> Male <br>
					<input type="radio" name="gender" value="female" required> Female <br>
				</td>
			</tr>
			<tr>
				<td>City: </td>
				<td>
					<select name="city" class="form-control">
						<% String[] cities = {"Mumbai", "Pune", "Banglore", "Delhi", "Goa"}; 
							for(String c : cities) { %>
							<option value = "<%=c%>"><%=c%></option>	
						 <%	} %>
					</select>
				</td>
			</tr>
			<tr>
				<td>User ID: </td>
				<td><input type="text" name="userid" class="form-control" required></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="text" name="password" class="form-control" required></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><input type="mail" name="email" class="form-control" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" ></td>
			</tr>
			
		</table>
	</form>
</body>
</html>