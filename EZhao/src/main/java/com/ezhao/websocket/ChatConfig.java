package com.ezhao.websocket;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/*
 * ������������
 */
public class ChatConfig implements ServerApplicationConfig{
	
	//�ӿڷ�ʽ������ �����ã�
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
		return null;
	}

	//ע�ⷽʽ������
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		System.out.println("websocket������");
		
		return scan;
	}
	
}
