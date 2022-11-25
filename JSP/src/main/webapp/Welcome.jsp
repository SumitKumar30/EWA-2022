<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome JSTL</title>
</head>
<body>
	<c:set var="DemoVar" value="Demo Value" />
	<c:out value="${DemoVar}">No Name </c:out>
	<c:if test="${param.name == 'jstl'}">
      		<p>Welcome to ${param.name} </p>
    		</c:if>
	
</body>
</html>