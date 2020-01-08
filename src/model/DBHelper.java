package model;

import java.sql.*;

public class DBHelper {
	// 생성자 메소드
	public DBHelper() {
	}
	// connection을 리턴
	// db 연결 하는 메소드
	// getConnection의 매개변수는 문자열 세개
	public Connection getConnection(String driver, String dbid, String dbpw) throws Exception {
		Connection conn = null;
		Class.forName("org.mariadb.jdbc.Driver");
		// 사용자가 입력한 driver와 dbid, dbpw를 입력
		conn = DriverManager.getConnection(driver, dbid, dbpw);
		return conn;
	}
}
