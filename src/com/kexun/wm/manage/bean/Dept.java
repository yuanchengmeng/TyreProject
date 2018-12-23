package com.kexun.wm.manage.bean;

/*
 *Dept   部门表 
 * **/
public class Dept {
	
	private int id;
	private String deptname;//部门名称
 	private String deptleader;//部门领导
	private Emp boss;//分管部门领导
	public Dept(String deptname) {
		super();
		this.deptname = deptname;
	}

	public Dept() {
		super();
	}
	
	public Dept(int id) {
		super();
		this.id = id;
	}
	
	public Dept(int id, String deptname, String deptleader) {
		super();
		this.id = id;
		this.deptname = deptname;
 		this.deptleader = deptleader;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDeptname() {
		return deptname;
	}
	
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	public String getDeptleader() {
		return deptleader;
	}
	
	public void setDeptleader(String deptleader) {
		this.deptleader = deptleader;
	}

	public Emp getBoss() {
		return boss;
	}

	public void setBoss(Emp boss) {
		this.boss = boss;
	}

}
