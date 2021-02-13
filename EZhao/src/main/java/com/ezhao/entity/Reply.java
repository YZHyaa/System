package com.ezhao.entity;

import java.util.Date;

/*
 * rep_idint(10) NOT NULL
rep_contentvarchar(1000) NULL
rep_datedatetime NULL
author_namevarchar(100) NULL
to_com_idint(10) NULL
 */
public class Reply {
	

	private Integer repId;

	private String repContent;
	
	private Date repDate;
	
	private String authorName;
	
	private Integer toComId;


	public Reply(String repContent, Date repDate, String authorName, Integer toComId) {
		super();
		this.repContent = repContent;
		this.repDate = repDate;
		this.authorName = authorName;
		this.toComId = toComId;
	}

	public Reply() {
		super();
	}
	
	public Integer getRepId() {
		return repId;
	}

	public void setRepId(Integer repId) {
		this.repId = repId;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public Date getRepDate() {
		return repDate;
	}

	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getToComId() {
		return toComId;
	}

	public void setToComId(Integer toComId) {
		this.toComId = toComId;
	}
	
	@Override
	public String toString() {
		return "Reply [repContent=" + repContent + ", repDate=" + repDate + ", authorName=" + authorName + "]";
	}
}
