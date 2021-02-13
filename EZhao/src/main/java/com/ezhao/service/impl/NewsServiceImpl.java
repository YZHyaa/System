package com.ezhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezhao.entity.Comment;
import com.ezhao.entity.News;
import com.ezhao.entity.NewsOutline;
import com.ezhao.mapper.NewsMapper;
import com.ezhao.service.news.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	NewsMapper newsMapper;

	@Override
	public List<NewsOutline> getNewsListByLab(Integer labId) {
		return newsMapper.findNewsListByLab(labId);
	}

	@Override
	public News checkNews(Integer newsId) {
		return newsMapper.findNews(newsId);
	}

	@Override
	public void addNews(News news) {
		newsMapper.insertNews(news);
	}

	/*
	@Override
	public void commentTo(Comment comment) {
		// TODO 自动生成的方法存根
		
	}
	*/
}
