package com.ezhao.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * news_idint(11) NOT NULL
news_contentvarchar(10000) NULL
news_titlevarchar(100) NULL
news_datedatetime NULL
author_namevarchar(100) NULL
news_schoolvarchar(100) NULL
lab_idint(11) NULL
pic_urlvarchar(100) NULL
 */
public class News {

	private Integer newsId;
	
	private String newsContent;
	
	private String newsTitle;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date newsDate;
	
	private String authorName;
	
	private String newsSchool;
	
	private Integer labId;
	
	private String picUrl;

	//查出新闻下的评论
	//private List<Comment> comments;

			
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getNewsSchool() {
		return newsSchool;
	}

	public void setNewsSchool(String newsSchool) {
		this.newsSchool = newsSchool;
	}

	/*
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	*/
	
	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}


	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	@Override
	public String toString() {
		return "News [newsContent=" + newsContent + ", newsTitle=" + newsTitle + ", newsDate=" + newsDate
				+ ", authorName=" + authorName + ", newsSchool=" + newsSchool + ", labId=" + labId + ", picUrl="
				+ picUrl + "]";
	}

}
