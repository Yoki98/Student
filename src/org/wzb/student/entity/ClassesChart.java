package org.wzb.student.entity;

public class ClassesChart {
	
	private Long s_count; //班级所选人数
	private String subject; //班级名称
	public Long getS_count() {
		return s_count;
	}
	public void setS_count(Long s_count) {
		this.s_count = s_count;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "ClassesChart [s_count=" + s_count + ", subject=" + subject + "]";
	}
	

}
