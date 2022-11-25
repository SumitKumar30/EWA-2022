<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Action Tags</title>
</head>
<body>
	<h2>JSP Forward Demo</h2>
	<jsp:forward page="hello.jsp">
		<jsp:param  name="Date" value="22-11-2022"/>
		<jsp:param  name="Time" value="11 AM"/>
		<jsp:param  name="Location" value="Delhi"/>
	</jsp:forward>
	
</body>
</html>