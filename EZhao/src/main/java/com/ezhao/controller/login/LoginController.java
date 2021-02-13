package com.ezhao.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezhao.service.impl.LoginServiceImpl;
import com.ezhao.service.login.LoginService;

/*
 *  进入小程序(/login)
 */
@Controller
public class LoginController {
	
	@Autowired
	LoginServiceImpl loginService;
	
	/*
	 * 用户名->id->session
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Integer login(@RequestParam("uName")String uName,
			HttpServletRequest request , HttpServletResponse response) {
		System.out.println(uName);
		
		HttpSession session = request.getSession(true);
		Integer uId = loginService.login(uName);
		session.setAttribute("uName",uName);
		session.setAttribute("uId", uId);
		
		return uId;
	}
}
