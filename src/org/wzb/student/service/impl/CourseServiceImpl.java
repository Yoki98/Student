package org.wzb.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzb.student.entity.Course;
import org.wzb.student.mapper.CourseMapper;
import org.wzb.student.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	CourseMapper mapper;
	
	@Override
	public List<Course> queryAll() {

		return mapper.queryAll();
	}

	@Override
	public void delete(Course cou) {
		
		mapper.delete(cou);
	}

	@Override
	public void save(Course cou) {
		
		mapper.save(cou);
	}

	@Override
	public Course queryOne(Course cou) {
		
		return mapper.queryOne(cou);
	}

	@Override
	public void update(Course cou) {
		
		mapper.update(cou);
	}

}
