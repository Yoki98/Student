package org.wzb.student.mapper;

import java.util.List;

import org.wzb.student.entity.Classes;
import org.wzb.student.entity.ClassesChart;

public interface ClassesMapper {

	//��ѯ���а༶
	public List<Classes> queryAll();
	
	//��ѯ����
	public List<ClassesChart> queryClassesChart();
}
