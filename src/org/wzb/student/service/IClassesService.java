package org.wzb.student.service;

import java.util.List;
import org.wzb.student.entity.Classes;
import org.wzb.student.entity.ClassesChart;

public interface IClassesService {

	//��ѯ���а༶
	public List<Classes> queryAll();
	
	//��ѯ����
	public List<ClassesChart> queryClassesChart();
}
