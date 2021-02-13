package com.ezhao.controller.user;

import java.util.List;
import java.util.Map;

import javax.validation.Path.Node;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezhao.entity.Info;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.Resume;
import com.ezhao.service.impl.UserServiceImpl_1;
import com.ezhao.service.user.UserService_1;

/*
 *  ���ҵġ�
 */
@Controller
@RequestMapping("/user")
public class UserController_1 {
	
	@Autowired 
	UserServiceImpl_1 userService;
	
	/*
	 * ҳ�����ݣ���ע��/��˿��/�ղ�����
	 */
	@RequestMapping("/infoCount")
	@ResponseBody
	public Map<String, Integer> infoCount(@RequestParam("uId") Integer uId) {
		
		return userService.infoCount(uId);
	}
	
	/*
	 * �鿴����
	 */
	@RequestMapping("/checkInfo/{uId}")
	@ResponseBody
	public Info checkInfo(@PathVariable("uId") Integer uId) {
		
		return userService.checkInfo(uId);
	}
	
	/*
	 * �༭����
	 */
	@RequestMapping("/editInfo")
	@ResponseBody
	public void editInfo(Info info) {
		userService.editInfo(info);
	}
	
	/*
	 * ��ע�б�
	 */
	@RequestMapping("/payList/{uId}")
	@ResponseBody
	public List<InfoOutline> followList(@PathVariable("uId") Integer uId){
		
		return userService.followList(uId);
	}
	
	/*
	 * ��˿�б�
	 */
	@RequestMapping("/fansList/{uId}")
	@ResponseBody
	public List<InfoOutline> fansList(@PathVariable("uId") Integer uId){
		
		return userService.fansList(uId);
	}
	
	/*
	 * �ղ��б�
	 */
	@RequestMapping("/collectList/{uId}")
	@ResponseBody
	public List<NoteOutline> collectList(@PathVariable("uId") Integer uId){
		
		return userService.collectList(uId);
	}
	
	
}
