<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<jsp:useBean id="pers" class="com.cg.bean.Person" scope="session"/>

Name: ${pers.name} <br> <!-- Another way to get value  -->
Age: <jsp:getProperty property="age" name="pers"/> <br>
City: <jsp:getProperty property="city" name="pers"/>

</body>
</html>