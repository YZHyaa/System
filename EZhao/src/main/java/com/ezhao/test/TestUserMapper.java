package com.ezhao.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezhao.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestUserMapper {
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 
	 */
	@Test
	public void m1() {
		
//		System.out.println(userMapper);
//		
//		System.out.println(userMapper.findUserId("����"));
//		
//		userMapper.insertUser("����");
//		
//		System.out.println(userMapper.findUserId("����"));
//		userMapper.insertUserInfo(userMapper.findUserId("����"));
		
//		System.out.println(userMapper.findUserInfo(1));
		
//		Info info = new Info();
//		
//		info.setInfoName("��ʯ");
//		info.setInfoGender("��");
//		info.setInfoSchool("�����ʵ��ѧ");
//		info.setInfoCid("09189045");
//		info.setInfoProfession("�ڿ�");
//		info.setInfoPhone("12345678909");
//		info.setuName("����");
//		info.setuId(9);
//		
//		
//		userMapper.updateUserInfo(info);
		
//		userMapper.insertUserResume(9);
		
//		Resume resume = new Resume(null, "��ʿ", "��ש", "����", "12345678909", null, null, 9);
//		userMapper.updateUserResume(resume);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(userMapper.findUserById(list));
	}
}
