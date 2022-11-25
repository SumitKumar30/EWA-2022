package cookieHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitorCount
 */
public class VisitorCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Integer count = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// flag to check a user is a newbie or repeater
		 
		
		Boolean newVisitor = true;
		//count++;
		String greet= "";
		
		// to identify the user status
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("repeatedVisitor") && cookies[i].getValue().equals("yes")) {
				 newVisitor = false;
				 break;
			 }
			
		}
		
		if(newVisitor == true) {
			
			Cookie visitorCookie = new Cookie("repeatedVisitor", "yes");
			// creating a persistent cookie 
			// visitorCookie.setMaxAge(5);
			response.addCookie(visitorCookie);
			greet = "Welcome New Visitor!";
		}
		else {
			greet = "Welcome back Visitor!!";
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<h1>"+greet+"</h1>"
				+ "</body>"
				+ "</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
