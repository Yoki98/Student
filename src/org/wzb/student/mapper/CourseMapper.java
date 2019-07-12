package org.wzb.student.mapper;

import java.util.List;

import org.wzb.student.entity.Course;

public interface CourseMapper {
	//��ѯ���пγ�
	public List<Course> queryAll();

	// ɾ���γ�
	public void delete(Course cou);

	// ����γ�
	public void save(Course cou);

	// ��ѯһ���γ�
	public Course queryOne(Course cou);

	// ���¿γ�
	public void update(Course cou);
}
