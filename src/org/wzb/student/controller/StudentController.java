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
import org.wzb.student.entity.Student;
import org.wzb.student.service.IClassesService;
import org.wzb.student.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//ע��IStudentService
	@Autowired
	private IStudentService stuService;
	
	//ע��IClassesService
	@Autowired
	private IClassesService clsService;
	
	//ֱ������ҳ�г�����ѧ����Ϣ
	@RequestMapping("/index")
	public String student_list(Model model) {
		//����service���queryAll��������ѯ����
		List<Student> lists = stuService.queryAll();
		model.addAttribute("students",lists);
		
		// ��ת��views/student/student_list.jsp
		return "student/student_list";
	}

	//����service���ɾ��������ɾ������
	@RequestMapping("/delete")
	public String delete(Student stuNo) {
		//����service���delete������ɾ������
		stuService.delete(stuNo);
		// �ض���
		return "redirect:index";
	}
	
	//����ѧ������
	@RequestMapping("/add")
	public String add(Model model) {
		//��ѯ���а༶
		model.addAttribute("classes",clsService.queryAll());
		return "student/student_input";
	}
	
	//��������
	@RequestMapping("/save")
	public String save(Student stu,MultipartFile imgFile,HttpServletRequest req,Model model) throws FileNotFoundException, IOException {
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
			stu.setImgUrl("/ssm_student/uploadFile/"+newFilename);
		}
		if(stu != null && stu.getId() != null && !"".equals(stu.getId())) {
			stuService.update(stu);
		}else {
			//�����ݱ��浽���ݿ�����
			stuService.save(stu);	
		}
		return "redirect:index";
	}
	
	//�޸����ݷ���--��ת����--���޸ĺ������չʾ��ҳ��
	@RequestMapping("/edit")
	public String edit(Student stu,Model model) {
		
		//����stu�����id ��ѯ���� �ŵ�ҳ������л��Բ���
		Student stu1=stuService.queryOne(stu);
		//��ѯ���а༶
		model.addAttribute("classes",clsService.queryAll());
		model.addAttribute("stu",stu1);
		return "student/student_input";
	}
	
	//��ѯ������
	@RequestMapping("/chart")
	public String index(Model model) {
		//��ѯ�ı���
		model.addAttribute("chartList",clsService.queryClassesChart());
		return "student/chart";
	}
	
}
