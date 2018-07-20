package com.bc.vo;

public class FolderVO {

	/*
	 *    ID                                  VARCHAR2(20)       NOT NULL,
      CLASS_ID                            VARCHAR2(20)       NOT NULL,
      NAME                                VARCHAR2(20)       NOT NULL
	 * 
	 */
	
	private String id;
	private String class_id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "FolderVO [id=" + id + ", class_id=" + class_id + ", name=" + name + ", getId()=" + getId()
				+ ", getClass_id()=" + getClass_id() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
