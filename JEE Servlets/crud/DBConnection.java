package org.ncu.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db","root","Admin@12345");
       
		return con;
	}
}
