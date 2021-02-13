package com.ezhao.service.message;

import java.util.List;
import java.util.Map;

import com.ezhao.entity.Message;

public interface MessageService {
	/*
	 * 获取聊天记录
	Integer fromId,Integer toId(查两次）
	 */
	public List<Message> getHistoryMsg(Map<String, Object> map);
	
	/*
	 * 保存聊天记录
	 */
	public void saveMsg(Message message);
		
}
