package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Collection;
import com.ezhao.entity.Follow;
import com.ezhao.entity.InfoOutline;
import com.ezhao.entity.NoteOutline;
import org.apache.ibatis.annotations.Mapper;

public interface LoveMapper {
	
	/*
	 * ����ղ�
	 */
	public void insertCollection(Collection collection);
	
	/*
	 * ȡ���ղ�
	 */
	public void deleteCollection(Collection collection);
	
	/*
	 * ��ѯ�ղ��б�(���)
	 */
	public List<Integer> findCollectionList(Integer uId);
	
	/*
	 * ��ѯ�ղ�����
	 */
	public Integer findCollectionCount(Integer uId);
	
	/*
	 * ��ӹ�ע
	 */
	public void insertFollow(Follow follow);
	
	/*
	 * ȡ����ע
	 */
	public void deleteFollow(Follow follow);
	
	/*
	 * ��ѯ��ע�б�(��ţ�
	 */
	public List<Integer> findFollowList(Integer fansId);
	
	/*
	 * ��ѯ��ע��
	 */
	public Integer findFollowCount(Integer fansId);
	
	/*
	 * �鿴��˿�б�(���)
	 */
	public List<Integer> findFansList(Integer uId);
	
	/*
	 * �鿴��˿��
	 */
	public Integer findFansCount(Integer uId);
	
}
