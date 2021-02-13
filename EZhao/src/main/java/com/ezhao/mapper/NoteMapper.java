package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.Reply;

public interface NoteMapper {
	 
	/*
	 * 发帖
	 */
	public void insertNote(Note note);
	
	/* 
	 * 添加评论
	 */
	public void insertComment(Comment comment);
	
	/*
	 * 添加回复
	 */
	public void insertReply(Reply reply);
	
	/*
	 * 删帖
	 */
	public void deleteNote(Integer noteId);
	
	
	/*
	 * 查询全部帖子
	 */
	public List<NoteOutline> findAllNotelList();
	
	/*
	 * 根据帖子编号查询
	 */
	public List<NoteOutline> findNoteListById(List<Integer> noteId);
	
	/*
	 * 查询用户的帖子列表
	 */
	public List<NoteOutline> findNoteListByUid(Integer authorId);
	
	/*
	 * 根据标签查询帖子列表
	 */
	public List<NoteOutline> findNoteListByLab(Integer labId);
	
	/*
	 * 根据标题/内容搜索子列表(模糊查询）
	 */
	public List<NoteOutline> findNoteListByTitle(String noteTitle);
	
	/*
	 * 打开帖子(评论/回复）
	 */
	public Note findNote(Integer noteId);
	
	
}
