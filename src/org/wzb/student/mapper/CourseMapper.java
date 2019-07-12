package org.wzb.student.mapper;

import java.util.List;

import org.wzb.student.entity.Course;

public interface CourseMapper {
	//查询所有课程
	public List<Course> queryAll();

	// 删除课程
	public void delete(Course cou);

	// 保存课程
	public void save(Course cou);

	// 查询一个课程
	public Course queryOne(Course cou);

	// 更新课程
	public void update(Course cou);
}
