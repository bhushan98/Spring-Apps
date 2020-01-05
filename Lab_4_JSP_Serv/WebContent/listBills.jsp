<%@page import="com.cg.bean.BillDetailsBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Details</title>
</head>
<body>
<%List<BillDetailsBean> bills = (List) request.getAttribute("bills");%>

<table border="1">
	<tr>
		<th>Bill Number</th>
		<th>Bill Month</th>
		<th>Meter Reading</th>
		<th>Units Consumed</th>
		<th>Bill Amount</th>
	</tr>
	<% for(BillDetailsBean bill : bills){ %>
	<tr>
		<td><%= bill.getBill_num() %></td>
		<td><%= bill.getBill_date().getMonth() %></td>
		<td><%= bill.getCurr_reading() %></td>
		<td><%= bill.getUnitConsumed() %></td>
		<td><%= bill.getNetAmount() %></td>
	</tr>
	<% } %>
</table>

<h3><a href="generateBill.jsp">generate bill</a></h3>
<h2><a href="index.html">Home</a></h2>
</body>
</html>