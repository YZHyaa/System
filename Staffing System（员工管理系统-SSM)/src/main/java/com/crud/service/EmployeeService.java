package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.bean.DepartmentExample.Criteria;
import com.crud.bean.Employee;
import com.crud.bean.EmployeeExample;
import com.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	/*
	 *查询所有员工
	 */
	public List<Employee> getAll() {
		// TODO 自动生成的方法存根
		return employeeMapper.selectByExampleWithDept(null);
	}
	/*
	 * 保存员工
	 */
	public void saveEmp(Employee employee) {
		// TODO 自动生成的方法存根
		employeeMapper.insertSelective(employee);
	}
	/*
	 * 校验用户名是否可用
	 */
	public boolean checkUser(String empName) {
		// TODO 自动生成的方法存根
		EmployeeExample example = new EmployeeExample();
		com.crud.bean.EmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count==0;
	}
	/*
	 * 查询指定员工
	 */
	public Employee getEmp(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	/*
	 * 员工更新
	 */
	public void updateEmp(Employee employee) {
		// TODO 自动生成的方法存根
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/*
	 * 员工删除
	 */
	public void deleteEmp(Integer id) {
		// TODO 自动生成的方法存根
		employeeMapper.deleteByPrimaryKey(id);
	}
	/*
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();
		com.crud.bean.EmployeeExample.Criteria criteria =  example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}
	
}
