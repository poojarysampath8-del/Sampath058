<%-- Display Result Page --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Result</title>

<style>
.pass { color:green; }
.fail { color:red; }
.error { color:red; }
</style>

</head>

<body>

<h2>Result</h2>

<%
String msg = (String) request.getAttribute("message");

if (msg != null && msg.contains("Error")) {
%>
<p class="error"><%= msg %></p>
<%
} else {
%>

<p><b>Roll No:</b> <%= request.getAttribute("roll") %></p>
<p><b>Name:</b> <%= request.getAttribute("name") %></p>

<p>Sub1: <%= request.getAttribute("sub1") %></p>
<p>Sub2: <%= request.getAttribute("sub2") %></p>
<p>Sub3: <%= request.getAttribute("sub3") %></p>
<p>Sub4: <%= request.getAttribute("sub4") %></p>
<p>Sub5: <%= request.getAttribute("sub5") %></p>

<p><b>Average:</b> <%= request.getAttribute("average") %></p>

<%
String res = (String) request.getAttribute("result");
if ("PASS".equals(res)) {
%>
<p class="pass"><b>Result: PASS</b></p>
<%
} else {
%>
<p class="fail"><b>Result: FAIL</b></p>
<%
}
}
%>

<br>
<a href="index.jsp">Back to Form</a>

</body>
</html>
