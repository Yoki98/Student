package org.wzb.student.service;

import java.util.List;

import org.wzb.student.entity.Teacher;

public interface ITeacherService {

	//查询所有老师学生
	public List<Teacher> queryAll();
			
	//删除老师
	public void delete(Teacher tea);
			
	//保存方法
	public void save(Teacher tea);
			
	//查询一个老师
	public Teacher queryOne(Teacher tea);
			
	//更新方法
	public void update(Teacher tea);
			
	//登录方法
	public Teacher login(Teacher tea);
}
