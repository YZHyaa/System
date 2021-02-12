package student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import student.dao.IStudentDao;
import student.entity.Student;
import student.service.IStudentService;

public class StudentDaoImpl implements IStudentDao {
	
	private final String URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=GMT&useSSL=false";
	private final String USERNAME = "root";
	private final String PASSWORD = "123456";
	
	/*
	 * 判断学生是否存在
	 */
	public boolean isExist(int sno) {
		return queryStudentByno(sno) == null ? false : true;
	}
	/*
	 * 添加学生到数据库
	 */
	public boolean addStudent(Student student) {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "insert into student values(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setObject(1, student.getSno());
			pst.setObject(2, student.getSname());
			pst.setObject(3, student.getSage());
			pst.setObject(4, student.getSaddress());
			int count = pst.executeUpdate();
			if(count > 0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					if(pst != null)
						pst.close();
					if(con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	/*
	 * 根据学号删除学生
	 */
	public boolean deleteStudentBysno(int sno) {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "delete from student where sno =? ";
			pst = con.prepareStatement(sql);
			pst.setObject(1, sno);
			int count = pst.executeUpdate();
			if(count > 0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					if(pst != null)
						pst.close();
					if(con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	/*
	 * 根据学号修改学生
	 */
	public boolean updateStudentBysno(int sno,Student student) {
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "update student set sname = ?,sage = ?,saddress = ? where sno = ?";
			pst = con.prepareStatement(sql);
			pst.setObject(1, student.getSname());
			pst.setObject(2, student.getSage());
			pst.setObject(3, student.getSaddress());
			pst.setObject(4, sno);
			int count = pst.executeUpdate();
			if(count > 0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					if(pst != null)
						pst.close();
					if(con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	/*
	 * 查询学生基本信息
	 */
	public Student queryStudentByno(int sno) {
		
		Student student = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "select * from student where sno =?";
			pst = con.prepareStatement(sql);
			pst.setObject(1, sno);
			rs = pst.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no,name,age,address);
			}
			
			return student;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
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
		/*
		 * 查询全部学生
		 */
		public List<Student> queryAllStudents() {
			List<Student> students = new ArrayList<Student>();
			
			Student student = null;
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				String sql = "select * from student ";
				pst = con.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					int no = rs.getInt("sno");
					String name = rs.getString("sname");
					int age = rs.getInt("sage");
					String address = rs.getString("saddress");
					student = new Student(no,name,age,address);
					students.add(student);
				}
				
				return students;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {
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
}
