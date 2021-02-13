package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.bean.Department;
import com.crud.bean.Msg;
import com.crud.service.DepartmentService;

/*
 * 处理部门有关请求
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/*
	 * 返回 所有部门请求 
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public  Msg getDepts() {
		//查出所有部门信息
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
}
