package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Info;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.Resume;

public interface UserMapper {
	
	/*
	 * 查询微信用户的id（是否已经存储）
	 */
	public Integer findUserId(String uName);

	/*
	 * 添加微信用户
	 */
	public void insertUser(String uName);
	
	/*
	 * 给新用户创建资料行
	 */
	public void insertUserInfo(Integer uId);
	
	/*
	 * 查看个人资料
	 */
	public Info findUserInfo(Integer uId);
	
	/*
	 * 编辑个人资料
	 */
	public void updateUserInfo(Info info);
	
	/*
	 * 给新用户创建简历行
	 */
	public void insertUserResume(Integer uId);
	
	/*
	 * 查看简历
	 */
	public Resume findUserResume(Integer uId);
	
	/*
	 * 编辑简历
	 */
	public void updateUserResume(Resume resume);
	
	/*
	 * 根据编号查询个人信息简要
	 */
	public List<InfoOutline> findUserById(List<Integer> uId);
}
