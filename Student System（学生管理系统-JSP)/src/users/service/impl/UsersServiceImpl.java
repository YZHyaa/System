package users.service.impl;

import users.dao.IUsersDao;
import users.dao.impl.UsersDaoImpl;
import users.entity.Users;
import users.service.IUsersService;

public class UsersServiceImpl implements IUsersService{
	IUsersDao usersDao = new UsersDaoImpl();
	
	public Users queryUsers(int uid) {
		if(usersDao.isExist(uid)) {
			return usersDao.queryUsers(uid);
		}
		return null;
	}

	public boolean addUsers(Users users) {
		if (usersDao.isExist(users.getUid())) {
			return false;
		}
		return usersDao.addUsers(users);
	}

}
