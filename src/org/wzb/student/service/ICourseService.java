package org.wzb.student.service;

import java.util.List;

import org.wzb.student.entity.Course;

public interface ICourseService {
	//��ѯ���пγ�
	public List<Course> queryAll();
	
	//ɾ���γ�
	public void delete(Course cou);

	// ����γ�
	public void save(Course cou);

	// ��ѯһ���γ�
	public Course queryOne(Course cou);

	// ���¿γ�
	public void update(Course cou);
}
