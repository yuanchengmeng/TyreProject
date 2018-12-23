package com.kexun.wm.system.bean;

public class SysUser {
	private int id;
	private String name;// 用户名
	private String password;// 密码
	private SysRole sysRole;// 用户角色
    private String jobNo;//工号
    private int empID;//k3用户 
    private K3User k3User;
    
	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public SysUser() {
		super();
	}

	public SysUser(String name) {
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

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public K3User getK3User() {
		return k3User;
	}

	public void setK3User(K3User k3User) {
		this.k3User = k3User;
	}

}
