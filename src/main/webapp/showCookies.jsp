<%-- Display active cookies --%>

<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
<title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
Cookie[] cookies = request.getCookies();

if (cookies != null) {
for (Cookie c : cookies) {
out.println("<p>Name: " + c.getName() + 
            " | Value: " + c.getValue() + 
            " | Max Age: " + c.getMaxAge() + "</p>");
}
} else {
out.println("<p>No cookies found</p>");
}
%>

<br>
<a href="index.html">Add More Cookies</a>

</body>
</html>
