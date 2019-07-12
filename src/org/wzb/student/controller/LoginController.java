package org.wzb.student.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wzb.student.entity.Student;
import org.wzb.student.entity.Teacher;
import org.wzb.student.service.IStudentService;
import org.wzb.student.service.ITeacherService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	IStudentService stuService;
	
	@Autowired
	ITeacherService teaService;
	
	// 登录方法
	@RequestMapping("/login")
	public String login(Student stu, Teacher tea, HttpServletRequest req) {
		Student currentStu = stuService.login(stu);
		Teacher currentTea =teaService.login(tea);
		if (currentStu != null) {
			// 将数据保存到session中
			req.getSession().setAttribute("currentStu", currentStu);
			return "redirect:../student/index";
		}else
		if(currentTea!=null) {
			req.getSession().setAttribute("currentTea", currentTea);
			return "redirect:../teacher/index";
		}
		// 返回登录页面
		return "redirect:/login.jsp";
	}

}
