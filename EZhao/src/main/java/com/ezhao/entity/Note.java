package com.ezhao.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * note_idint(11) NOT NULL
note_titlevarchar(100) NULL
note_contenttext NULL
lab_idint(100) NULL
note_datedatetime NULL
author_idint(11) NULL
author_namevarchar(100) NULL
pic_urlvarchar(100) NULL
 */
public class Note {
	
	private Integer noteId;
	
	private String noteTitle;
	
	private String noteContent;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date noteDate;
	
	private Integer labId;
	
	private Integer authorId;
	
	private String authorName;
	
	private String picUrl;

	//查出帖子下所带的评论
	private List<Comment> comments;
	

	public Note() {
		super();
	}

	public Note(String noteTitle, String noteContent,Integer labId, Integer authorId,
			String authorName) {
		super();
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.labId = labId;
		this.authorId = authorId;
		this.authorName = authorName;
	}

	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}


	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Note [noteTitle=" + noteTitle + ", noteContent=" + noteContent + ", noteDate=" + noteDate + ", labId="
				+ labId + ", authorName=" + authorName + ", picUrl=" + picUrl + ", comments=" + comments + "]";
	}
	

}
