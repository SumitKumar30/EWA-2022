package httpSessionDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		// authentication check (mock)
		if(uname.equals("john") && pass.equals("xyz123")) {
			// creating a new session
			
			
			session.setAttribute("sessionId", "HX123NB");
			
			Date date = new Date();
			
			String d = date.toString();
			
			session.setAttribute("timestamp", d);
			
			response.setContentType("text/html");
			
			out.println("<html><body>"+
			"<h2>Logged in Succesfully!! </h2>"+"<h3>Welcome "+uname+"</h3>"+
					"<h2><a href = 'SecondSession'>Click Me</a></h2>"
					+"</body></html>");
			
			
		}else {
			out.println("<html><body><h2>Invalid Credentials</h2></body></html>");
		}
		out.close();
		// terminate the session
		//session.invalidate();
	}

}
