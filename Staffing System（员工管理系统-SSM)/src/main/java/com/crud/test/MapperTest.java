package com.crud.test;


import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 推荐使用Spring的单元测试，可以自动注入我们所需要的组件
 * 1，导入Spring Test模块
 * 2，@ContextConfigurtion指定Spring配置文件位置
 * 3, 直接autowired
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
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCrud() {
//		//1,创建Springioc容器
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("application.xml");
//		//2,从容器中获取mapper
//		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		
		System.out.println(departmentMapper);
		//1,插入几个部门
//		departmentMapper.insertSelective(new Department(null,"开发部"));
//		departmentMapper.insertSelective(new Department(null,"测试部"));
		
		//插入员工
//		employeeMapper.insertSelective(new Employee(null,"Jerry","M","jerry@guigu.com",1));
		
		//批量插入 ， 使用可以批量操作的sqlsession
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;++i) {
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@guigu.com",1));
		}
	}
}	
