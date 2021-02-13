package com.ezhao.service.login;

public interface LoginService {
	
	/*
	 * 根据id查询是否存在->(新用户保存，创建资料/简历）->返回id
	 */
	public Integer login(String uName);
	
}
