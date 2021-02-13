package com.ezhao.service.user;

import java.util.List;

import com.ezhao.entity.NoteOutline;
import com.ezhao.entity.Resume;

public interface UserService_2 {
	/*
	 * ��������id��ѯ�����б�
	 */
	public List<NoteOutline> getNoteById(Integer authorId);
	
	/*
	 * �����ʷ�б�->���ݿ������
	 */
	public List<NoteOutline> getHistory(List<Integer> noteId);
	
	/*
	 * �鿴����
	 */
	public Resume checkResume(Integer uId);
		
	/*
	 * �༭����
	 */
	public void editResume(Resume resume);
	
}
