package org.wzb.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzb.student.entity.Teacher;
import org.wzb.student.mapper.TeacherMapper;
import org.wzb.student.service.ITeacherService;

@Service
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	TeacherMapper mapper;
	
	@Override
	public List<Teacher> queryAll() {
		
		return mapper.queryAll();
	}

	@Override
	public void delete(Teacher tea) {
		
		mapper.delete(tea);
	}

	@Override
	public void save(Teacher tea) {
		
		mapper.save(tea);
	}

	@Override
	public Teacher queryOne(Teacher tea) {
		// TODO Auto-generated method stub
		return mapper.queryOne(tea);
	}

	@Override
	public void update(Teacher tea) {
		
		mapper.update(tea);
	}

	@Override
	public Teacher login(Teacher tea) {

		return mapper.login(tea);
	}


}
