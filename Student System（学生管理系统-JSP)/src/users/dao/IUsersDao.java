package users.dao;

import users.entity.Users;

public interface IUsersDao {
	//��ѯ�Ƿ���ڸ��˺�
	public boolean isExist (int uid);
	//��ѯ���˺ŵ�����
	public Users queryUsers(int uid);
	//����˺�����
	public boolean addUsers(Users users);
}
