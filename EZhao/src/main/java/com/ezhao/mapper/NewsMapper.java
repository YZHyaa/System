package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.NewsOutline;

public interface NewsMapper {
	
	/*
	 * �������
	 */
	public void insertNews(News news);
	
	/*
	 * ���ݱ�ǩ��ѯ�����б�
	 */
	public List<NewsOutline> findNewsListByLab(Integer labId);
	
	/*
	 * ������
	 */
	public News findNews(Integer newsId);
	
	/*
	 * �������?
	public void insertComment(Comment comment);
	*/
	
}
