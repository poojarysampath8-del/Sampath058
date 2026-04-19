/* Build an Application to get Username, Email and Designation through JSP called
index.jsp with client side validation and submit to servlet UserDataServlet,
process with server side validation and display through result.jsp */

package com.HTTP_REQ_RES;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/processUser")
public class UserDataServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

String username = request.getParameter("username");
String email = request.getParameter("email");
String designation = request.getParameter("designation");

String message;

// Server-side validation
if (username == null || username.trim().isEmpty()) {
message = "Error: Username is required";
}
else if (email == null || !email.contains("@")) {
message = "Error: Invalid Email";
}
else if (designation == null || designation.trim().isEmpty()) {
message = "Error: Designation is required";
}
else {
message = "User data processed successfully";

// store values
request.setAttribute("username", username);
request.setAttribute("email", email);
request.setAttribute("designation", designation);
}

request.setAttribute("message", message);

// forward to JSP
RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
rd.forward(request, response);
}

// Redirect GET
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.sendRedirect("index.jsp");
}
}
