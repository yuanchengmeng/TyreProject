package com.kexun.wm.manage.bean;

/*
 * Emp  员工表
 * **/
public class Emp {
	
	private int id;
	private Dept dept;// 部门表
	private String ename; // 员工名
 	private String sex;// 性别
	private Job job;// 工作
 	public Emp() {
		super();
	}

	public Emp(int id) {
		super();
		this.id = id;
	}

	public Emp(String ename) {
		super();
		this.ename = ename;
	}

	public Emp(int id, Dept dept, String ename, String sex,
			Job job) {
		super();
		this.id = id;
		this.dept = dept;
		this.ename = ename;
 		this.sex = sex;
		this.job = job;
 	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
