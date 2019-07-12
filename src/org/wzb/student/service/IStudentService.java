package org.wzb.student.service;

import java.util.List;

import org.wzb.student.entity.Student;

public interface IStudentService {

	//查询所有学生
	public List<Student> queryAll();
	
	//删除学生
	public void delete(Student stuNo);
	
	//保存方法
	public void save(Student stu);
	
	//查询一个学生
	public Student queryOne(Student stu);
	
	//更新方法
	public void update(Student stu);
	
	//登录方法
	public Student login(Student stu); 
}
