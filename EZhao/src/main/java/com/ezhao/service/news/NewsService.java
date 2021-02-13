package com.ezhao.service.news;

import java.util.List;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.NewsOutline;

public interface NewsService {
	
	/*
	 * 根据标签查询新闻列表
	 */
	public List<NewsOutline> getNewsListByLab(Integer labId);
	
	/*
	 * 打开新闻
	 */
	public News checkNews(Integer newsId);
	
	/*
	 * 添加新闻
	 */
	public void addNews(News news);
	
	/*
	 * 添加评论?
	public void commentTo(Comment comment);
	*/
}
