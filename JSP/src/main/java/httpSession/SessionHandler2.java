package httpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionHandler2
 */
public class SessionHandler2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionHandler2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 HttpSession session = request.getSession();
		  long creationTime = session.getCreationTime();
		  Date d = new Date(creationTime);
		  
		  long lastAccessTime = (long)session.getLastAccessedTime();
		  Date lastAccess = new Date(lastAccessTime);
		  
		session.setMaxInactiveInterval(10);
		
		
		  
		  int idleTime = session.getMaxInactiveInterval();
		  
		out.println("<html><body><h2>Welcome to Home Page</h2>");
		out.println("<h3>Your existing session id is: "+session.getId()+"</h3>");
		out.println("<h3>Session creating time is: "+d+"</h3>");
		out.println("<h3>Session last access time: "+lastAccess+"</h3>");
		out.println("<h3>Session idle time is: "+idleTime+" seconds</h3>");
		
		boolean timeOver = false;
		
		  while(timeOver == false) {
			 long timePassed = (System.currentTimeMillis() - session.getLastAccessedTime())/1000;
			//out.println("<h4>Time passed: "+timePassed+" seconds</h4>");
			  
			  if(timePassed >= idleTime ) { 
				  out.println("<h4>Time passed: "+timePassed+" seconds</h4>");
				  session.invalidate(); 
				  timeOver = true;
				  out.println("<p> session over!</p>");
				  out.println("<p><a href='/MavenDemo/index.jsp'>Login Again!</a>");
				  out.println("</body></html>");
			  }
		  
		  } //break; } }
		 
		  if(request.getSession(false) == null) {
			  //response.sendRedirect(request.getContextPath()+"/SessionHandling"); 
			  
		  }
		 
		
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
