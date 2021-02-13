package com.ezhao.entity;

public class NewsOutline {
	
	private Integer newsId;
	
	private String newsTitle;
	
	private String newsSchool;
	
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsSchool() {
		return newsSchool;
	}

	public void setNewsSchool(String newsSchool) {
		this.newsSchool = newsSchool;
	}

	@Override
	public String toString() {
		return "NewsOutline [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsSchool=" + newsSchool + ", picUrl="
				+ picUrl + "]";
	}
	
	

}
