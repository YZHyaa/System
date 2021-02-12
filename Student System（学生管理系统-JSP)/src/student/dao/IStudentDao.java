package student.dao;

import java.util.List;
import student.entity.Student;

public interface IStudentDao {
	/*
	 * 判断学生是否存在
	 */
	public boolean isExist(int sno) ;
	/*
	 * 添加学生到数据库
	 */
	public boolean addStudent(Student student) ;
	/*
	 * 根据学号删除学生
	 */
	public boolean deleteStudentBysno(int sno) ;
	/*
	 * 根据学号修改学生
	 */
	public boolean updateStudentBysno(int sno,Student student) ;
	/*
	 * 查询学生基本信息
	 */
	public Student queryStudentByno(int sno) ;
		/*
		 * 查询全部学生
		 */
		public List<Student> queryAllStudents();
}
