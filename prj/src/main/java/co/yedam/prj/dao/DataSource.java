package co.yedam.prj.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	
	private static DataSource dataSource = new DataSource(); // 싱글톤, 자기 자신의 인스턴스
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {} // 생성자 (외부 생성 금지)
	
	public static DataSource getInstance() { // 외부 사용 시 인스턴스 리턴
		
		return dataSource;
	}
	
	public Connection getConnection() {
		
		configure(); // 외부 properties 파일을 읽어옴
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void configure() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
