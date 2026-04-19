/* Build a servlet program to create a cookie to get your name through HTML form
and display Welcome message with visit count and cookie list with expiry */

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

// Handle request
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

String userName = request.getParameter("userName");

int count = 1;

// Read cookies
Cookie[] cookies = request.getCookies();
String existingUser = null;

if (cookies != null) {
for (Cookie c : cookies) {
if (c.getName().equals("user")) {
existingUser = c.getValue();
}
if (c.getName().equals("visitCount")) {
count = Integer.parseInt(c.getValue());
count++;
}
}
}

// Create cookies if new user
if (userName != null && !userName.isEmpty()) {
existingUser = userName;
}

// Set cookies
Cookie userCookie = new Cookie("user", existingUser);
Cookie countCookie = new Cookie("visitCount", String.valueOf(count));

// Expiry (30 sec)
userCookie.setMaxAge(30);
countCookie.setMaxAge(30);

response.addCookie(userCookie);
response.addCookie(countCookie);

// Output
out.println("<html><body>");

out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
out.println("<h3 style='color:magenta;'>You have visited this page " + count + " times!</h3>");

// Display cookie list
out.println("<h3>Cookie List:</h3>");
if (cookies != null) {
for (Cookie c : cookies) {
out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
}
}

out.println("<p><b>Note:</b> Cookies expire in 30 seconds.</p>");
out.println("<a href='index.html'>Go Back</a>");

out.println("</body></html>");
}
}
