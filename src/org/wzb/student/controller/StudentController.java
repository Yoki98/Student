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
	
	//注入IStudentService
	@Autowired
	private IStudentService stuService;
	
	//注入IClassesService
	@Autowired
	private IClassesService clsService;
	
	//直接在首页列出所有学生信息
	@RequestMapping("/index")
	public String student_list(Model model) {
		//调用service层的queryAll方法，查询数据
		List<Student> lists = stuService.queryAll();
		model.addAttribute("students",lists);
		
		// 跳转到views/student/student_list.jsp
		return "student/student_list";
	}

	//调用service层的删除方法，删除数据
	@RequestMapping("/delete")
	public String delete(Student stuNo) {
		//调用service层的delete方法，删除数据
		stuService.delete(stuNo);
		// 重定向
		return "redirect:index";
	}
	
	//新增学生方法
	@RequestMapping("/add")
	public String add(Model model) {
		//查询所有班级
		model.addAttribute("classes",clsService.queryAll());
		return "student/student_input";
	}
	
	//保存数据
	@RequestMapping("/save")
	public String save(Student stu,MultipartFile imgFile,HttpServletRequest req,Model model) throws FileNotFoundException, IOException {
		//完成上传功能
		if(imgFile!=null) {
			//获取文件路径
			String path = req.getServletContext().getRealPath("/uploadFile");
			//文件名称:UUID解决文件名称的覆盖问题
			String filename = imgFile.getOriginalFilename();
			String newFilename=UUID.randomUUID().toString()+"."+StringUtils.getFilenameExtension(filename);
			//先构造一个文件出来
			File file=new File(path,newFilename);
			//把imgFile写到file里
			IOUtils.copy(imgFile.getInputStream(), new FileOutputStream(file));
			
			//存放图片地址
			stu.setImgUrl("/ssm_student/uploadFile/"+newFilename);
		}
		if(stu != null && stu.getId() != null && !"".equals(stu.getId())) {
			stuService.update(stu);
		}else {
			//把数据保存到数据库里面
			stuService.save(stu);	
		}
		return "redirect:index";
	}
	
	//修改数据方法--跳转方法--把修改后的数据展示到页面
	@RequestMapping("/edit")
	public String edit(Student stu,Model model) {
		
		//根据stu里面的id 查询数据 放到页面里进行回显操作
		Student stu1=stuService.queryOne(stu);
		//查询所有班级
		model.addAttribute("classes",clsService.queryAll());
		model.addAttribute("stu",stu1);
		return "student/student_input";
	}
	
	//查询报表方法
	@RequestMapping("/chart")
	public String index(Model model) {
		//查询的报表
		model.addAttribute("chartList",clsService.queryClassesChart());
		return "student/chart";
	}
	
}
