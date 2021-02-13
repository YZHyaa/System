package com.ezhao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.entity.Collection;
import com.ezhao.entity.Follow;
import com.ezhao.mapper.LoveMapper;
import com.ezhao.service.love.LoveService;

@Service
public class LoveServiceImpl implements LoveService{
	
	@Autowired 
	LoveMapper loveMapper;

	@Override
	public void addFollow(Follow follow) {
		loveMapper.insertFollow(follow);
	}

	@Override
	public void cancelFollow(Follow follow) {
		loveMapper.deleteFollow(follow);
	}

	@Override
	public void addCollection(Collection collection) {
		loveMapper.insertCollection(collection);
	}

	@Override
	public void cancelCollection(Collection collection) {
		loveMapper.deleteCollection(collection);
	}

}
