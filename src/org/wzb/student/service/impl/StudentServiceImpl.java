package org.wzb.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzb.student.entity.Student;
import org.wzb.student.mapper.StudentMapper;
import org.wzb.student.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentMapper mapper;
	
	@Override
	public List<Student> queryAll() {
		
		return mapper.queryAll();
	}

	@Override
	public void delete(Student stuNo) {
		
		mapper.delete(stuNo);
	}

	@Override
	public void save(Student stu) {
		
		mapper.save(stu);
	}

	@Override
	public Student queryOne(Student stu) {
		
		return mapper.queryOne(stu);
	}

	@Override
	public void update(Student stu) {
		
		mapper.update(stu);
	}

	@Override
	public Student login(Student stu) {
		
		return mapper.login(stu);
	}

}
