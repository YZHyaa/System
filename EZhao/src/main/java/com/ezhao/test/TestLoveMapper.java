package com.ezhao.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezhao.mapper.LoveMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestLoveMapper {
	
	@Autowired
	LoveMapper loveMapper;
	
	@Test
	public void m3() {
//		loveMapper.insertCollection(new Collection(8, 5));
		
//		loveMapper.deleteCollection(new Collection(1, 8));
		
//		System.out.println(loveMapper.findCollectionList(3));
		
//		System.out.println(loveMapper.findCollectionCount(3));
		
//		loveMapper.insertFollow(new Follow(1,8));
		
//		loveMapper.deleteFollow(new Follow(1,8));
		
//	    System.out.println(loveMapper.findFollowList(3));	
		
//		System.out.println(loveMapper.findFollowCount(3));
		
//		System.out.println(loveMapper.findFansList(1));
		
		System.out.println(loveMapper.findFansCount(1));
		
	}
}
