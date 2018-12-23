package com.kexun.wm.system.bean;

import java.util.Set;

public class SysMenu {
	private int id;
	private String name;
	private String page_url;
	private Integer parent_menu_id;
	private String flag;
	 private Set<SysRole> sysRoles;
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

	public String getPage_url() {
		return page_url;
	}

	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}

	public Integer getParent_menu_id() {
		return parent_menu_id;
	}

	public void setParent_menu_id(Integer parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Set<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public SysMenu() {
		super();
	}

	public SysMenu(String name) {
		super();
		this.name = name;
	}

}
