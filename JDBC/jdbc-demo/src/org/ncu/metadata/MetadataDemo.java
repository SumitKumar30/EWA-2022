package metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetadataDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");	
		
		String url = "jdbc:mysql://localhost:3306/ewa_ncu";
		String username = "root";
		String pass = "Admin@12345";
		
		// step3: Establish a connection with the database
		Connection con = DriverManager.getConnection(url, username, pass);
		
		if(con != null) {
			System.out.println("Connection established successfully!!");
		}
		
		// Step 4: Obtain Database Information
		
		DatabaseMetaData metaData  = con.getMetaData();
		
		System.out.println("======== Database Metadata =========");
		
		System.out.println("Database Product Name: "+metaData.getDatabaseProductName());
		
		System.out.println("Database Product Version: "+metaData.getDatabaseProductVersion());
		
		System.out.println("Database Major Version: "+metaData.getDatabaseMajorVersion());
		
		System.out.println("Driver Name: "+metaData.getDriverName());
		
		System.out.println("Driver Versoin: "+metaData.getDriverVersion());
		
		System.out.println("=========== Table Information ============");
		
		
		String[] tables = {"TABLE"};
		ResultSet rs = metaData.getTables(null, null, null, tables);
		
		
		while(rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			System.out.println("Table Name is: "+tableName);
		}
		
		System.out.println("============ Column Information ============");
		
		ResultSet rst = metaData.getColumns(null, null, "actor", null);
		
		System.out.println("Column information for citizen table");
		while(rst.next()) {
			 System.out.println(rst.getString("column_name")+" "+rst.getString("data_type")+" "+rst.getString("column_size"));
		}
	}

}
