package org.ncu.crud;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getQueryString();
		String[] ids = id.split("=");
		System.out.println("Update Servlet: "+ids[1]);
		String param = ids[1];
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","Admin@12345");
           
    		String username = param;
    		String password = request.getParameter("password");
    		String gender = request.getParameter("gender");
    		String age = request.getParameter("age");
    		int age_m = Integer.parseInt(age);
    		String language = request.getParameter("language");
    		String instruction = request.getParameter("instruction");
    		
            PreparedStatement ps=con.prepareStatement("update personal_info set name=?,password=?, gender=?, age=?, languages=?, instructions=? where name = ?");  
            ps.setString(1,username);  
            ps.setString(2,password);  
            ps.setString(3,gender);  
            ps.setInt(4,age_m);  
            ps.setString(5,language);
            ps.setString(6, instruction);
            ps.setString(7, param);
              
            int status=ps.executeUpdate();  
            
            response.sendRedirect("/demoapp/ViewServlet");
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
	}

}
