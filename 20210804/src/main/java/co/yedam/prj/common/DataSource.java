package co.yedam.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	
	private static SqlSessionFactory sqlSession;
	
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {
		try {
			String resource = "/mybatis-Config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
		
	}
	
}
