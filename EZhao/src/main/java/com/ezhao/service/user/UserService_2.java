package com.ezhao.service.user;

import java.util.List;

import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.Resume;

public interface UserService_2 {
	/*
	 * 根据作者id查询帖子列表
	 */
	public List<NoteOutline> getNoteById(Integer authorId);
	
	/*
	 * 浏览历史列表->数据库查帖子
	 */
	public List<NoteOutline> getHistory(List<Integer> noteId);
	
	/*
	 * 查看简历
	 */
	public Resume checkResume(Integer uId);
		
	/*
	 * 编辑简历
	 */
	public void editResume(Resume resume);
	
}
