<%-- Check session validity --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Session Check</title>
</head>
<body>

<h2>Session Status</h2>

<%
String name = (String) session.getAttribute("user");

if (name == null)
    out.print("<h3 style='color:red;'>Session expired!</h3>");
else
    out.print("<h3>Hello " + name + "</h3>");
%>

</body>
</html>
