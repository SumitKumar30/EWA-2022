package org.ncu.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Personal List</h1>");  
        try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
	         
        		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","Admin@12345");
	         
        		Statement stmt = con.createStatement();
        		
        		String query = "select * from personal_info";
        		ResultSet rs = stmt.executeQuery(query);
        		out.print("<table border='1' width='100%'");  
    	        out.print("<tr><th>Name</th>"
    	        			+ "<th>Password</th>"
    	        			+ "<th>Gender</th>"
    	        			+ "<th>Age</th>"
    	        			+ "<th>Languages</th>"
    	        			+ "<th>Instructions</th>"
    	        			+ "<th>Edit</th>"
    	        			+ "<th>Delete</th>"
    	        		+ "</tr>");
        		while(rs.next()) {
        			 out.print("<tr>"
        			 				+"<td>"+rs.getString(1)+"</td>"
        			 				+"<td>"+rs.getString(2)+"</td>"
        			 				+"<td>"+rs.getString(3)+"</td>"
        			 				+"<td>"+rs.getInt(4)+"</td>"
        			 				+"<td>"+rs.getString(5)+"</td>"
        			 				+"<td>"+rs.getString(6)+"</td>"
        			 				+"<td><a href='EditServlet?id="+rs.getString(1)+"'>edit</a></td>"
        			 				+"<td><a href='DeleteServlet?id="+rs.getString(1)+"'>delete</a></td>"
        			 			+"</tr>");      	        
        		}
        
        }catch(ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
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
