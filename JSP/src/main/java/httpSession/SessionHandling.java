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
 * Servlet implementation class SessionHandling
 */
public class SessionHandling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionHandling() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Step 1: Create a new session
		 HttpSession session = request.getSession();
		 
		 // Step 2: Authentication check - mock
		 String uname = request.getParameter("username");
		 String pass = request.getParameter("password");
		 if(uname.equals("John") && pass.equals("xyz")) {
			 out.println("<html><body><h2>Login Successful!!</h2>");
			 
			/*
			 * Date date = new Date(); String d = date.toString();
			 * session.setAttribute("timestamp", d);
			 */
			 
			 // return the session id
			 String sid = session.getId();
			 out.println("<h3>Session id is: "+sid+"</h3>");
			 out.println("<a href='SessionHandler2'>Click Me!</a>");
			 out.println("</body></html>");
		 }else {
			 out.println("<html><body><h2>Login Failed!!</h2>");
			 out.println("</body></html>");
		 }
		 out.close();
	}

}
