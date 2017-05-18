package com.usermgr.entity;

import java.util.Date;

//pojo 传统的
public class User {
	
	private int id;
	private String name;
	private String sex;
	private Date birthday;
	
	public User() {
		
	}

	public User(String name, String sex, Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "编号=" + id + ", 姓名=" + name + ", 性别=" + sex
				+ ", 生日=" + birthday.toLocaleString();
	}
	
	
}
