package com.bc.vo;

public class FilesVO {

/*
 *       ID                                  VARCHAR2(20)       NOT NULL,
      FOLDER_ID                           VARCHAR2(20)       NOT NULL,
      NAME                                VARCHAR2(20)       NOT NULL
 * 
 */
	
	private String id;
	private String folder_id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFolder_id() {
		return folder_id;
	}
	public void setFolder_id(String folder_id) {
		this.folder_id = folder_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "FilesVO [id=" + id + ", folder_id=" + folder_id + ", name=" + name + ", getId()=" + getId()
				+ ", getFolder_id()=" + getFolder_id() + ", getName()=" + getName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
