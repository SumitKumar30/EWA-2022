package jdbcDemo;
import java.sql.*;		// step 1: import sql package
public class MetadaDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Step 2: Load & Register your driver
			Class.forName("com.mysql.cj.jdbc.Driver");
				
		// Step 3: Open a database connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Admin@12345");
			
		// Step 4: Obtain DatabaseMetaData object 
			DatabaseMetaData metadata = con.getMetaData();
			
		// Step 5: Get Database Information
			
		System.out.println("Database product name is: "+metadata.getDatabaseProductName());
			
		System.out.println("Database product version: "+metadata.getDatabaseProductVersion());
		
		System.out.println("Driver name is: "+metadata.getDriverName());
		
		System.out.println("Driver version is: "+metadata.getDriverVersion());
		
		
		
		// Step 6: Get Table Information
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String[] types = {"TABLE"};
		ResultSet result = metadata.getTables(catalog, schemaPattern, tableNamePattern, types);
		
		System.out.println("Table information inside mysql database: ");
		// Printing table info
		while(result.next()) {
			String tableName = result.getString("table_name");
			System.out.println(tableName);
		}
		
		// Printing Column info
		result = metadata.getColumns(null, null, "movies", null);
		int count = 1;
		
		System.out.println("Column information inside movies table");
		while(result.next()) {
			String colName = result.getString("column_name"); // Print the table name at index position count
			String colType = result.getString("DATA_TYPE");
			String colSize = result.getString("column_size");
			System.out.println(colName);
			System.out.println(colType);
			System.out.println(colSize);
//			count++;
		}	
			
	}

}
