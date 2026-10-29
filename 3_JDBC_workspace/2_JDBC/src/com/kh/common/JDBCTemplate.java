package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// 싱글톤 패턴(Single Tone Pattern) : 프로그램 구동 시 메모리에 객체를 딱 하나만 기록되게 함
	// 모든 필드와 메소드를 static으로 선어하여 static 영역에서 공용으로 사용할 수 있게 함
	private static Connection conn = null;
	
	private JDBCTemplate() {}
	
	public static Connection getConnection() {
		if(conn == null) {
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} return conn;
	

	}
	public static void commit(Connection conn) {
		try {
			conn.setAutoCommit(false);
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !conn.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}