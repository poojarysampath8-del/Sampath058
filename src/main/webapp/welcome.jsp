<%-- Build a Session Management using JSP program with one minute session expiry --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
String name = request.getParameter("uname");

out.print("Welcome! " + name);
out.print("<br>Session has started ... " + name);

// Store in session
session.setAttribute("user", name);

out.print("<br>Your name has been stored in session object");

// Set expiry = 60 seconds
session.setMaxInactiveInterval(60);

out.print("<br>One minute is set for the session expiry");
out.print("<br>Click the link within a minute or wait to see session expiry<br>");
%>

<a href="second.jsp">Display the value</a>

</body>
</html>
