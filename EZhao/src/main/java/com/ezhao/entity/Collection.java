package com.ezhao.entity;

/*
 * col_idint(11) NOT NULL
note_idint(11) NULL
u_idint(11) NULL
 */
public class Collection {
	
	private Integer colId;
	
	private Integer noteId;
	
	private Integer uId;


	public Collection() {
		super();
	}

	public Collection(Integer noteId, Integer uId) {
		super();
		this.noteId = noteId;
		this.uId = uId;
	}

	public Integer getColId() {
		return colId;
	}

	public void setColId(Integer colId) {
		this.colId = colId;
	}

	public Integer getNoteId() {
		return noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	
}
