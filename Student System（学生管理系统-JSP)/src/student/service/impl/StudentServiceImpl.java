package student.service.impl;

import java.util.List;

import student.dao.impl.StudentDaoImpl;
import student.entity.Student;
import student.service.IStudentService;

/*
 * 逻辑性的增删改查，组装
 */
public class StudentServiceImpl implements IStudentService {
	StudentDaoImpl studentDao = new StudentDaoImpl();
	/*
	 * 增加学生（查询是否存在+增加）
	 */
	public boolean addStudent (Student student) {
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("此人已存在！");
			return false;
		}
	}
	/*
	 * 删除学生（是否存在+删除）
	 */
	public boolean deleteStudentBysno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBysno(sno);
		}else {
			return false;
		}
	}
	/*
	 * 修改学生（是否存在+修改）
	 */
	public boolean updateStudentBysno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBysno(sno, student);
		}
		return false;
	}
	/*
	 * 查询一个学生(直接调用
	 */
	public Student queryStudentBysno(int sno) {
		return studentDao.queryStudentByno(sno);
	}
	/*
	 * 查询全部学生（直接调用
	 */
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
}
