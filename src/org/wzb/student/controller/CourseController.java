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
	
	//列出所有课程信息
	@RequestMapping("/index")
	public String course_list(Model model) {
		//调用service层的queryAll方法，查询数据
		List<Course> lists = couService.queryAll();
		model.addAttribute("course",lists);
		
		// 跳转到views/course/course_list.jsp
		return "course/course_list";
	}
	
	//调用service层的删除方法，删除数据
	@RequestMapping("/delete")
	public String delete(Course cou) {
		// 调用service层的delete方法，删除数据
		couService.delete(cou);
		// 重定向
		return "redirect:index";
	}

	// 新增课程方法
	@RequestMapping("/add")
	public String add(Model model) {
		// 查询所有班级
		model.addAttribute("course", couService.queryAll());
		return "course/course_input";
	}

	// 保存数据
	@RequestMapping("/save")
	public String save(Course cou) {
		
		if (cou != null && cou.getId() != null && !"".equals(cou.getId())) {
			couService.update(cou);
		} else {
			// 把数据保存到数据库里面
			couService.save(cou);
		}
		return "redirect:index";
	}

	// 修改数据方法--跳转方法--把修改后的数据展示到页面
	@RequestMapping("/edit")
	public String edit(Course cou, Model model) {

		// 根据cou里面的id 查询数据 放到页面里进行回显操作
		Course cou1 = couService.queryOne(cou);
		// 查询所有班级
		model.addAttribute("course", couService.queryAll());
		model.addAttribute("cou", cou1);
		return "course/course_input";
	}
}
