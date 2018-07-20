package com.bc.vo;

public class QuestionThumbsupVO {
/*
 *ID                                  VARCHAR2(20)       NOT NULL,
      QUESTION_ID                         VARCHAR2(20)       NOT NULL,
      USER_ID                             VARCHAR2(20)       NOT NULL 
 */
	private String id;
	private String question_id;
	private String user_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "QuestionThumbsupVO [id=" + id + ", question_id=" + question_id + ", user_id=" + user_id + ", getId()="
				+ getId() + ", getQuestion_id()=" + getQuestion_id() + ", getUser_id()=" + getUser_id()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
