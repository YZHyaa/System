package com.ezhao.websocket;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/*
 * 该类自行启动
 */
public class ChatConfig implements ServerApplicationConfig{
	
	//接口方式的启动 （不用）
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
		return null;
	}

	//注解方式的启动
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		System.out.println("websocket启动！");
		
		return scan;
	}
	
}
