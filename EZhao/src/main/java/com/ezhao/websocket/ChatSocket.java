package com.ezhao.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.alibaba.fastjson.JSON;
import com.ezhao.entity.Message;
import com.ezhao.mapper.MessageMapper;


@ServerEndpoint(value="/chat/{uId}",configurator = SpringConfigurator.class)
public class ChatSocket {
	
	@Autowired
	private MessageMapper messageMapper;
	
	private static Map<Integer, Session> map = new HashMap();
	
	/*
	 * �������ӣ������û�id��session���
	 */
	@OnOpen
	public void open(@PathParam("uId") Integer uId,Session session) {
		map.put(uId,session);
	}
	
	/*
	 * �ر����Ӻ�ɾ���ö�Ӧ
	 */
	@OnClose
	public void close(Session session) {
		Set<java.util.Map.Entry<Integer, Session>> entry = map.entrySet();
		for(java.util.Map.Entry<Integer, Session> e : entry) {
			if(e.getValue().equals(session)) {
				map.remove(e.getKey());
			}
		}
	}
	
	@OnMessage
	public void message(Session session,String msg) {
		Message Msg = JSON.parseObject(msg, Message.class);
		Integer to = Msg.getToId();
		Session sessionTo = map.get(to);
		try {
			sessionTo.getBasicRemote().sendText(Msg.toJson());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		saveMsg(Msg);
	}
	
	/*
	 * ������Ϣ
	 */
	public void saveMsg(Message msg) {
		messageMapper.insertMsg(msg);
	}
	
}
