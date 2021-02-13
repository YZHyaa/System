package com.ezhao.service.love;

import com.ezhao.entity.Collection;
import com.ezhao.entity.Follow;

public interface LoveService {
	
	/*
	 * 关注某人
	 */
	public void addFollow(Follow follow);
	
	/*
	 * 取消关注
	 */
	public void cancelFollow(Follow follow);
	
	/*
	 * 添加收藏
	 */
	public void addCollection(Collection collection);
	
	/*
	 * 取消收藏
	 */
	public void cancelCollection(Collection collection);
	
}
