<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Bill</title>
</head>
<body>
	<form action="EBillServlet">
		Consumer Number: <input type="number" name="cons_no"> <br>
		Last Months Meter Reading: <input type="number" name="lastreading"> <br>
		Current Month Meter Reading: <input type="number" name="currreading"> <br>
		<input type="submit" value="Add Bill">
	</form>
	
<h3><a href="index.html">Home</a></h3>
</body>
</html>