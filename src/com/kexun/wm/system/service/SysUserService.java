package com.kexun.wm.system.service;

import java.util.List;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.SysUser;

public interface SysUserService {
	public SysUser findByJobNo(String name) throws Exception ;
	public SysUser findByName(String name) throws Exception ;
	public SysUser querySysUser(String jobNo, String password) throws Exception;

	// 显示所有符合条件的用户
	public List<SysUser> querySysUserList(SysUser sysUser) throws Exception;

	public void saveSysUser(SysUser sysUser) throws Exception;

	public SysUser getSysUserById(int id) throws Exception;

	public void updateSysUser(SysUser sysUser) throws Exception;

	public void deleteSysUser(int[] id) throws Exception;

	public PageBean findSysUsers(SysUser sysUser,int pageSize, int page) throws Exception;
}
