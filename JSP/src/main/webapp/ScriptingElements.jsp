<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scripting Elements</title>
</head>
<body>
	<%! int count = 1; %>
	<% 
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
	%>
	<h1>Thanks for visiting us!!</h1>
	<p>Here is the information that you entered</p>
	<table border="1" cellpadding="5" cellspacing="5">
		<%-- Printing the user details --%>
		<tr>
			<td align="right">User Name:</td>
			<td>
				<%= name %>
			</td>
		</tr>
		<tr>
			<td align="right">Password:</td>
			<td>		
				<%= pass %>
			</td>
		</tr>
	</table>
	<form action="index.jsp" method="get">
		<input type="submit" value="return">
	</form>
	<%
		out.println("Value of count is: "+count);
		count++;
	%>
</body>
</html>