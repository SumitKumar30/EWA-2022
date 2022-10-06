package org.ncu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Step 1: load the database driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish the database connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ewa_ncu", "root", "Admin@12345");

		// Step 3: Create a Statement
		Statement stmt = con.createStatement();

		// Step 4: Execute the Statement
		/*
		 * String query =
		 * "CREATE table employee(id INTEGER(10) NOT NULL, emp_name VARCHAR(20), emp_salary INTEGER(15), emp_address VARCHAR(50), PRIMARY KEY (id))"
		 * ; int result = stmt.executeUpdate(query);
		 * 
		 * if(result == 1) { System.out.println("Operation failed!!!"); }else {
		 * System.out.println("Table is created successfully!!!"); }
		 */

		// Insert some data into employee table
		String query2 = "INSERT into employee VALUES(104, 'Rahul', 10000, 'Gurgaon'), "
				+ "(105, 'Jack', 250000, 'Hyderabad')," + "(106, 'Max', 500000, 'Pune')";

		if (stmt.executeUpdate(query2) == 1) {
			System.out.println("Insertion failed!!");
		} else {
			System.out.println("Data inserted successfully!!");
		}

		// Update a record
		String query4 = "UPDATE employee set emp_address = 'Chennai' WHERE id = 101";

		stmt.executeUpdate(query4);

		// delete a record
		String query5 = "DELETE from employee where id = 105";
		stmt.executeUpdate(query5);

		// Fetch the data from the database
		String query3 = "SELECT * from employee";

		ResultSet res = stmt.executeQuery(query3);

		while (res.next()) {
			int id = res.getInt("id");
			String name = res.getString("emp_name");
			int sal = res.getInt("emp_salary");
			String address = res.getString("emp_address");

			System.out.println("Id: " + id + " Name: " + name + " salary: " + sal + " Address: " + address);
		}

		System.out.println("Operation successfully completed!!");

		// Step 5: close the connection
		stmt.close();
		con.close();
	}

}
