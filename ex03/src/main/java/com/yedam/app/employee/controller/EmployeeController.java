package com.yedam.app.employee.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.employee.domain.EmployeeVO;
import com.yedam.app.employee.service.DepartmentsService;
import com.yedam.app.employee.service.EmployeeService;
import com.yedam.app.employee.service.JobsService;

@Controller
@RequestMapping("/emp/*")
public class EmployeeController {
	
	@Autowired EmployeeService empService;
	@Autowired JobsService jobsService;
	@Autowired DepartmentsService departmentsService;
	
	@GetMapping("/list")
	public void getList(Model model) {
		model.addAttribute("list", empService.getList());
	}
	
	@RequestMapping("/search")
	public void search(Model model) {
		model.addAttribute("list", empService.getList());
	}
	
	@RequestMapping("ajaxEmp")
	@ResponseBody
	public EmployeeVO ajaxEmp(EmployeeVO vo) {
		return empService.read(vo);
	}
	
	@ModelAttribute("opt")
	public Map<String, Object> jobs() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobs", jobsService.getJobsList());
		map.put("depts", departmentsService.getDeptList());
		return map;
	}
	
	@GetMapping("/registerForm")
	public String registerForm(EmployeeVO vo) {
		return "emp/registerForm";
	}
	
	@PostMapping("/register")
	public String register(EmployeeVO vo, RedirectAttributes rttr) {
		empService.insert(vo);
		rttr.addFlashAttribute("result", vo.getEmployee_id());
		return "redirect:/emp/list";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(Model model, EmployeeVO vo) {
		model.addAttribute("emp", empService.read(vo));
		return "emp/registerForm";
	}
}
