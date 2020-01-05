<%@page import="com.cg.bean.ConsumerBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
<%List<ConsumerBean> consumers = (List) request.getAttribute("USERS");%>

<table class="table" border="1">
	<tr>
		<th>User ID</th>
		<th>User Name</th>
		<th>Address</th>
		<th>Action</th>
	</tr>
	<% for(ConsumerBean cb : consumers) { %>
		<tr>
			<td><%=cb.getConsumer_num() %></td>
			<td><%=cb.getConsumer_name() %> </td>
			<td><%=cb.getAddress() %> </td>
			<td><a href="EBillServlet?consumerNo=<%=cb.getConsumer_num()%>">Show Bill Details</a></td>
		</tr>	
	<% } %>		
		
</table>

<h3><a href="index.html">Home</a></h3>
</body>
</html>