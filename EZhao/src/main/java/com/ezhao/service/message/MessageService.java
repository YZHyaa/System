package com.ezhao.service.message;

import java.util.List;
import java.util.Map;

import com.ezhao.entity.Message;

public interface MessageService {
	/*
	 * ��ȡ�����¼
	Integer fromId,Integer toId(�����Σ�
	 */
	public List<Message> getHistoryMsg(Map<String, Object> map);
	
	/*
	 * ���������¼
	 */
	public void saveMsg(Message message);
		
}
