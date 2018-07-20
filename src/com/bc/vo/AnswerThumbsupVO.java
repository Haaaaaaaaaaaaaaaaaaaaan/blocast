package com.bc.vo;

public class AnswerThumbsupVO {

	/*
	 * 
	 * ID                                  VARCHAR2(20)       NOT NULL,
      ANSWER_ID                           VARCHAR2(20)       NOT NULL,
      USER_ID                             VARCHAR2(20)       NOT NULL

	 */
	private String id;
	private String answer_id;
	private String user_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "AnswerThumbsupVO [id=" + id + ", answer_id=" + answer_id + ", user_id=" + user_id + ", getId()="
				+ getId() + ", getAnswer_id()=" + getAnswer_id() + ", getUser_id()=" + getUser_id() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
