package org.wzb.student.entity;

public class ClassesChart {
	
	private Long s_count; //�༶��ѡ����
	private String subject; //�༶����
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
