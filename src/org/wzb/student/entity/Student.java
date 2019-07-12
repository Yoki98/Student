package org.wzb.student.entity;

public class Student {
	
	private Long id; //学生id
	private String name; //学生姓名
	private String pwd; //学生密码
	private String stunum; //学生学号
	private String imgUrl; //学生头像
	private Classes classes; //学生班级
	private Boolean sex; //学生性别

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getSex() {
		return sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", pwd=" + pwd + ", stunum=" + stunum + ", imgUrl=" + imgUrl
				+ ", classes=" + classes + ", sex=" + sex + "]";
	}
}
