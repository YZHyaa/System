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
//		System.out.println(userMapper.findUserId("张三"));
//		
//		userMapper.insertUser("测试");
//		
//		System.out.println(userMapper.findUserId("测试"));
//		userMapper.insertUserInfo(userMapper.findUserId("测试"));
		
//		System.out.println(userMapper.findUserInfo(1));
		
//		Info info = new Info();
//		
//		info.setInfoName("侧石");
//		info.setInfoGender("男");
//		info.setInfoSchool("西安邮电大学");
//		info.setInfoCid("09189045");
//		info.setInfoProfession("挖矿");
//		info.setInfoPhone("12345678909");
//		info.setuName("测试");
//		info.setuId(9);
//		
//		
//		userMapper.updateUserInfo(info);
		
//		userMapper.insertUserResume(9);
		
//		Resume resume = new Resume(null, "策士", "搬砖", "蓝翔", "12345678909", null, null, 9);
//		userMapper.updateUserResume(resume);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(userMapper.findUserById(list));
	}
}
