package co.yedam.app;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.yedam.app.impl.EmpMapper;
import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class EmpMapperClient {
	
	@Autowired EmpMapper dao;
	@Autowired SqlSessionTemplate mybatis;
	
	//@Test
	public void test() {
		log.info(dao.getEmp("50").toString());
	}

	//@Test
	public void getTime() {
		log.info("time == " + dao.getTime());
	}
	
	@Test
	public void myBatistest() {
		List<Employees> list = mybatis.selectList("co.yedam.app.impl.EmpMapper.getEmp", "50");
		log.info("job_id = " + list.get(0).getJobId());
	}
	
}
