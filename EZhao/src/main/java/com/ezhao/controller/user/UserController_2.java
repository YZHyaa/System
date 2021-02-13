package com.ezhao.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.Resume;
import com.ezhao.service.impl.UserServiceImpl_2;

@Controller
@RequestMapping("/user")
public class UserController_2 {
	
	@Autowired
	UserServiceImpl_2 userService;
	
	/*
	 * 根据作者id查询帖子列表
	 */
	@RequestMapping("/getNoteById")
	@ResponseBody
	public List<NoteOutline> getNoteById(@RequestParam("authorId") Integer authorId) {
		
		return userService.getNoteById(authorId);
	}
	
	/*
	 * 浏览历史列表->数据库查
	 */
	@RequestMapping("/getHistoty")
	@ResponseBody
	public List<NoteOutline> getHistory(HttpServletRequest request){
		
		List<Integer> list = new ArrayList<Integer>();
		
		Cookie[] cs = request.getCookies();
		for(int i=0;cs!=null && i<cs.length;++i) {
			if("noteCookie".equals(cs[i].getName())) {
				String[] ids = cs[i].getValue().split("\\-");
				for(String str : ids) {
					list.add(Integer.parseInt(str));
				}
				break;
			}
		}
		
		return userService.getHistory(list);
	}
	
	/*	
	 * 删除浏览记录
	 */
	@RequestMapping("/deleteHistory")
	@ResponseBody
	public void deleteHistory(@RequestParam("noteId") Integer noteId,
			HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cs = request.getCookies();
		String noteCookie = "";
		
		String noteid = noteId.toString();
		for(int i=0;i<cs.length;++i) {
			if("noteCookie".equals(cs[i].getName())) {
				if(cs[i].getValue().indexOf(noteid) == 0) {
					noteCookie = cs[i].getValue().replace(noteid,"");
				}else {
					noteCookie = cs[i].getValue().replace("-"+noteid, "");
				}
			}
		}
		
		Cookie cookie = new Cookie("noteCookie", noteCookie);
		response.addCookie(cookie);
		
	}
	
	/*
	 * 查看简历
	 */
	@RequestMapping("/checkResume/{uId}")
	@ResponseBody
	public Resume checkResume(@PathVariable("uId") Integer uId) {
		
		return userService.checkResume(uId);
	}
	
	/*
	 * 编辑简历
	 */
	@RequestMapping("/editResume")
	@ResponseBody
	public void editResume(Resume resume) {
		userService.editResume(resume);
	}
	
}
