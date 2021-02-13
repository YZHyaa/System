package com.ezhao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezhao.mapper.NewsMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestNewsMapper {
	
	@Autowired 
	NewsMapper newsMapper;
	
	@Test
	public void m4() {
		
//		System.out.println(newsMapper.findNewsListByLab(6));
		
		System.out.println(newsMapper.findNews(1));
		
		
		
		
		
		
		
		
		
		
		
	}
}
