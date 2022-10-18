package transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Scanner;

public class Transactions {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/ewa_ncu";
		String username = "root";
		String pass = "Admin@12345";

		// step3: Establish a connection with the database
		Connection con = DriverManager.getConnection(url, username, pass);

		if (con != null) {
			System.out.println("Connection established successfully!!");
		}

		con.setAutoCommit(false);

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter citizen id: ");
		int id = sc.nextInt();

		sc.nextLine();
		System.out.println("Enter citizen name: ");
		String name = sc.nextLine();

		sc.nextLine();

		System.out.println("Enter citizen address: ");
		String address = sc.nextLine();

		System.out.println("Entered name is: " + name);

		// step4: Create Statement & Execute SQL Query
		String insertQuery = "insert into citizen (id, name, address) values (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(insertQuery);

		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, address);

		pstmt.executeUpdate();

		// save the changes permanently to database
		if (con != null) {
			con.commit();
			System.out.println("Transaction is succesfull!");
		}

		Savepoint savepoint = con.setSavepoint();

		String updateQuery = "update citizen set address = ? where id = ?";
		PreparedStatement pstmt2 = con.prepareStatement(updateQuery);

		pstmt2.setString(1, "Hyderabad");
		pstmt2.setInt(2, 312);

		pstmt2.executeUpdate();

		// if(con == null) {
		// con.rollback();	// revert all the changes to previous stable state
		con.rollback(savepoint); // revert all the change to previous savepoint/checkpoint
		// }

		if (con != null) {
			con.commit();
			System.out.println("Second transaction is also successfull!!");
		}

		con.close();

	}

}
