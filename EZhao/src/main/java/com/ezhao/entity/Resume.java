package com.ezhao.entity;

/*
 * 
res_idint(11) NOT NULL
res_namevarchar(100) NULL
res_professionvarchar(10) NULL
res_schoolvarchar(100) NULL
res_phonevarchar(11) NULL
res_addressvarchar(100) NULL
res_introducevarchar(10000) NULL
u_idint(11) NULL
 */
public class Resume {

	private Integer resId;
	
	private String resName;
	
	private String resProfession;
	
	private String resSchool;
	
	private String resPhone;
	
	private String resAddress;
	
	private String resIntroduce;
	
	private Integer uId;
	

	public Resume() {
		super();
	}

	public Resume(Integer resId, String resName, String resProfession, String resSchool, String resPhone,
			String resAddress, String resIntroduce, Integer uId) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resProfession = resProfession;
		this.resSchool = resSchool;
		this.resPhone = resPhone;
		this.resAddress = resAddress;
		this.resIntroduce = resIntroduce;
		this.uId = uId;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResProfession() {
		return resProfession;
	}

	public void setResProfession(String resProfession) {
		this.resProfession = resProfession;
	}

	public String getResSchool() {
		return resSchool;
	}

	public void setResSchool(String resSchool) {
		this.resSchool = resSchool;
	}


	public String getResPhone() {
		return resPhone;
	}

	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResIntroduce() {
		return resIntroduce;
	}

	public void setResIntroduce(String resIntroduce) {
		this.resIntroduce = resIntroduce;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
}
