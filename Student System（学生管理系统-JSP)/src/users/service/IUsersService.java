package users.service;

import users.entity.Users;

public interface IUsersService {
	//查询是否有该用户（存在+用户信息）
	public Users queryUsers(int uid);
	//增加账户（存在+添加）
	public boolean addUsers(Users users);
}
