package com.ezhao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.entity.Message;
import com.ezhao.mapper.MessageMapper;
import com.ezhao.service.message.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	MessageMapper messageMapper;

	@Override
	public void saveMsg(Message message) {
		messageMapper.insertMsg(message);
	}
	
	@Override
	public List<Message> getHistoryMsg(Map<String, Object> map) {
		messageMapper.findHistoryMsg(map);
		return null;
	}

}
