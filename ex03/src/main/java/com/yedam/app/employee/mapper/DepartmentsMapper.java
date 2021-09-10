package com.yedam.app.employee.mapper;

import java.util.List;

import com.yedam.app.employee.domain.DepartmentsVO;

public interface DepartmentsMapper {

	public List<DepartmentsVO> getDeptList();
	
	public DepartmentsVO insert();
	
}
