package student.service;

import java.util.List;

import student.entity.Student;

public interface IStudentService {
	/*
	 * 增加学生（查询是否存在+增加）
	 */
	public boolean addStudent (Student student) ;
	/*
	 * 删除学生（是否存在+删除）
	 */
	public boolean deleteStudentBysno(int sno);
	/*
	 * 修改学生（是否存在+修改）
	 */
	public boolean updateStudentBysno(int sno,Student student);
	/*
	 * 查询一个学生(直接调用
	 */
	public Student queryStudentBysno(int sno);
	/*
	 * 查询全部学生（直接调用
	 */
	public List<Student> queryAllStudents();
}
