package com.dcits.entity;

public class User extends A {
	private Long id;
	private Long userid;
	private String name;
	private Integer age;
	private Long user2id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getUser2id() {
		return user2id;
	}

	public void setUser2id(Long user2id) {
		this.user2id = user2id;
	}

}
