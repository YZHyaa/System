package com.ezhao.controller.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezhao.entity.Message;
import com.ezhao.service.impl.MessageServiceImpl;

@Controller
@RequestMapping("/msg")
public class MessageController {
	
	@Autowired 
	MessageServiceImpl messageService;
	
	/*
	 * 获取聊天记录
	 */
	@RequestMapping("/getHistoryMsg")
	@ResponseBody
	public List<Message> getHistoryMsg(@RequestParam("fromId")Integer fromId,
			@RequestParam("toId") Integer toId){
		
		List<Message> list = new ArrayList<Message>();
		Map<String, Object> map_1 = new HashMap<String, Object>();
		Map<String, Object> map_2 = new HashMap<String, Object>();
		map_1.put("fromId", fromId);
		map_1.put("toId", toId);
		map_2.put("fromId", toId);
		map_2.put("toId",fromId);
		list.addAll(messageService.getHistoryMsg(map_1));
		list.addAll(messageService.getHistoryMsg(map_2));
		
		return list;
	}
	
}
