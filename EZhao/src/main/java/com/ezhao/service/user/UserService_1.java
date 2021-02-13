package com.ezhao.service.user;

import java.util.List;
import java.util.Map;

import com.ezhao.entity.Info;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.NoteOutline;

public interface UserService_1 {

	/*
	 * 获取页面数据（关注+粉丝+收藏）
	 */
	public Map<String, Integer> infoCount(Integer uId);
	
	/*
	 * 查看资料
	 */
	public Info checkInfo(Integer uId);
		
	
	/*
	 * 编辑资料
	 */
	public void editInfo(Info info) ;
	
	/*
	 * 关注列表(用户Id->对应概要)
	 */
	public List<InfoOutline> followList(Integer fansId);
	
	/*
	 * 粉丝列表(用户Id->对应概要)
	 */
	public List<InfoOutline> fansList(Integer uId);
	
	/*
	 * 收藏列表(查出收藏id->对应的帖子）
	 */
	public List<NoteOutline> collectList(Integer uId);
	
}
