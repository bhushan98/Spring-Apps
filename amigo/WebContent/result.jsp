<%@page import="com.cg.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<style type="text/css">
    <%@include file="WEB-INF/lib/bootstrap.min.css" %>
</style> 
</head>
<body>
	<%@ include file = "banner.html" %>
	<% String name = (String) session.getAttribute("USER"); 
	if(name != null) {%>
		<p> Welcome <%=name %> | <a href="home.jsp?logout=yes">Logout</a></p>
	<% } else { 
		response.sendRedirect("home.jsp");
	}%>
	<% List<UserBean> users = (List) request.getAttribute("USERS"); %>
	<table class="table">
	<% for(UserBean ub : users) { %>
		<tr>
			<td><%=ub.getName() %></td>
			<td><%=ub.getUserid() %> </td>
			<td><%=ub.getGender() %> </td>
			<td><%=ub.getAge() %> </td>
			<td><%=ub.getEmail() %> </td>
			<td><%=ub.getCity() %> </td>
	<% } %>		
		</tr>
	</table>
	<a href="search.jsp"> Search Again ...</a>
</body>
</html>