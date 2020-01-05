<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<c:set var="test" value="Hello JSTL"/>
	<h1><c:out value="${test}"/></h1>
	
	<c:forEach var="counter" begin="1" end="10">
		<c:if test="${counter % 2 == 0 }">
			<h3>"${counter}"</h3>
		</c:if>
	</c:forEach>
	
	<c:set var="week" value="Sun-Mon-Tue-Wed-Thu-Fri-Sat"/>
	<c:forTokens items="${week}" delims="-" var="day">
		<h4><c:out value="${day}"/></h4>
	</c:forTokens>
</body>
</html>