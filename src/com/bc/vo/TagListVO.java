package com.bc.vo;

public class TagListVO {

	/*
	 * ID                                  VARCHAR2(20)       NOT NULL,
      QUESTION_ID                         VARCHAR2(20)       NOT NULL,
      TAG_ID                              VARCHAR2(20)       NOT NULL
	 */
	private String id;
	private String question_id;
	private String tag_id;
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
	public String getTag_id() {
		return tag_id;
	}
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	@Override
	public String toString() {
		return "TagListVO [id=" + id + ", question_id=" + question_id + ", tag_id=" + tag_id + ", getId()=" + getId()
				+ ", getQuestion_id()=" + getQuestion_id() + ", getTag_id()=" + getTag_id() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
