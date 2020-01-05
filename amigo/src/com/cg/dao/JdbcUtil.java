package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class JdbcUtil {
	private JdbcUtil() {
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties p = new Properties();
//		try {
//			p.load(new FileReader("src/oracle.ds"));
//		} catch (IOException e) {
//			throw new SQLException(e.getMessage());
//		}
		
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user =  "bhushan";
		String password = "oracle";
		
		// Registering driver with driver manager
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
