<%-- Session Management with dynamic expiry time --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>

<%
String name = request.getParameter("uname");
int time = Integer.parseInt(request.getParameter("time"));

// store in session
session.setAttribute("user", name);

// set expiry time (dynamic)
session.setMaxInactiveInterval(time);

out.print("<h2>Hello " + name + "!</h2>");
out.print("<p>Session started with expiry time: " + time + " seconds</p>");
out.print("<p>Click below within time OR wait to see session expiry</p>");
%>

<a href="second.jsp">Check Session</a>

</body>
</html>
