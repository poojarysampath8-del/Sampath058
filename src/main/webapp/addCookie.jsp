<%-- Add cookie and display its details --%>

<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
<title>Cookie Added</title>
</head>
<body>

<%
String name = request.getParameter("name");
String domain = request.getParameter("domain");
int age = Integer.parseInt(request.getParameter("age"));

// Create cookie
Cookie c = new Cookie(name, domain);
c.setMaxAge(age);

// Add cookie to response
response.addCookie(c);

// Display cookie info
out.println("<h2>Cookie Added Successfully</h2>");
out.println("<p>Name: " + name + "</p>");
out.println("<p>Value (Domain): " + domain + "</p>");
out.println("<p>Max Age: " + age + " seconds</p>");
%>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>
