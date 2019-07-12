package org.wzb.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzb.student.entity.Classes;
import org.wzb.student.entity.ClassesChart;
import org.wzb.student.mapper.ClassesMapper;
import org.wzb.student.service.IClassesService;

@Service
public class ClassesServiceImpl implements IClassesService {

	@Autowired
	ClassesMapper mapper;
	
	@Override
	public List<Classes> queryAll() {
		
		return mapper.queryAll();
	}

	@Override
	public List<ClassesChart> queryClassesChart() {
		
		return mapper.queryClassesChart();
	}

}
