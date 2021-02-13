package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Collection;
import com.ezhao.entity.Follow;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.NoteOutline;
import org.apache.ibatis.annotations.Mapper;

public interface LoveMapper {
	
	/*
	 * 添加收藏
	 */
	public void insertCollection(Collection collection);
	
	/*
	 * 取消收藏
	 */
	public void deleteCollection(Collection collection);
	
	/*
	 * 查询收藏列表(编号)
	 */
	public List<Integer> findCollectionList(Integer uId);
	
	/*
	 * 查询收藏数量
	 */
	public Integer findCollectionCount(Integer uId);
	
	/*
	 * 添加关注
	 */
	public void insertFollow(Follow follow);
	
	/*
	 * 取消关注
	 */
	public void deleteFollow(Follow follow);
	
	/*
	 * 查询关注列表(编号）
	 */
	public List<Integer> findFollowList(Integer fansId);
	
	/*
	 * 查询关注数
	 */
	public Integer findFollowCount(Integer fansId);
	
	/*
	 * 查看粉丝列表(编号)
	 */
	public List<Integer> findFansList(Integer uId);
	
	/*
	 * 查看粉丝数
	 */
	public Integer findFansCount(Integer uId);
	
}
