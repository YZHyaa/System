package users.service;

import users.entity.Users;

public interface IUsersService {
	//��ѯ�Ƿ��и��û�������+�û���Ϣ��
	public Users queryUsers(int uid);
	//�����˻�������+��ӣ�
	public boolean addUsers(Users users);
}
