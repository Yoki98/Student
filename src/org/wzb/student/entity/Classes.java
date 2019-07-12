package org.wzb.student.entity;

public class Classes {

	private Long id; //°à¼¶id
	private String class_name; //°à¼¶Ãû³Æ
	


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	
	@Override
	public String toString() {
		return "Classes [id=" + id + ", class_name=" + class_name + "]";
	}
	
}
