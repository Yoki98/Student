package org.wzb.student.entity;

public class Course {
	private Long id; //课程id
	private String course_name; //课程名称
	private Long credit; //课程学分
	private Long course_hour; //课时 

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
