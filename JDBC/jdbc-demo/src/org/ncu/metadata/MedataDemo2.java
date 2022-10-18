package jdbcDemo;
import java.sql.*; 	// step 1: import sql package
public class MedataDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// Step 2: load & register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 3: establish a database connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","Admin@12345");
		
		// Step 4: obtain Database information
		DatabaseMetaData metadata = con.getMetaData();
		
		System.out.println("========= Database Metadata ==========");
		
		System.out.println("Database Product name is: "+metadata.getDatabaseProductName());
		
		System.out.println("Database product version is: "+metadata.getDatabaseProductVersion());
		
		System.out.println("Major version of database is: "+metadata.getDatabaseMajorVersion());
		
		System.out.println("Driver name is: "+metadata.getDriverName());
		
		System.out.println("Driver version is: "+metadata.getDriverVersion());
		
		// Step 5: obtain Table information
		
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String[] types = {"SYSTEM TABLE"};
		
		ResultSet rs = metadata.getTables(catalog, schemaPattern, tableNamePattern, types);
		
		System.out.println("===== Table Information =====");
		while(rs.next()) {
			String tableName = rs.getString("table_name");
			System.out.println(tableName);
		}
		
		rs = metadata.getColumns(catalog, schemaPattern, "movies", null);
		
		System.out.println("====== Column Information =======");
		
		while(rs.next()) {
			System.out.println("Column name is: "+rs.getString("column_name"));
			System.out.println("Column type is: "+rs.getString("data_type"));
			System.out.println("Column size is: "+rs.getString("column_size"));
		}
	}

}
