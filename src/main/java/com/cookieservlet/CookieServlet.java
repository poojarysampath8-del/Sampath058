/* Build a servlet program to create a cookie to get your name through HTML form
and display message "Welcome back your name!", show number of visits,
list of cookies with their set values and demonstrate expiry of cookie. */

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

String userName = request.getParameter("userName");

int count = 1;
String existingUser = null;

// Read existing cookies
Cookie[] cookies = request.getCookies();

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

// If user enters name
if (userName != null && !userName.isEmpty()) {
existingUser = userName;
}

// Create cookies
Cookie userCookie = new Cookie("user", existingUser);
Cookie countCookie = new Cookie("visitCount", String.valueOf(count));

// Set expiry (30 seconds demonstration)
userCookie.setMaxAge(30);
countCookie.setMaxAge(30);

// Add cookies to response
response.addCookie(userCookie);
response.addCookie(countCookie);

// Output HTML
out.println("<html><body>");

out.println("<h2 style='color:blue;'>Welcome back " + existingUser + "!</h2>");
out.println("<h3 style='color:magenta;'>You have visited this page " + count + " times</h3>");

// Display cookie list with values
out.println("<h3>Cookie List (Name = Value):</h3>");
if (cookies != null) {
for (Cookie c : cookies) {
out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
}
} else {
out.println("<p>No cookies found</p>");
}

// Demonstrate expiry
out.println("<p><b>Note:</b> Cookies will expire in 30 seconds.</p>");
out.println("<p>After 30 seconds, refresh the page → visit count resets.</p>");

out.println("<a href='index.html'>Go Back</a>");

out.println("</body></html>");
}
}
