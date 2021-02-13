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
 * ����Ա��crud
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
	 * ��ѯԱ�������ݣ���ҳ��ѯ��
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		//1,������
		//2���ڲ�ѯ��ʼ֮ǰֻ��Ҫ����Ҫ��ѯ��ҳ���ÿҳ��С
		PageHelper.startPage(pn,5);
		//startpage������ľ��Ƿ�ҳ��ѯ
		List<Employee> emps = employeeService.getAll();
		//ʹ��pageinfo��װ��ѯ��Ľ����ֻ��Ҫ��pageinfo����ҳ��Ϳ���
		//��װ�˷�ҳ��ѯ��Ϣ�����������������,����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps,5);

		return Msg.success().add("pageInfo", page);
	}

//	@RequestMapping("/emps")
//	@ResponseBody
//	public ResponseEntity<PageInfo> getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
//		//1,������
//		//2���ڲ�ѯ��ʼ֮ǰֻ��Ҫ����Ҫ��ѯ��ҳ���ÿҳ��С
//		PageHelper.startPage(pn,5);
//		//startpage������ľ��Ƿ�ҳ��ѯ
//		List<Employee> emps = employeeService.getAll();
//		//ʹ��pageinfo��װ��ѯ��Ľ����ֻ��Ҫ��pageinfo����ҳ��Ϳ���
//		//��װ�˷�ҳ��ѯ��Ϣ�����������������,����������ʾ��ҳ��
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
	 * Ա������
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee ,BindingResult result) {
		if(result.hasErrors()) {
			//У��ʧ�ܣ�Ӧ����ʧ�ܣ���ģ̬������ʾУ��ʧ�ܵĴ�����Ϣ
			Map<String, Object> map = new HashMap<String, Object>();
			 List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError : errors) {
				System.out.println("������ֶ�����"+fieldError.getField());
				System.out.println("������Ϣ��"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else {
			employeeService.saveEmp(employee);
			return Msg.success();
		}
	}

	/*
	 * �����û����Ƿ����
	 */
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg checkuser(@RequestParam("empName")String empName) {
		//���ж��û����Ƿ��ǺϷ��ı��ʽ
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
		if(!empName.matches(regx)) {
			return Msg.fail().add("va_msg", "�û���������6-16λ���ֺ���ĸ����ϻ���2-5λ����");
		}
		//���ݿ��û����ظ�У��
		boolean b = employeeService.checkUser(empName);
		if(b) {
			return Msg.success();
		}else {
			return Msg.fail().add("va_msg", "�û���������");
		}
	}

	/*
	 * ����id��ѯ����Ա��
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("emp", employee);
	}

	/*
	 * ����Ա��(����)
	 * ��Ҫ��װput���������->filter(��������װ��map)
	 */
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg saveEmp(Employee employee) {
		employeeService.updateEmp(employee);
		return Msg.success();
	}

	/*
	 * ͨ��idɾ��Ա��
	 * ����/����(1-2-3)����
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
