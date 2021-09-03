package co.yedam.app.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.yedam.app.Departments;

@Repository //DAO
public interface EmpMapper {

	List<Map> getEmp(String deptid);
	List<Departments> getDept();
	
	@Select("select sysdate from dual")
	public String getTime();
	
}
