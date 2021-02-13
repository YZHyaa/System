package com.ezhao.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.entity.Info;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.NoteOutline;
import com.ezhao.mapper.LoveMapper;
import com.ezhao.mapper.NoteMapper;
import com.ezhao.mapper.UserMapper;
import com.ezhao.service.user.UserService_1;

@Service
public class UserServiceImpl_1 implements UserService_1{

	@Autowired 
	UserMapper userMapper;
	@Autowired 
	LoveMapper loveMapper;
	@Autowired
	NoteMapper noteMapper;
	
	public Map<String, Integer> infoCount(Integer uId) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("followCount",loveMapper.findFollowCount(uId));
		map.put("fansCount",loveMapper.findFansCount(uId));
		map.put("collectionCount",loveMapper.findCollectionCount(uId));
		return map;
	}

	public Info checkInfo(Integer uId) {
		return userMapper.findUserInfo(uId);
	}

	public void editInfo(Info info) {
		userMapper.updateUserInfo(info);
	}

	public List<InfoOutline> followList(Integer uId) {
		List<Integer> list = new ArrayList<Integer>(); 
		list = loveMapper.findFollowList(uId);
		return userMapper.findUserById(list);
	}

	public List<InfoOutline> fansList(Integer uId) {
		List<Integer> list = new ArrayList<Integer>();
		list = loveMapper.findFansList(uId);
		return userMapper.findUserById(list);
	}

	public List<NoteOutline> collectList(Integer uId) {
		List<Integer> list = new ArrayList<Integer>();
		list = loveMapper.findCollectionList(uId);
		return noteMapper.findNoteListById(list);
	}

}
