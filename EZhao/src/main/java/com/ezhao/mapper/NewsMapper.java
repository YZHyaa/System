package com.ezhao.mapper;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.NewsOutline;

public interface NewsMapper {
	
	/*
	 * 添加新闻
	 */
	public void insertNews(News news);
	
	/*
	 * 根据标签查询新闻列表
	 */
	public List<NewsOutline> findNewsListByLab(Integer labId);
	
	/*
	 * 打开新闻
	 */
	public News findNews(Integer newsId);
	
	/*
	 * 添加评论?
	public void insertComment(Comment comment);
	*/
	
}
