package com.ezhao.entity;

/*
 * fol_idint(11) NOT NULL
u_idint(11) NULL
fans_idint(11) NULL
 */
public class Follow {
	
	private Integer folId;
	
	private Integer uId;
	
	private Integer fansId;
	

	public Follow() {
		super();
	}

	public Follow(Integer uId, Integer fansId) {
		super();
		this.uId = uId;
		this.fansId = fansId;
	}

	public Integer getFolId() {
		return folId;
	}

	public void setFolId(Integer folId) {
		this.folId = folId;
	}


	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getFansId() {
		return fansId;
	}

	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}
	
}
