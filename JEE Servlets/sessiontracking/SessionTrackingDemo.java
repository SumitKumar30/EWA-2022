package org.ncu.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTrackingDemo
 */
public class SessionTrackingDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTrackingDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * // TODO Auto-generated method stub
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		
		// Set the response message's MIME type
	      response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Return the existing session if there is one. Create a new session otherwise.
	      // Step 1: Initiate a session
	      HttpSession session = request.getSession();
	      Integer accessCount;
	      
	      // Step 2: Get the session attributes --> increment the access count
	      accessCount = (Integer)session.getAttribute("visits");
	         if (accessCount == null) {
	            accessCount = 1;   // autobox int to Integer
	         } else {
	        	 accessCount = accessCount.intValue()+1;
//	        	 accessCount = new Integer(accessCount + 1);
	         }
	         
	       // Step 3: Set the session attributes - Track the access counts
	         session.setAttribute("visits", accessCount);

	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html>");
	         out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Session Test Servlet</title></head><body>");
	         out.println("<h2>You have access this site " + accessCount + " times in this session.</h2>");
	         out.println("<p>(Session ID is " + session.getId() + ")</p>");
	     
	         out.println("<p>(Session creation time is " +
	               new Date(session.getCreationTime()) + ")</p>");
	         out.println("<p>(Session last access time is " +
	               new Date(session.getLastAccessedTime()) + ")</p>");
	         out.println("<p>(Session max inactive interval  is " +
	               session.getMaxInactiveInterval() + " seconds)</p>");
	 
	         out.println("<p><a  href='" + request.getRequestURI() +  "'>Refresh</a>");
	         out.println("<p><a  href='" + response.encodeURL(request.getRequestURI())  +
	                     "'>Refresh with  URL rewriting</a>");
	         out.println("</body></html>");
	         
	         // Step 4: Invalidate the session
	         //	session.invalidate();
	      } finally {
	         out.close();  // Always close the output writer
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
