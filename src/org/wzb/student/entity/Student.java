package org.wzb.student.entity;

public class Student {
	
	private Long id; //ѧ��id
	private String name; //ѧ������
	private String pwd; //ѧ������
	private String stunum; //ѧ��ѧ��
	private String imgUrl; //ѧ��ͷ��
	private Classes classes; //ѧ���༶
	private Boolean sex; //ѧ���Ա�

	
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
