package student.dao;

import java.util.List;
import student.entity.Student;

public interface IStudentDao {
	/*
	 * �ж�ѧ���Ƿ����
	 */
	public boolean isExist(int sno) ;
	/*
	 * ���ѧ�������ݿ�
	 */
	public boolean addStudent(Student student) ;
	/*
	 * ����ѧ��ɾ��ѧ��
	 */
	public boolean deleteStudentBysno(int sno) ;
	/*
	 * ����ѧ���޸�ѧ��
	 */
	public boolean updateStudentBysno(int sno,Student student) ;
	/*
	 * ��ѯѧ��������Ϣ
	 */
	public Student queryStudentByno(int sno) ;
		/*
		 * ��ѯȫ��ѧ��
		 */
		public List<Student> queryAllStudents();
}
