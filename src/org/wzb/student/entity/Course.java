package org.wzb.student.entity;

public class Course {
	private Long id; //�γ�id
	private String course_name; //�γ�����
	private Long credit; //�γ�ѧ��
	private Long course_hour; //��ʱ 

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Long getCredit() {
		return credit;
	}
	public void setCredit(Long credit) {
		this.credit = credit;
	}
	public Long getCourse_hour() {
		return course_hour;
	}
	public void setCourse_hour(Long course_hour) {
		this.course_hour = course_hour;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course_name=" + course_name + ", credit=" + credit + ", course_hour="
				+ course_hour + "]";
	}
}
