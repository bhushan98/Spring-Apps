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

<!-- Setting property with * will not require individual setting of properties -->
<jsp:setProperty property="*" name="pers"/>

<%-- 
<jsp:setProperty property="name" name="pers"/>
<jsp:setProperty property="age" name="pers"/>

<jsp:setProperty property="city" name="pers" param="city"/>
 --%> 
<!-- param not required if name of bean and input name is same -->

<!-- If we redirect with scope = "request" then we will get null 0 null-->
<!-- If we increase scope to session we will get desired output -->
<% response.sendRedirect("output.jsp"); %>

<%-- <jsp:forward page="output.jsp"/> --%>
</body>
</html>