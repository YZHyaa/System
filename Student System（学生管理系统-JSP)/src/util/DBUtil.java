package util;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import jdk.dynalink.beans.StaticClass;

public class DBUtil {
	private static final String DriverClassName = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	public static Connection con = null;
	public static PreparedStatement pst = null;
	
	//连接
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DriverClassName);
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	//平台
	private static PreparedStatement createPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pst = getConnection().prepareStatement(sql);
		if(params != null) {
			for(int i=0;i<params.length;++i) {
				pst.setObject(i+1, params[i]);
			}
		}
		return pst;
	}
	
	//sql - 增删改
	public static boolean update(String sql,Object[] params) {
		try {
			pst = createPreparedStatement(sql, params);
			return pst.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			closeAll(con, pst, null);
		}
	}
	
	//sql - 查询
	public static ResultSet query(String sql,Object[] params) throws SQLException, ClassNotFoundException {
		pst = createPreparedStatement(sql, params);
		return pst.executeQuery();
	}

	//关闭
	public static void closeAll (Connection con,PreparedStatement pst,ResultSet rs) {
			try {
				if(rs != null)
					rs.close();
				if(pst != null)
					pst.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
