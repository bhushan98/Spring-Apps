<%@page import="com.cg.bean.ConsumerBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
<h3>Consumer Details</h3>
<% ConsumerBean consumer = (ConsumerBean) request.getAttribute("USER");%>
<table>
	<tr>
		<td>Consumer Number :</td>
		<td><%=consumer.getConsumer_num() %></td>
	</tr>
	<tr>
		<td>Consumer Name :</td>
		<td><%=consumer.getConsumer_name() %></td>
	</tr>
	<tr>
		<td>Consumer Address :</td>
		<td><%=consumer.getAddress() %></td>
	</tr>
</table>
 
 <h3><a href="EBillServlet?consumerNo=<%=consumer.getConsumer_num()%>">Show bill details</a></h3>


<h3><a href="index.html">Home</a></h3>

</body>
</html>