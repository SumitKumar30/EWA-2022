package org.ncu.demo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// step 1: set the content type
		response.setContentType("text/html");
		
		// step 2: invoke the getWriter method
		
		 PrintWriter pw = response.getWriter();
		 
		 count++;
		 
		 pw.write("<html>"
		 		+ "<head>"
		 		+ "<title>"
		 		+ "Demo Servlet"
		 		+ "</title>"
		 		+ "</head>"
		 		+ "<body>"
		 		+ "Hello from Servlet!!"
		 		+ "Counter value = "+count+""
		 		+ "</body>"
		 		+ "</html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
