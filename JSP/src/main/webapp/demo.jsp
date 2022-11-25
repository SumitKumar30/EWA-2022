<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo</title>
<%@ page import="java.util.Date" %>
<%-- <%@ include file="/index.jsp" %> --%>
</head>
<body>
	<form action="InitialServlet" method="get">
		
	<%
		session = request.getSession();
		// get parameters from the request object
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
	%>
	<h2> <% out.println("Welcome to the world of JSP"); %> </h2>

	<p> <% 
		out.println("Hello, "+name+" Today's Date is: "+ new Date());
		%> 
	</p>
	<table cellspacing="5" cellpadding="5" border="2">
		<tr>
			<td align="center">User Name</td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td align="center">Password</td>
			<td><%= pass %></td>
		</tr>
	</table>
	<input type="submit" value="submit"> 
 </form>
</body>
</html>