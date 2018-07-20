package com.bc.vo;

import java.util.Date;

public class UsersVO {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String email;
	private Date regdate;
	private String admin;
	
	public UsersVO() {
	}

	public UsersVO(String id, String pwd, String name, String gender, String email, Date regdate, String admin) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.regdate = regdate;
		this.admin = admin;
	}
	
	public UsersVO(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", email=" + email
				+ ", regdate=" + regdate + ", admin=" + admin + "]";
	}
	
}
