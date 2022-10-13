package org.ncu.ebookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EbookDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		
		// Step 1: load the mysql driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: Establish the database connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop_ncu","root","Admin@12345");

		// Step 3: Create a statement 
		Statement stm = con.createStatement();
		
		// Step 4: Execute CRUD operations
		
		System.out.println("*******Welcome to Ebook shop Database*******");
		
		System.out.println("Enter the book id: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the book title: ");
		String title = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter the book author: ");
		String author = sc.nextLine();
		
		System.out.println("Enter the book price: ");
		float price = sc.nextFloat();
		
		System.out.println("Enter the books quantity: ");
		int qty = sc.nextInt();
		
		//String insert = "INSERT into books VALUES ("+id+",'"+title+"', '"+author+"', "+price+", "+qty+")";
		
		String insert = "INSERT into books VALUES (?,?,?,?,?)";
		
		PreparedStatement pstm =  con.prepareStatement(insert);
		
		pstm.setInt(1,id);
		pstm.setString(2, title);
		pstm.setString(3, author);
		pstm.setFloat(4, price);
		pstm.setInt(5, qty);
		
		pstm.executeUpdate();
		
		/* stm.executeUpdate(insert); */
		
		System.out.println("Data inserted succesfully!!!!");
		
		System.out.println("Enter the book id you want to remove: ");
		int bookId = sc.nextInt();
		
		String delete = "DELETE from books where id = '"+bookId+"'";
		
		if(stm.executeUpdate(delete) == 1) {
			System.out.println("Record deleted successfully!!!");
		}else {
			System.out.println("Error deleting record!!!");
		}
		
		System.out.println("Enter the book id whose author you want to update");
		int id2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the author name you want to update");
		String bookAuthor = sc.nextLine();
		
		
		String update = "UPDATE books set author = '"+bookAuthor+"' WHERE id = "+id2+"";
		
		if(stm.executeUpdate(update) == 1) {
			System.out.println("Successfully Updated!!!");
		}else {
			System.out.println("Error updating the record!!");
		}
		
		String read = "SELECT * from books";
		
		ResultSet res  = stm.executeQuery(read);
		
		while(res.next()) {
			System.out.println("Id: "+res.getInt(1)+" Title: "+res.getString(2)+" Author: "+res.getString(3)+" Price: "+res.getFloat(4)+" Quantity: "+res.getInt(5));
		}
	}

}
