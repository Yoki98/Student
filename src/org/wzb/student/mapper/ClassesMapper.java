package org.wzb.student.mapper;

import java.util.List;

import org.wzb.student.entity.Classes;
import org.wzb.student.entity.ClassesChart;

public interface ClassesMapper {

	//查询所有班级
	public List<Classes> queryAll();
	
	//查询报表
	public List<ClassesChart> queryClassesChart();
}
