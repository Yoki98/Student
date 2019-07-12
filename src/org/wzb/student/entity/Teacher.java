package org.wzb.student.entity;

public class Teacher {
	private Long id; //老师id
	private String name; //老师姓名
	private String pwd; //老师密码
	private String teanum; //老师工号
	private String imgUrl; //老师头像
	private Course course; //老师所教课程
	private Boolean sex; //老师性别
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getTeanum() {
		return teanum;
	}
	public void setTeanum(String teanum) {
		this.teanum = teanum;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", pwd=" + pwd + ", teanum=" + teanum + ", imgUrl=" + imgUrl
				+ ", course=" + course + ", sex=" + sex + "]";
	}

}
