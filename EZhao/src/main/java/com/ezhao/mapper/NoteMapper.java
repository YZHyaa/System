package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.Reply;

public interface NoteMapper {
	 
	/*
	 * ����
	 */
	public void insertNote(Note note);
	
	/* 
	 * �������
	 */
	public void insertComment(Comment comment);
	
	/*
	 * ��ӻظ�
	 */
	public void insertReply(Reply reply);
	
	/*
	 * ɾ��
	 */
	public void deleteNote(Integer noteId);
	
	
	/*
	 * ��ѯȫ������
	 */
	public List<NoteOutline> findAllNotelList();
	
	/*
	 * �������ӱ�Ų�ѯ
	 */
	public List<NoteOutline> findNoteListById(List<Integer> noteId);
	
	/*
	 * ��ѯ�û��������б�
	 */
	public List<NoteOutline> findNoteListByUid(Integer authorId);
	
	/*
	 * ���ݱ�ǩ��ѯ�����б�
	 */
	public List<NoteOutline> findNoteListByLab(Integer labId);
	
	/*
	 * ���ݱ���/�����������б�(ģ����ѯ��
	 */
	public List<NoteOutline> findNoteListByTitle(String noteTitle);
	
	/*
	 * ������(����/�ظ���
	 */
	public Note findNote(Integer noteId);
	
	
}
