package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Info;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.Resume;

public interface UserMapper {
	
	/*
	 * ��ѯ΢���û���id���Ƿ��Ѿ��洢��
	 */
	public Integer findUserId(String uName);

	/*
	 * ���΢���û�
	 */
	public void insertUser(String uName);
	
	/*
	 * �����û�����������
	 */
	public void insertUserInfo(Integer uId);
	
	/*
	 * �鿴��������
	 */
	public Info findUserInfo(Integer uId);
	
	/*
	 * �༭��������
	 */
	public void updateUserInfo(Info info);
	
	/*
	 * �����û�����������
	 */
	public void insertUserResume(Integer uId);
	
	/*
	 * �鿴����
	 */
	public Resume findUserResume(Integer uId);
	
	/*
	 * �༭����
	 */
	public void updateUserResume(Resume resume);
	
	/*
	 * ���ݱ�Ų�ѯ������Ϣ��Ҫ
	 */
	public List<InfoOutline> findUserById(List<Integer> uId);
}
