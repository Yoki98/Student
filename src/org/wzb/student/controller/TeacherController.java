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
	
	//注入IStudentService
	@Autowired
	private ITeacherService teaService;
	
	//注入IClassesService
	@Autowired
	private ICourseService couService;
	
	//直接在首页列出所有老师信息
	@RequestMapping("/index")
	public String teacher_list(Model model) {
		//调用service层的queryAll方法，查询数据
		List<Teacher> lists = teaService.queryAll();
		model.addAttribute("teacher",lists);
		
		// 跳转到views/teacher/teacher_list.jsp
		return "teacher/teacher_list";
	}

	//调用service层的删除方法，删除数据
	@RequestMapping("/delete")
	public String delete(Teacher tea) {
		//调用service层的delete方法，删除数据
		teaService.delete(tea);
		// 重定向
		return "redirect:index";
	}
	
	//新增老师方法
	@RequestMapping("/add")
	public String add(Model model) {
		//查询所有课程
		model.addAttribute("course",couService.queryAll());
		return "teacher/teacher_input";
	}
	
	//保存数据
	@RequestMapping("/save")
	public String save(Teacher tea,MultipartFile imgFile,HttpServletRequest req,Model model) throws FileNotFoundException, IOException {
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
			tea.setImgUrl("/ssm_student/uploadFile/"+newFilename);
		}
		if(tea != null && tea.getId() != null && !"".equals(tea.getId())) {
			teaService.update(tea);
		}else {
			//把数据保存到数据库里面
			teaService.save(tea);	
		}
		return "redirect:index";
	}
	
	//修改数据方法--跳转方法--把修改后的数据展示到页面
	@RequestMapping("/edit")
	public String edit(Teacher tea,Model model) {
		
		//根据tea里面的id 查询数据 放到页面里进行回显操作
		Teacher tea1=teaService.queryOne(tea);
		//查询所有课程
		model.addAttribute("course",couService.queryAll());
		model.addAttribute("tea",tea1);
		return "teacher/teacher_input";
	}
	
}
