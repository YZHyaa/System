package com.ezhao.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * com_idint(11) NOT NULL
com_contentvarchar(1000) NULL
com_datedatetime NULL
to_idint(11) NULL
author_namevarchar(100) NULL
 */
public class Comment {
	
	private Integer comId;
	
	private String comContent;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date comDate;
	
	//要评论的帖子id
	private Integer toNoteId;
	
	private String authorName;
	
	
	//查出评论的回复
	private List<Reply> replies;


	public Comment() {
		super();
	}

	public Comment(String comContent, Date comDate, Integer toNoteId, String authorName) {
		super();
		this.comContent = comContent;
		this.comDate = comDate;
		this.toNoteId = toNoteId;
		this.authorName = authorName;
	}


	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public Integer getToNoteId() {
		return toNoteId;
	}

	public void setToNoteId(Integer toNoteId) {
		this.toNoteId = toNoteId;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	

	@Override
	public String toString() {
		return "Comment [comContent=" + comContent + ", comDate=" + comDate + ", authorName=" + authorName
				+ ", replies=" + replies + "]";
	}

}
