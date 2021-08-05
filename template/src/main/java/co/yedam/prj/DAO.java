package co.yedam.prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
	public Connection conn;
	
	public DAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "demo", "demo");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("연결 실패");
		}
	
	}
	
}
