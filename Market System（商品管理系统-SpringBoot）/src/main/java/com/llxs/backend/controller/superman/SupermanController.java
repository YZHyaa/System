package com.llxs.backend.controller.superman;

import com.alibaba.fastjson.JSONObject;
import com.llxs.backend.dto.LoginVo;
import com.llxs.backend.service.superman.SupermanService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/superman")
public class SupermanController {

    @Resource
    SupermanService supermanService;

    /**
     * 登录验证
     * @param json 用户名，密码
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<LoginVo> login(@RequestBody String json, HttpServletRequest request){

        LoginVo loginVo = new LoginVo();

        if(!supermanService.exist(json)){
            loginVo.setState(-1);
            loginVo.setDesc("用户名错误!");
            return ResponseEntity.ok(loginVo);
        }
        if(!supermanService.login(json)){
            loginVo.setState(0);
            loginVo.setDesc("密码错误!");
            return ResponseEntity.ok(loginVo);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("successlogin","success");

        loginVo.setState(1);
        loginVo.setDesc("成功！");
        return ResponseEntity.ok(loginVo);
    }

    /**
     * 记住我
     * @param json 用户名，密码
     * @return
     */
    @PostMapping("/remeberMe")
    public ResponseEntity<Void> rememberMe(@RequestBody String json, HttpServletResponse response){

        JSONObject jsonObject = JSONObject.parseObject(json);
        Cookie nameCookie = new Cookie("username",jsonObject.getString("username"));
        Cookie passwordCookie = new Cookie("password",jsonObject.getString("password"));
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);

        return ResponseEntity.ok().build();
    }

}
