package com.ezhao.service.note;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;

public interface NoteService {
	
	/*
	 * 发帖
	 */
	public void post(Note note);
	
	/*
	 * 评论
	 */
	public void commentTo(Comment comment);	
	
	/*
	 * 获取全部帖子列表（分页）
	 */
	public List<NoteOutline> getAllNotes();
	

	/*
	 * 根据标签查询帖子列表
	 */
	public List<NoteOutline> getNoteByLabel(Integer labId);
	
	/*
	 * 根据标题进行搜索帖子列表
	 */
	public List<NoteOutline> getNoteByTitle(String noteTitle);
	
	/*
	 *打开帖子 
	 */
	public Note checkNote(Integer noteId);
	
	/*
	 * 删除帖子
	 */
	public void deleteNote(Integer noteId);
	
}
