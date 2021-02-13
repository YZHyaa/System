package users.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import users.dao.IUsersDao;
import users.entity.Users;
import util.DBUtil;

public class UsersDaoImpl implements IUsersDao {

	public boolean isExist(int uid) {
		return queryUsers(uid) == null ? false : true;
	}

	public Users queryUsers(int uid) {
		Users users = null;
		String sql = "select * from users where uid = ?";
		Object[] params = {uid};
		ResultSet rs = null;
		
		try {
			rs = DBUtil.query(sql, params);
			if(rs.next()) {
				users = new Users(rs.getInt("uid"),rs.getInt("upwd"), rs.getString("uname"));
			}
		return users;	
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(DBUtil.con, DBUtil.pst, rs);
		}
	}

	public boolean addUsers(Users users) {
		String sql = "insert into users values (?,?,?)";
		Object[] params = {users.getUid(),users.getUpwd(),users.getUname()};
		return DBUtil.update(sql, params);
	}
	
}
