package com.yedam.app.employee.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmployeeVO {
	
	private long employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hire_date;
	private String job_id;
	private long salary;
	private double commission_pct;
	private long manager_id;
	private long department_id;

}
