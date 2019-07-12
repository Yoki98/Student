package org.wzb.student.service;

import java.util.List;

import org.wzb.student.entity.Student;

public interface IStudentService {

	//��ѯ����ѧ��
	public List<Student> queryAll();
	
	//ɾ��ѧ��
	public void delete(Student stuNo);
	
	//���淽��
	public void save(Student stu);
	
	//��ѯһ��ѧ��
	public Student queryOne(Student stu);
	
	//���·���
	public void update(Student stu);
	
	//��¼����
	public Student login(Student stu); 
}
