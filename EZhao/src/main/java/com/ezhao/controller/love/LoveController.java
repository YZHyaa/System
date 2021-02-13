package com.ezhao.controller.love;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezhao.entity.Collection;
import com.ezhao.entity.Follow;
import com.ezhao.service.impl.LoveServiceImpl;

/*
 *  ��ע/�ղذ�ť
 *  1.״̬�룿
 *  2.����������null
 */
@Controller
@RequestMapping("/love")
public class LoveController {
	
	@Autowired
	LoveServiceImpl loveService;
	
	/*
	 * ��עĳ��
	 */
	@RequestMapping("/addFollow")
	@ResponseBody
	public void addFollow(Follow follow) {
		loveService.addFollow(follow);
	}
	
	/*
	 * ȡ����ע
	 */
	@RequestMapping("/cancelFollow")
	@ResponseBody
	public void cancelFollow(Follow follow) {
		loveService.cancelFollow(follow);
	}
	
	/*
	 * ����ղ�
	 */
	@RequestMapping("/addCollection")
	@ResponseBody
	public void addCollection(Collection collection) {
		loveService.addCollection(collection);
	}
	
	/*
	 * ȡ���ղ�
	 */
	public void cancelCollection(Collection collection) {
		loveService.cancelCollection(collection);
	}
	
	
}
