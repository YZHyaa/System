package com.ezhao.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ezhao.entity.Message;
import com.ezhao.mapper.MessageMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestMessageMapper {
	
	@Autowired
	MessageMapper messageMapper;
	
	@Test
	public void m5() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("fromId",1);
//		map.put("toId", 2);
//		System.out.println(messageMapper.findHistoryMsg(map));
		
		messageMapper.insertMsg(new Message(1, 3, "Œ“ «À≠∞°£ø", new Date()));
	}
}
