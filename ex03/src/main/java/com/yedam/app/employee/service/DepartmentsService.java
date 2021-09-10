package com.yedam.app.employee.service;

import java.util.List;

import com.yedam.app.employee.domain.DepartmentsVO;

public interface DepartmentsService {

	public List<DepartmentsVO> getDeptList();
	
	public DepartmentsVO insert();
	
}
