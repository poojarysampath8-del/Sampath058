/* Build a Session Management using Servlet program (without using HTML) 
set with one minute session to show Session Tracking Information, 
Session ID, Session Creation Time, Last Access Time, Visit Count */

package com.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

// Get/Create session
HttpSession session = request.getSession(true);

// Set session expiry (1 minute = 60 seconds)
session.setMaxInactiveInterval(60);

// Session details
Date createTime = new Date(session.getCreationTime());
Date lastAccessTime = new Date(session.getLastAccessedTime());
String sessionId = session.getId();

// Visit count
Integer visitCount = (Integer) session.getAttribute("visitCount");

if (visitCount == null) {
visitCount = 1;
} else {
visitCount++;
}

// Store updated count
session.setAttribute("visitCount", visitCount);

// Set response type
response.setContentType("text/html");
PrintWriter out = response.getWriter();

// HTML Output
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head><title>Session Tracking</title></head>");
out.println("<body>");

out.println("<h2>Session Tracking Information</h2>");
out.println("<p>Session ID: " + sessionId + "</p>");
out.println("<p>Session Creation Time: " + createTime + "</p>");
out.println("<p>Last Access Time: " + lastAccessTime + "</p>");
out.println("<p>Visit Count: " + visitCount + "</p>");

out.println("</body>");
out.println("</html>");
}
}
