package httpSessionDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondSession
 */
public class SecondSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		 String sid = (String)session.getAttribute("sessionId");
		 String time = (String)session.getAttribute("timestamp");
		 
		 response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body><h2>First Session Attribute: "+sid+"</h2>"+
					"<h2>Second Session Attribute: "+time+"</h2>"
					);
			//out.close();
			session.invalidate();
		
			if(request.getSession(false) == null) {
				out.println("<h3>Session terminated successfully!</h3></body></html>");
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
