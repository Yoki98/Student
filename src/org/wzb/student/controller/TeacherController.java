package org.wzb.student.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.wzb.student.entity.Teacher;
import org.wzb.student.service.ICourseService;
import org.wzb.student.service.ITeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	//ע��IStudentService
	@Autowired
	private ITeacherService teaService;
	
	//ע��IClassesService
	@Autowired
	private ICourseService couService;
	
	//ֱ������ҳ�г�������ʦ��Ϣ
	@RequestMapping("/index")
	public String teacher_list(Model model) {
		//����service���queryAll��������ѯ����
		List<Teacher> lists = teaService.queryAll();
		model.addAttribute("teacher",lists);
		
		// ��ת��views/teacher/teacher_list.jsp
		return "teacher/teacher_list";
	}

	//����service���ɾ��������ɾ������
	@RequestMapping("/delete")
	public String delete(Teacher tea) {
		//����service���delete������ɾ������
		teaService.delete(tea);
		// �ض���
		return "redirect:index";
	}
	
	//������ʦ����
	@RequestMapping("/add")
	public String add(Model model) {
		//��ѯ���пγ�
		model.addAttribute("course",couService.queryAll());
		return "teacher/teacher_input";
	}
	
	//��������
	@RequestMapping("/save")
	public String save(Teacher tea,MultipartFile imgFile,HttpServletRequest req,Model model) throws FileNotFoundException, IOException {
		//����ϴ�����
		if(imgFile!=null) {
			//��ȡ�ļ�·��
			String path = req.getServletContext().getRealPath("/uploadFile");
			//�ļ�����:UUID����ļ����Ƶĸ�������
			String filename = imgFile.getOriginalFilename();
			String newFilename=UUID.randomUUID().toString()+"."+StringUtils.getFilenameExtension(filename);
			//�ȹ���һ���ļ�����
			File file=new File(path,newFilename);
			//��imgFileд��file��
			IOUtils.copy(imgFile.getInputStream(), new FileOutputStream(file));
			
			//���ͼƬ��ַ
			tea.setImgUrl("/ssm_student/uploadFile/"+newFilename);
		}
		if(tea != null && tea.getId() != null && !"".equals(tea.getId())) {
			teaService.update(tea);
		}else {
			//�����ݱ��浽���ݿ�����
			teaService.save(tea);	
		}
		return "redirect:index";
	}
	
	//�޸����ݷ���--��ת����--���޸ĺ������չʾ��ҳ��
	@RequestMapping("/edit")
	public String edit(Teacher tea,Model model) {
		
		//����tea�����id ��ѯ���� �ŵ�ҳ������л��Բ���
		Teacher tea1=teaService.queryOne(tea);
		//��ѯ���пγ�
		model.addAttribute("course",couService.queryAll());
		model.addAttribute("tea",tea1);
		return "teacher/teacher_input";
	}
	
}
