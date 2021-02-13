package com.ezhao.service.user;

import java.util.List;
import java.util.Map;

import com.ezhao.entity.Info;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.NoteOutline;

public interface UserService_1 {

	/*
	 * ��ȡҳ�����ݣ���ע+��˿+�ղأ�
	 */
	public Map<String, Integer> infoCount(Integer uId);
	
	/*
	 * �鿴����
	 */
	public Info checkInfo(Integer uId);
		
	
	/*
	 * �༭����
	 */
	public void editInfo(Info info) ;
	
	/*
	 * ��ע�б�(�û�Id->��Ӧ��Ҫ)
	 */
	public List<InfoOutline> followList(Integer fansId);
	
	/*
	 * ��˿�б�(�û�Id->��Ӧ��Ҫ)
	 */
	public List<InfoOutline> fansList(Integer uId);
	
	/*
	 * �ղ��б�(����ղ�id->��Ӧ�����ӣ�
	 */
	public List<NoteOutline> collectList(Integer uId);
	
}
