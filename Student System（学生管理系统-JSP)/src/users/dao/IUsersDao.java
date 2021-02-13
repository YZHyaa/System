package users.dao;

import users.entity.Users;

public interface IUsersDao {
	//查询是否存在该账号
	public boolean isExist (int uid);
	//查询该账号的密码
	public Users queryUsers(int uid);
	//添加账号密码
	public boolean addUsers(Users users);
}
