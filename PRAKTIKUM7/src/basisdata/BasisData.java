package basisdata;

import java.sql.Connection;
import java.sql.DriverManager;

public class BasisData {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL= "jdbc:mysql://localhost/database_buku";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection connect()throws Exception {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}