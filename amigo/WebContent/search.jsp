<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
<title>Search</title>
<style type="text/css">
    <%@include file="WEB-INF/lib/bootstrap.min.css" %>
</style> 
</head>
<body>
	
	<%@ include file = "banner.html" %>
	
	<% String name = (String)session.getAttribute("USER"); 
	if(name != null) { %>
		<p> Welcome <%=name %> | <a href="home.jsp?logout=yes">Logout</a>
	<% } else { 
		response.sendRedirect("home.jsp");
	}%>
	
	<h3>Search a Friend</h3>
	<form action="Search.do">
		<table class="table">
			<tr>
				<td>Age From: </td>
				<td>
					<select name="ageFrom" class="form-control">
						<% for(int i=18; i<=60; i++) { %>
						<option value="<%=i%>"><%=i%></option>
						<%} %>
					</select> 
				</td>
			</tr>
			<tr>
				<td>Age to: </td>
				<td>
					<select name="ageTo" class="form-control">
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
						<option value = "">Select</option>
						<% String[] cities = {"Mumbai", "Pune", "Banglore", "Delhi", "Goa"}; 
							for(String c : cities) { %>
							<option value = "<%=c%>"><%=c%></option>	
						 <%	} %>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
</body>
</html>