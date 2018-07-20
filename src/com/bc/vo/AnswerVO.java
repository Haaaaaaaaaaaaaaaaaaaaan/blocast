package com.bc.vo;

import java.util.Date;

public class AnswerVO {
/*
 *  ID                                  VARCHAR2(20)       NOT NULL,
      REGDATE                             DATE       NOT NULL,
      AUTHOR                              VARCHAR2(20)       NOT NULL,
      QUESTION_ID                         VARCHAR2(20)       NOT NULL,
      CONTENT                             CLOB       NOT NULL,
      THUMPSUP                            NUMBER(10)       DEFAULT 0       NOT NULL,
      IMGNAME1                            VARCHAR2(20)       NULL ,
      IMGNAME2                            VARCHAR2(20)       NULL ,
      IMGNAME3                            VARCHAR2(20)       NULL 
 */
	private String id;
	private Date regdate;
	private String author;
	private String question_id;
	private String content;
	private int thumbsup;
	private String imgname1;
	private String imgname2;
	private String imgname3;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getThumbsup() {
		return thumbsup;
	}
	public void setThumbsup(int thumbsup) {
		this.thumbsup = thumbsup;
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
		return "AnswerVO [id=" + id + ", regdate=" + regdate + ", author=" + author + ", question_id=" + question_id
				+ ", content=" + content + ", thumbsup=" + thumbsup + ", imgname1=" + imgname1 + ", imgname2="
				+ imgname2 + ", imgname3=" + imgname3 + ", getId()=" + getId() + ", getRegdate()=" + getRegdate()
				+ ", getAuthor()=" + getAuthor() + ", getQuestion_id()=" + getQuestion_id() + ", getContent()="
				+ getContent() + ", getThumbsup()=" + getThumbsup() + ", getImgname1()=" + getImgname1()
				+ ", getImgname2()=" + getImgname2() + ", getImgname3()=" + getImgname3() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
