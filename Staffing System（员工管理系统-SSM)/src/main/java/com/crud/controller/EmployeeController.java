package com.crud.controller;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.aspectj.weaver.bcel.UnwovenClassFileWithThirdPartyManagedBytecode.IByteCodeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * 处理员工crud
 */
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.bean.Employee;
import com.crud.bean.Msg;
import com.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	/*
	 * 查询员工的数据（分页查询）
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		//1,引入插件
		//2，在查询开始之前只需要传入要查询的页码和每页大小
		PageHelper.startPage(pn,5);
		//startpage后面跟的就是分页查询
		List<Employee> emps = employeeService.getAll();
		//使用pageinfo包装查询后的结果，只需要将pageinfo交给页面就可以
		//封装了分页查询信息，包括查出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);

		return Msg.success().add("pageInfo", page);
	}

//	@RequestMapping("/emps")
//	@ResponseBody
//	public ResponseEntity<PageInfo> getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
//		//1,引入插件
//		//2，在查询开始之前只需要传入要查询的页码和每页大小
//		PageHelper.startPage(pn,5);
//		//startpage后面跟的就是分页查询
//		List<Employee> emps = employeeService.getAll();
//		//使用pageinfo包装查询后的结果，只需要将pageinfo交给页面就可以
//		//封装了分页查询信息，包括查出来的数据,传入连续显示的页数
//		PageInfo page = new PageInfo(emps);
//
//		//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		return ResponseEntity.ok(page);
//	}

//	@RequestMapping("/emps")
//	@ResponseBody
//	public ResponseEntity<PageInfo> getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
//		List<Employee> emps = employeeService.getAll();
//
//		return ResponseEntity.ok(PageUtil.page(pn, emps));
//	}

	/*
	 * 员工保存
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee ,BindingResult result) {
		if(result.hasErrors()) {
			//校验失败，应返回失败，在模态框中显示校验失败的错误信息
			Map<String, Object> map = new HashMap<String, Object>();
			 List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError : errors) {
				System.out.println("错误的字段名："+fieldError.getField());
				System.out.println("错误信息："+fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else {
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}

	/*
	 * 检验用户名是否可用
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName) {
		//先判断用户名是否是合法的表达式
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		if(!empName.matches(regx)) {
			return Msg.fail().add("va_msg", "用户名必须是6-16位数字和字母的组合或者2-5位中文");
		}
		//数据库用户名重复校验
		boolean b = employeeService.checkUser(empName);
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "用户名不可用");
		}
	}

	/*
	 * 根据id查询单个员工
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}

	/*
	 * 更新员工(保存)
	 * 需要封装put请求的数据->filter(解析，包装成map)
	 */
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg saveEmp(Employee employee) {
		employeeService.updateEmp(employee);
		return Msg.success();
	}

	/*
	 * 通过id删除员工
	 * 单个/批量(1-2-3)均可
	 */
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteEmpById(@PathVariable("ids")String ids) {
		if (ids.contains("-")) {
            List<Integer> del_ids = new ArrayList<>();
             String[] str_ids = ids.split("-");
            for (String id:str_ids
                 ) {
                del_ids.add(Integer.parseInt(id));
            }
            employeeService.deleteBatch(del_ids);
        } else {
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }

        return Msg.success();
	}


}
