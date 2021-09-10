package com.yedam.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.employee.domain.DepartmentsVO;
import com.yedam.app.employee.mapper.DepartmentsMapper;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired DepartmentsMapper departmentsMapper;

	@Override
	public List<DepartmentsVO> getDeptList() {
		return departmentsMapper.getDeptList();
	}

	@Override
	public DepartmentsVO insert() {
		return departmentsMapper.insert();
	}
	
}
