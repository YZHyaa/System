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
 *  关注/收藏按钮
 *  1.状态码？
 *  2.主键自增传null
 */
@Controller
@RequestMapping("/love")
public class LoveController {
	
	@Autowired
	LoveServiceImpl loveService;
	
	/*
	 * 关注某人
	 */
	@RequestMapping("/addFollow")
	@ResponseBody
	public void addFollow(Follow follow) {
		loveService.addFollow(follow);
	}
	
	/*
	 * 取消关注
	 */
	@RequestMapping("/cancelFollow")
	@ResponseBody
	public void cancelFollow(Follow follow) {
		loveService.cancelFollow(follow);
	}
	
	/*
	 * 添加收藏
	 */
	@RequestMapping("/addCollection")
	@ResponseBody
	public void addCollection(Collection collection) {
		loveService.addCollection(collection);
	}
	
	/*
	 * 取消收藏
	 */
	public void cancelCollection(Collection collection) {
		loveService.cancelCollection(collection);
	}
	
	
}
