package org.wzb.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wzb.student.entity.Course;
import org.wzb.student.service.ICourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ICourseService couService;
	
	//�г����пγ���Ϣ
	@RequestMapping("/index")
	public String course_list(Model model) {
		//����service���queryAll��������ѯ����
		List<Course> lists = couService.queryAll();
		model.addAttribute("course",lists);
		
		// ��ת��views/course/course_list.jsp
		return "course/course_list";
	}
	
	//����service���ɾ��������ɾ������
	@RequestMapping("/delete")
	public String delete(Course cou) {
		// ����service���delete������ɾ������
		couService.delete(cou);
		// �ض���
		return "redirect:index";
	}

	// �����γ̷���
	@RequestMapping("/add")
	public String add(Model model) {
		// ��ѯ���а༶
		model.addAttribute("course", couService.queryAll());
		return "course/course_input";
	}

	// ��������
	@RequestMapping("/save")
	public String save(Course cou) {
		
		if (cou != null && cou.getId() != null && !"".equals(cou.getId())) {
			couService.update(cou);
		} else {
			// �����ݱ��浽���ݿ�����
			couService.save(cou);
		}
		return "redirect:index";
	}

	// �޸����ݷ���--��ת����--���޸ĺ������չʾ��ҳ��
	@RequestMapping("/edit")
	public String edit(Course cou, Model model) {

		// ����cou�����id ��ѯ���� �ŵ�ҳ������л��Բ���
		Course cou1 = couService.queryOne(cou);
		// ��ѯ���а༶
		model.addAttribute("course", couService.queryAll());
		model.addAttribute("cou", cou1);
		return "course/course_input";
	}
}
