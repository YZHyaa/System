package com.ezhao.service.note;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.Note;
import com.ezhao.entity.NoteOutline;

public interface NoteService {
	
	/*
	 * ����
	 */
	public void post(Note note);
	
	/*
	 * ����
	 */
	public void commentTo(Comment comment);	
	
	/*
	 * ��ȡȫ�������б���ҳ��
	 */
	public List<NoteOutline> getAllNotes();
	

	/*
	 * ���ݱ�ǩ��ѯ�����б�
	 */
	public List<NoteOutline> getNoteByLabel(Integer labId);
	
	/*
	 * ���ݱ���������������б�
	 */
	public List<NoteOutline> getNoteByTitle(String noteTitle);
	
	/*
	 *������ 
	 */
	public Note checkNote(Integer noteId);
	
	/*
	 * ɾ������
	 */
	public void deleteNote(Integer noteId);
	
}
