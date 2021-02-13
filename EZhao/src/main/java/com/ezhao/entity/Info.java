package com.ezhao.entity;

/*
 * info_idint(10) NOT NULL
info_namevarchar(100) NOT NULL
info_gendervarchar(10) NULL
info_schoolvarchar(100) NULL
info_cidvarchar(20) NULL
info_professionvarchar(100) NULL
info_phonevarchar(11) NULL
u_namevarchar(100) NOT NULL
u_idint(10) NOT NULL
 */
public class Info {
	
	private Integer infoId;
	
	private String infoName;
	
	private String infoGender;
	
	private String infoSchool;
	
	private String infoCid;
	
	private String infoProfession;
	
	private String  infoPhone;
	
	private String uName;
	
	private Integer uId;
	

	public Info() {
		super();
	}

	public Info(String infoName, String infoGender, String infoSchool, String infoCid, String infoProfession,
			String infoPhone, String uName, Integer uId) {
		super();
		this.infoName = infoName;
		this.infoGender = infoGender;
		this.infoSchool = infoSchool;
		this.infoCid = infoCid;
		this.infoProfession = infoProfession;
		this.infoPhone = infoPhone;
		this.uName = uName;
		this.uId = uId;
	}

	
	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName;
	}

	public String getInfoGender() {
		return infoGender;
	}

	public void setInfoGender(String infoGender) {
		this.infoGender = infoGender;
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


	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
	
	public String getInfoCid() {
		return infoCid;
	}

	public void setInfoCid(String infoCid) {
		this.infoCid = infoCid;
	}

	public String getInfoPhone() {
		return infoPhone;
	}

	public void setInfoPhone(String infoPhone) {
		this.infoPhone = infoPhone;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	@Override
	public String toString() {
		return "Info [infoId=" + infoId + ", infoName=" + infoName + ", infoGender=" + infoGender + ", infoSchool="
				+ infoSchool + ", infoCid=" + infoCid + ", infoProfession=" + infoProfession + ", infoPhone="
				+ infoPhone + ", uName=" + uName + ", uId=" + uId + "]";
	}

	
	
	
	
}
