package com.yedam.app.employee.service;

import java.util.List;

import com.yedam.app.employee.domain.EmployeeVO;

public interface EmployeeService {
	
	List<EmployeeVO> getList();
	
	public EmployeeVO read(EmployeeVO vo);
	
	public int insert(EmployeeVO vo);

}
