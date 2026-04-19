/* Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5
through JSP called index.jsp with client side validation and submit to servlet ResultServlet,
process with server side validation and display result (Pass if all subjects >= 40)
and average marks through result.jsp */

package com.result;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/processResult")
public class ResultServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

String roll = request.getParameter("roll");
String name = request.getParameter("name");

String message = "";

try {
int s1 = Integer.parseInt(request.getParameter("sub1"));
int s2 = Integer.parseInt(request.getParameter("sub2"));
int s3 = Integer.parseInt(request.getParameter("sub3"));
int s4 = Integer.parseInt(request.getParameter("sub4"));
int s5 = Integer.parseInt(request.getParameter("sub5"));

// Server-side validation
if (roll == null || roll.isEmpty() || name == null || name.isEmpty()) {
message = "Error: Roll No and Name required";
} else {

double avg = (s1 + s2 + s3 + s4 + s5) / 5.0;

String result;
if (s1 >= 40 && s2 >= 40 && s3 >= 40 && s4 >= 40 && s5 >= 40) {
result = "PASS";
} else {
result = "FAIL";
}

// set attributes
request.setAttribute("roll", roll);
request.setAttribute("name", name);
request.setAttribute("sub1", s1);
request.setAttribute("sub2", s2);
request.setAttribute("sub3", s3);
request.setAttribute("sub4", s4);
request.setAttribute("sub5", s5);
request.setAttribute("average", avg);
request.setAttribute("result", result);

message = "Result Processed Successfully";
}
} catch (Exception e) {
message = "Error: Invalid Marks";
}

request.setAttribute("message", message);

// forward
RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
rd.forward(request, response);
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.sendRedirect("index.jsp");
}
}
