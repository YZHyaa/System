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
	 *��ѯ����Ա��
	 */
	public List<Employee> getAll() {
		// TODO �Զ����ɵķ������
		return employeeMapper.selectByExampleWithDept(null);
	}
	/*
	 * ����Ա��
	 */
	public void saveEmp(Employee employee) {
		// TODO �Զ����ɵķ������
		employeeMapper.insertSelective(employee);
	}
	/*
	 * У���û����Ƿ����
	 */
	public boolean checkUser(String empName) {
		// TODO �Զ����ɵķ������
		EmployeeExample example = new EmployeeExample();
		com.crud.bean.EmployeeExample.Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count==0;
	}
	/*
	 * ��ѯָ��Ա��
	 */
	public Employee getEmp(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	/*
	 * Ա������
	 */
	public void updateEmp(Employee employee) {
		// TODO �Զ����ɵķ������
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/*
	 * Ա��ɾ��
	 */
	public void deleteEmp(Integer id) {
		// TODO �Զ����ɵķ������
		employeeMapper.deleteByPrimaryKey(id);
	}
	/*
	 * ����ɾ��
	 */
	public void deleteBatch(List<Integer> ids) {
		EmployeeExample example = new EmployeeExample();
		com.crud.bean.EmployeeExample.Criteria criteria =  example.createCriteria();
		//delete from xxx where emp_id in(1,2,3)
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}
	
}
