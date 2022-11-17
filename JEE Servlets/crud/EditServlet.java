package org.ncu.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getPathInfo());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        String id = request.getQueryString();
        System.out.println("Query String: "+id);
		String[] ids = id.split("=");
		System.out.println("Edit Servlet: "+ids[1]);
		String selected_name = ids[1];
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","Admin@12345");
    		
//    		Statement stmt = con.createStatement();
    		
    		String query = "select * from personal_info where name = ?";
    		
    		PreparedStatement pst = con.prepareStatement(query);
    		pst.setString(1, selected_name);
    		
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()) {
    			out.print("<form action='UpdateServlet?id="+rs.getString(1)+"' method='post'>");  
                out.print("<table>");  
                out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+rs.getString(1)+"' disabled/></td></tr>");    
                out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+rs.getString(2)+"'/></td></tr>");  
                out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+rs.getString(3)+"'/></td></tr>");  
                out.print("<tr><td>Age:</td><td><input type='number' name='age' value='"+rs.getInt(4)+"'/></td></tr>");  
                out.print("<tr><td>Languages:</td><td><input type='text' name='language' value='"+rs.getString(5)+"'/></td></tr>");
                out.print("<tr><td>Instructions:</td><td><input type='text' name='instruction' value='"+rs.getString(6)+"'/></td></tr>");
                out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>");  
                out.print("</table>");  
                out.print("</form>");  
    		}
    		
    		
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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
