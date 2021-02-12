package users.entity;

public class Users {
	private int uid;
	private int upwd;
	private String  uname;
	
	public Users(int uid, int upwd, String uname) {
		super();
		this.uid = uid;
		this.upwd = upwd;
		this.uname = uname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUpwd() {
		return upwd;
	}

	public void setUpwd(int upwd) {
		this.upwd = upwd;
	}
	
	public String toString() {
		return "Users [uid=" + uid + ", upwd=" + upwd + ", uname=" + uname + "]";
	}

}
