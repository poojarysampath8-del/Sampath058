/* 7b. Build a servlet program to find the factorial of a number using HTML 
with step by step procedure. */

package com.factorial;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factorial")
public class FactorialServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {
// Get the number from the form
int number = Integer.parseInt(request.getParameter("number"));

// Validate input
if (number < 0) {
throw new IllegalArgumentException("Number cannot be negative");
}
if (number > 20) {
throw new IllegalArgumentException("Number too large, maximum allowed is 20");
}

// Calculate factorial
long factorial = 1;
String calculation = "Calculation steps:<br>";

if (number == 0 || number == 1) {
factorial = 1;
calculation += number + "! = 1";
} else {
calculation += number + "! = " + number;
for (int i = number; i >= 1; i--) {
factorial *= i;
if (i != number) {
calculation += " × " + i;
}
}
calculation += " = " + factorial;
}

// Output HTML
out.println("<html>");
out.println("<head><title>Factorial Result</title></head>");
out.println("<body>");
out.println("<h2>Factorial Result</h2>");
out.println("<p>Number: " + number + "</p>");
out.println("<p>Factorial: " + factorial + "</p>");
out.println("<p>" + calculation + "</p>");
out.println("<a href='index.html'>Calculate Again</a>");
out.println("</body>");
out.println("</html>");

} catch (Exception e) {
out.println("<h3>Error: " + e.getMessage() + "</h3>");
}
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.sendRedirect("index.html");
}
}
