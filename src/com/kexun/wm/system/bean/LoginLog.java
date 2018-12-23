package com.kexun.wm.system.bean;


public class LoginLog {

	private int id;
	private String luser;
	private String logintime;
	private String loginip;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LoginLog(){
		super();
	}
	
	public LoginLog(String luser) {
		super();
		this.luser = luser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLuser() {
		return luser;
	}

	public void setLuser(String luser) {
		this.luser = luser;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

}
