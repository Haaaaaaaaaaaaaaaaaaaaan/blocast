package com.bc.vo;

import java.util.Date;

public class QuestionVO {
	
	/*
	 *    ID                                  VARCHAR2(20)       NOT NULL,
      TITLE                               VARCHAR2(20)       NOT NULL,
      AUTHOR                              VARCHAR2(20)       NOT NULL,
      THUMBSUP                            NUMBER(10)       DEFAULT 0       NOT NULL,
      REGDATE                             DATE       NOT NULL,
      CONTENTS                            CLOB       NOT NULL,
      CLASS_ID                            VARCHAR2(20)       NOT NULL,
      STATE                               VARCHAR2(20)       NOT NULL,
      IMGNAME1                            VARCHAR2(20)       NULL ,
      IMGNAME2                            VARCHAR2(20)       NULL ,
      IMGNAME3                            VARCHAR2(20)       NULL 

	 * 
	 */
	
	private String id;
	private String title;
	private String author;
	private int thumbsup;
	private Date regdate;
	private String contents;
	private String  class_id;
	private String state;
	private String imgname1;
	private String imgname2;
	private String imgname3;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getThumbsup() {
		return thumbsup;
	}
	public void setThumbsup(int thumbsup) {
		this.thumbsup = thumbsup;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getImgname1() {
		return imgname1;
	}
	public void setImgname1(String imgname1) {
		this.imgname1 = imgname1;
	}
	public String getImgname2() {
		return imgname2;
	}
	public void setImgname2(String imgname2) {
		this.imgname2 = imgname2;
	}
	public String getImgname3() {
		return imgname3;
	}
	public void setImgname3(String imgname3) {
		this.imgname3 = imgname3;
	}
	@Override
	public String toString() {
		return "QuestionVO [id=" + id + ", title=" + title + ", author=" + author + ", thumbsup=" + thumbsup
				+ ", regdate=" + regdate + ", contents=" + contents + ", class_id=" + class_id + ", state=" + state
				+ ", imgname1=" + imgname1 + ", imgname2=" + imgname2 + ", imgname3=" + imgname3 + ", getId()="
				+ getId() + ", getTitle()=" + getTitle() + ", getAuthor()=" + getAuthor() + ", getThumbsup()="
				+ getThumbsup() + ", getRegdate()=" + getRegdate() + ", getContents()=" + getContents()
				+ ", getClass_id()=" + getClass_id() + ", getState()=" + getState() + ", getImgname1()=" + getImgname1()
				+ ", getImgname2()=" + getImgname2() + ", getImgname3()=" + getImgname3() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
