package com.ezhao.service.love;

import com.ezhao.entity.Collection;
import com.ezhao.entity.Follow;

public interface LoveService {
	
	/*
	 * ��עĳ��
	 */
	public void addFollow(Follow follow);
	
	/*
	 * ȡ����ע
	 */
	public void cancelFollow(Follow follow);
	
	/*
	 * ����ղ�
	 */
	public void addCollection(Collection collection);
	
	/*
	 * ȡ���ղ�
	 */
	public void cancelCollection(Collection collection);
	
}
