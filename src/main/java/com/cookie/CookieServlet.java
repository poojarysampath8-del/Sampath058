/* Build a servlet program to create a cookie to get your name through text box and
press submit button (through HTML) to display the message by greeting 
"Welcome back your name!, you have visited this page n times" along with the
list of cookies and its set values and demonstrate the expiry of cookie also. */

package com.cookie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

String name = request.getParameter("username");

// default visit count
int count = 1;

// read existing cookies
Cookie[] cookies = request.getCookies();

if (cookies != null) {
for (Cookie c : cookies) {
if (c.getName().equals("visitCount")) {
count = Integer.parseInt(c.getValue());
count++;
}
}
}

// create cookies
Cookie nameCookie = new Cookie("username", name);
Cookie countCookie = new Cookie("visitCount", String.valueOf(count));

// set expiry (30 seconds for demo)
nameCookie.setMaxAge(30);
countCookie.setMaxAge(30);

response.addCookie(nameCookie);
response.addCookie(countCookie);

// response output
out.println("<html><body>");
out.println("<h2>Welcome back " + name + "!</h2>");
out.println("<p>You have visited this page " + count + " times.</p>");

// display cookies
out.println("<h3>Cookie List:</h3>");
if (cookies != null) {
for (Cookie c : cookies) {
out.println("<p>" + c.getName() + " = " + c.getValue() + "</p>");
}
}

out.println("<p><b>Note:</b> Cookies will expire in 30 seconds.</p>");
out.println("<a href='index.html'>Go Back</a>");
out.println("</body></html>");
}

// handle GET
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.sendRedirect("index.html");
}
}
