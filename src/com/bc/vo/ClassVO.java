package com.bc.vo;

import java.util.Date;

public class ClassVO {

	/*
	 *       ID                                  VARCHAR2(20)       NOT NULL,
      NAME                                VARCHAR2(20)       NOT NULL,
      REGDATE                             DATE       NOT NULL
	 */
	
	private String id;
	private String name;
	private Date regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "ClassVO [id=" + id + ", name=" + name + ", regdate=" + regdate + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getRegdate()=" + getRegdate() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
