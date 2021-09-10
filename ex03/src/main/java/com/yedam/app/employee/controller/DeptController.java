package com.yedam.app.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.employee.domain.DepartmentsVO;
import com.yedam.app.employee.service.DepartmentsService;

@Controller
public class DeptController {
	
	@Autowired DepartmentsService departmentsService;
	
	//부서관리 페이지
	@GetMapping("dept")
	public String dept() {
		return "emp/dept";
	}
	
	//ajax : 목록, 등록, 수정, 삭제
	@GetMapping("deptList")
	@ResponseBody
	public List<DepartmentsVO> deptList() {
		return departmentsService.getDeptList();
	}
	
//	@PostMapping
//	@ResponseBody
//	public DepartmentsVO insert() {
//		return departmentsService.insert();
//	}
}
