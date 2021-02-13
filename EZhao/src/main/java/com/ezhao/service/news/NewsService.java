package com.ezhao.service.news;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.NewsOutline;

public interface NewsService {
	
	/*
	 * ���ݱ�ǩ��ѯ�����б�
	 */
	public List<NewsOutline> getNewsListByLab(Integer labId);
	
	/*
	 * ������
	 */
	public News checkNews(Integer newsId);
	
	/*
	 * �������
	 */
	public void addNews(News news);
	
	/*
	 * �������?
	public void commentTo(Comment comment);
	*/
}
