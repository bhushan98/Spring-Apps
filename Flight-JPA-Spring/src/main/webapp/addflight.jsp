<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
<form action="add.do">
	<h1>Add a new flight</h1>
	<table>
		<tr>
			<td>Carrier:</td>
			<td><input name="carrier"></td>
		</tr>
		<tr>
			<td>Source:</td>
			<td><input name="source"></td>
		</tr>
		<tr>
			<td>Destination:</td>
			<td><input name="destination"></td>
		</tr>
		<tr>
			<td>Distance :</td>
			<td> <input type="number" name="distance"> </td>
		</tr>
		<tr>
			<td></td>
		 	<td>
		 		<input type="submit" value="Add Flight"> 
			</td>
		</tr>
	</table>
</form>
</body>
</html>