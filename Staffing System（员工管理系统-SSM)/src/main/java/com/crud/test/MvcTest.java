package com.crud.test;


import java.util.List;


import com.crud.controller.DepartmentController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.crud.bean.Employee;
import com.github.pagehelper.PageInfo;

/*
 * ʹ��spring����ģ��Ĳ��������ܣ�����crud�������ȷ��
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:applicationContext-mvc.xml"})
public class MvcTest {
	
	@Autowired
	WebApplicationContext context;
	
	//����mvc���󣬻�ȡ��������
	MockMvc mockMvc;
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		//ģ�������õ�����ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		
		//����ɹ����������л���pageinfo�����ǿ���ȡ����������֤
		MockHttpServletRequest request = result.getRequest();
		PageInfo<Employee> pi = (PageInfo)request.getAttribute("pageInfo");
		System.out.println("��ǰҳ�룺"+pi.getPageNum());
		System.out.println("��ҳ�룺"+pi.getPages());
		System.out.println("�ܼ�¼����"+pi.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ�룺");
		int[] nums = pi.getNavigatepageNums();
		for(int i : nums) {
			System.out.println(" "+i);
		}
		
		//��ȡԱ������
		List<Employee> list = pi.getList();
		for(Employee employee : list) {
			System.out.println("ID:"+employee.getEmpId()+"NAME:"+employee.getEmpName());
		}
	}

}
