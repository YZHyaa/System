package com.ezhao.mapper;

import java.util.List;
import java.util.Map;

import com.ezhao.entity.Message;

public interface MessageMapper {
	
	/*
	 * ��ѯ��ʷ��¼
	 */
	public List<Message> findHistoryMsg(Map<String, Object> map);
	
	/*
	 * ������Ϣ
	 */
	public void insertMsg(Message message);
}
