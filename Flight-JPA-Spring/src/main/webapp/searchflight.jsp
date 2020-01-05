<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Flight</title>
</head>
<body>
<form action="find.do">
<h1>Find Flight</h1>
<table>
	<tr>
		<td>Flight ID: </td>
		<td><input type="number" name="id"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Search"></td>
	</tr>
</table>
</form>
<hr>
Carrier: ${flight.carrier} <br>
Source: ${flight.source} <br>
Destination: ${flight.destination} <br>
Distance: ${flight.distance}<br>
</body>
</html>