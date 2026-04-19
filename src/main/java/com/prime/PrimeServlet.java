/* Build a servlet program to check the given number is prime number or not,
using HTML, step by step procedure. */

package com.prime;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {
// Get input
String input = request.getParameter("number");
int num = Integer.parseInt(input);

// Validation
if (num < 0) {
response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 error
throw new IllegalArgumentException("Number must be positive");
}

// Prime logic
boolean isPrime = true;

if (num == 0 || num == 1) {
isPrime = false;
} else {
for (int i = 2; i <= num / 2; i++) {
if (num % i == 0) {
isPrime = false;
break;
}
}
}

// Output
out.println("<html><body>");
out.println("<h2>Prime Number Result</h2>");
out.println("<p>Entered Number: " + num + "</p>");

if (isPrime) {
out.println("<p style='color:green;'>It is a Prime Number</p>");
} else {
out.println("<p style='color:red;'>It is NOT a Prime Number</p>");
}

out.println("<a href='index.html'>Check Another</a>");
out.println("</body></html>");

} catch (NumberFormatException e) {
response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 error

out.println("<html><body>");
out.println("<h2 style='color:red;'>Error 400: Invalid Input</h2>");
out.println("<p>Please enter a valid integer number.</p>");
out.println("<a href='index.html'>Try Again</a>");
out.println("</body></html>");

} catch (IllegalArgumentException e) {
response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

out.println("<html><body>");
out.println("<h2 style='color:red;'>Error 400: " + e.getMessage() + "</h2>");
out.println("<a href='index.html'>Try Again</a>");
out.println("</body></html>");
}
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.sendRedirect("index.html");
}
}
