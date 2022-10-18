/*
	1. import java.sql.*;
	2. Load and Register the Database driver (Connector file)
	3. Establish a connection with the database
	4. Create and Execute SQL queries in java (using Strings)
	5. Process the results (using ResultSet)
	6. close the connection (optional)
*/
package jdbcDemo;
import java.sql.*;		// Step 1
import java.util.Scanner;
public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		// Step 2: Load and Register the database driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 3: Establish a connection with the database
		String url = "jdbc:mysql://localhost:3306/ewa_ncu";
		String user = "root";
		String password = "Admin@12345";
		Connection con = DriverManager.getConnection(url, user, password);
	
		if(con != null)
				System.out.println("Connection is successfull....");
		
		// Step 4: Creating and Executing SQL Queries
	
		
		String select_query = "select * from citizen";
		
		System.out.println("Enter citizen id: ");
		int citi_id = sc.nextInt();
		
		
		sc.nextLine();
		System.out.println("Enter citizen name: ");
		String citi_name = sc.nextLine();
		
		System.out.println("Enter the DOB: ");
		String citi_dob = sc.next();
		
		sc.nextLine();
		System.out.println("Enter the address: ");
		String citi_add = sc.nextLine();
		
		String insert_query = "insert into citizen (id, name, dob, address) "
				+ "values ("+citi_id+", '"+citi_name+"', '"+citi_dob+"', '"+citi_add+"')";
		
		String insert_query2 = "insert into citizen (id, name, dob, address) values (? , ? , ?, ?)";

		PreparedStatement pstmt = con.prepareStatement(insert_query2);
		
		pstmt.setInt(1, citi_id);
		pstmt.setString(2, citi_name);
		pstmt.setString(3, citi_dob);
		pstmt.setString(4, citi_add);
		
		int rows = pstmt.executeUpdate();
		
		String update_query = "update citizen set address = ? where id = ?";
		System.out.println("Please enter the address: ");
		String add = sc.nextLine();
		
		System.out.println("Please enter the id: ");
		int id_value = sc.nextInt();
		
		PreparedStatement pstmt2 = con.prepareStatement(update_query);
		pstmt2.setString(1, add);
		
		pstmt2.setInt(2, id_value);
		
		pstmt2.executeUpdate();
		
		/*
		 * Statement stmt = con.createStatement(); int rows =
		 * stmt.executeUpdate(insert_query);
		 */
		
		if(rows == 1)
				System.out.println("Insertion is successfull!!");
		else
				System.out.println("Failed to insert a new record!!!");
		
		
//		ResultSet is Scrollable insensitive to changes at runtime & can update the records during runtime
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
		
		//Statement stmt = con.createStatement();
		ResultSet rst = stmt.executeQuery(select_query);
		
		
		
		// Step 5: Process the result 
		// Moves the ResultSet in forward direction --> top to bottom
		
		
		int count = 0;
		while(rst.next()) {
			int id = rst.getInt(1);
			String name = rst.getString(2);
			String gender = rst.getString(3);
			Date dob = rst.getDate(4);
			String mother_t = rst.getString(5);
			String address = rst.getString(6);
			boolean is_nri = rst.getBoolean(7);
			
			System.out.println("Citizen ID: "+id+" "
					+ " Citizen Name: "+name+" "
					+ " Gender: "+gender+" "
					+ "DOB: "+dob+" "
					+ "Mother Tongue: "+mother_t+" "
					+ " Address: "+address+" "
					+ " IS-NRI: "+is_nri);
			count++;
			// Update the record for row 3
			if(count == 3) {
				
				  rst.updateString(2, "John"); rst.updateString(5, "English");
				  rst.updateString(6, "New Jersey");
				 
				rst.updateRow();
			}
		}
		
	
		
		System.out.println("\n");
		System.out.println("Moving ResultSet cursor from Bottom to top.....");
		// Moving ResultSet cursor in reverse direction --> Bottom to top 
		while(rst.previous()) {
			int id = rst.getInt(1);
			String name = rst.getString(2);
			String gender = rst.getString(3);
			Date dob = rst.getDate(4);
			String mother_t = rst.getString(5);
			String address = rst.getString(6);
			boolean is_nri = rst.getBoolean(7);
			
			System.out.println("Citizen ID: "+id+" "
					+ " Citizen Name: "+name+" "
					+ " Gender: "+gender+" "
					+ "DOB: "+dob+" "
					+ "Mother Tongue: "+mother_t+" "
					+ " Address: "+address+" "
					+ " IS-NRI: "+is_nri);
		}
		
		rst.moveToInsertRow();
		rst.updateInt(1, 205);
		rst.updateString(2, "Dean");
		rst.updateString(6, "Chennai");
		rst.insertRow();
		
		System.out.println("Inserted a new row!!");
		// Step 6: Closing the database connection
		con.close();
		System.out.println("Connection closed!!!");
	}

}
