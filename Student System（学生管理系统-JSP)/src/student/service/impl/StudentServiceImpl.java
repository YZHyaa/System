package student.service.impl;

import java.util.List;

import student.dao.impl.StudentDaoImpl;
import student.entity.Student;
import student.service.IStudentService;

/*
 * �߼��Ե���ɾ�Ĳ飬��װ
 */
public class StudentServiceImpl implements IStudentService {
	StudentDaoImpl studentDao = new StudentDaoImpl();
	/*
	 * ����ѧ������ѯ�Ƿ����+���ӣ�
	 */
	public boolean addStudent (Student student) {
		if(!studentDao.isExist(student.getSno())) {
			studentDao.addStudent(student);
			return true;
		}else {
			System.out.println("�����Ѵ��ڣ�");
			return false;
		}
	}
	/*
	 * ɾ��ѧ�����Ƿ����+ɾ����
	 */
	public boolean deleteStudentBysno(int sno) {
		if(studentDao.isExist(sno)) {
			return studentDao.deleteStudentBysno(sno);
		}else {
			return false;
		}
	}
	/*
	 * �޸�ѧ�����Ƿ����+�޸ģ�
	 */
	public boolean updateStudentBysno(int sno,Student student) {
		if(studentDao.isExist(sno)) {
			return studentDao.updateStudentBysno(sno, student);
		}
		return false;
	}
	/*
	 * ��ѯһ��ѧ��(ֱ�ӵ���
	 */
	public Student queryStudentBysno(int sno) {
		return studentDao.queryStudentByno(sno);
	}
	/*
	 * ��ѯȫ��ѧ����ֱ�ӵ���
	 */
	public List<Student> queryAllStudents(){
		return studentDao.queryAllStudents();
	}
}
