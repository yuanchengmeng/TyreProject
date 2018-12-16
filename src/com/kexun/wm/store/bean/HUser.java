package com.kexun.wm.store.bean;

public class HUser {
	private int id;
	private String name;
	private String password;

	public HUser() {
		super();
	}

	public HUser(String name) {
		super();
		this.name = name;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
