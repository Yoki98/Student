package org.wzb.student.mapper;

import java.util.List;
import org.wzb.student.entity.Teacher;

public interface TeacherMapper {

	//��ѯ������ʦѧ��
	public List<Teacher> queryAll();
		
	//ɾ����ʦ
	public void delete(Teacher tea);
		
	//���淽��
	public void save(Teacher tea);
		
	//��ѯһ����ʦ
	public Teacher queryOne(Teacher tea);
		
	//���·���
	public void update(Teacher tea);
		
	//��¼����
	public Teacher login(Teacher tea);
}
