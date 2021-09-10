package com.yedam.app.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.mapper.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired EmployeeMapper empMapper;

	@Override
	public List<EmployeeVO> getList() {
		return empMapper.getList();
	}

	@Override
	public EmployeeVO read(EmployeeVO vo) {
		return empMapper.read(vo);
	}

	@Override
	public int insert(EmployeeVO vo) {
		return empMapper.insert(vo);
	}

}
