package student.service;

import java.util.List;

import student.entity.Student;

public interface IStudentService {
	/*
	 * ����ѧ������ѯ�Ƿ����+���ӣ�
	 */
	public boolean addStudent (Student student) ;
	/*
	 * ɾ��ѧ�����Ƿ����+ɾ����
	 */
	public boolean deleteStudentBysno(int sno);
	/*
	 * �޸�ѧ�����Ƿ����+�޸ģ�
	 */
	public boolean updateStudentBysno(int sno,Student student);
	/*
	 * ��ѯһ��ѧ��(ֱ�ӵ���
	 */
	public Student queryStudentBysno(int sno);
	/*
	 * ��ѯȫ��ѧ����ֱ�ӵ���
	 */
	public List<Student> queryAllStudents();
}
