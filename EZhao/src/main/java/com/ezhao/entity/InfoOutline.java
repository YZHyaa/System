package com.ezhao.entity;

public class InfoOutline {
	
	private Integer infoId;
	
	private String infoSchool;
	
	private String infoProfession;
	
	private String uName;

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getInfoSchool() {
		return infoSchool;
	}

	public void setInfoSchool(String infoSchool) {
		this.infoSchool = infoSchool;
	}

	public String getInfoProfession() {
		return infoProfession;
	}

	public void setInfoProfession(String infoProfession) {
		this.infoProfession = infoProfession;
	}
	
	@Override
	public String toString() {
		return "InfoOutline [infoId=" + infoId + ", infoSchool=" + infoSchool + ", infoProfession=" + infoProfession
				+ ", uName=" + uName + "]";
	}
}
