package com.ezhao.mapper;

import java.util.List;
import java.util.Map;

import com.ezhao.entity.Message;

public interface MessageMapper {
	
	/*
	 * 查询历史记录
	 */
	public List<Message> findHistoryMsg(Map<String, Object> map);
	
	/*
	 * 保存消息
	 */
	public void insertMsg(Message message);
}
