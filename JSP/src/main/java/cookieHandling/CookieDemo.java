package cookieHandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo
 */
public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// creating a cookie object
		Cookie cookieObj = new Cookie("cookie-servlet","True");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<h1> Hello User!</h1>"
				+"<h2>Cookies in Servlets</h2>");
		cookieObj.setMaxAge(3600*24);
		out.println("<h2> Cookie Name:"+cookieObj.getName()+"</h2>"+
					"<h3> Cookie Value: "+cookieObj.getValue()+"</h3>"+
					"<h4> Cookie Age: "+cookieObj.getMaxAge()+"</h4>"
				+"</body></html>");
		response.addCookie(cookieObj);
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
