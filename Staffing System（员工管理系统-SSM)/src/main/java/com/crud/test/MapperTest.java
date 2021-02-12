package com.crud.test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * �Ƽ�ʹ��Spring�ĵ�Ԫ���ԣ������Զ�ע����������Ҫ�����
 * 1������Spring Testģ��
 * 2��@ContextConfigurtionָ��Spring�����ļ�λ��
 * 3, ֱ��autowired
 */
import com.crud.bean.Department;
import com.crud.bean.Employee;
import com.crud.dao.DepartmentMapper;
import com.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	/*
	 * ����DepartmentMapper
	 */
	@Test
	public void testCrud() {
//		//1,����Springioc����
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
//		//2,�������л�ȡmapper
//		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		
		System.out.println(departmentMapper);
		//1,���뼸������
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null,"���Բ�"));
		
		//����Ա��
//		employeeMapper.insertSelective(new Employee(null,"Jerry","M","jerry@guigu.com",1));
		
		//�������� �� ʹ�ÿ�������������sqlsession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;++i) {
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@guigu.com",1));
		}
	}
}	
