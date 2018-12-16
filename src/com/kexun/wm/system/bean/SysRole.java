package com.kexun.wm.system.bean;

import java.util.Set;

public class SysRole {
	private int id;
	private String name;
 	private String descr;//描述
    private Set<SysMenu> sysMenus;
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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Set<SysMenu> getSysMenus() {
		return sysMenus;
	}

	public void setSysMenus(Set<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}

	public SysRole() {
		super();
	}

	public SysRole(String name) {
		super();
		this.name = name;
	}

}
