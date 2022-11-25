<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP visitor</title>
</head>
<body>
	<h3>Welcome to JSP Visitor!</h3>
	<p>
	<%
		Integer count = (Integer)application.getAttribute("visitor");
		if(count == null){
			count = 1;
			out.println("Welcome to Visitor Page...");
		}
		else{
			out.println("Welcome back to Visitor Page!");
			count++;
		}
		application.setAttribute("visitor", count);
		out.println("Visitor Count is: "+count);
		
	%>
	</p>
</body>
</html>