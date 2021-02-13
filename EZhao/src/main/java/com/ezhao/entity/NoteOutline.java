package com.ezhao.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NoteOutline {
	
	private Integer noteId;
	
	private String noteTitle;
	
	private Integer labId;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date noteDate;
	

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

	public Integer getLabId() {
		return labId;
	}

	
	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public Date getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	@Override
	public String toString() {
		return "NoteOutline [noteId=" + noteId + ", noteTitle=" + noteTitle + ", labId=" + labId + ", noteDate="
				+ noteDate + "]";
	}

}
