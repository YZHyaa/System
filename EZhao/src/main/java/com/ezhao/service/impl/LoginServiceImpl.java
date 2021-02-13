package com.ezhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.mapper.UserMapper;
import com.ezhao.service.login.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public Integer login(String uName) {
		
		Integer uId;
		
		if(userMapper.findUserId(uName) == null) {
			userMapper.insertUser(uName);
		}
		uId = userMapper.findUserId(uName);
		
		userMapper.insertUserInfo(uId);
		userMapper.insertUserResume(uId);
		
		return uId;
	}

}
