package com.kexun.wm.system.dao;

import java.util.List;

import com.kexun.wm.system.bean.SysUser;

public interface SysUserDao {
	public SysUser findByJobNo(String name) throws Exception;
	
	public SysUser findByName(String name) throws Exception;

	// 获取需要登录的用户
	public SysUser querySysUser(String jobNo, String password) throws Exception;

	// 显示所有符合条件的用户
	public List<SysUser> querySysUserList(SysUser sysUser) throws Exception;

	// 添加登录普通用户
	public void saveSysUser(SysUser sysUser) throws Exception;

	public List<SysUser> findSysUsers(SysUser sysUser,final int offset, final int length)
			throws Exception;

	// 查看详细，修改删除用户
	public SysUser getSysUserById(int id) throws Exception;

	public void updateSysUser(SysUser sysUser) throws Exception;

	public void deleteSysUser(int[] id) throws Exception;

	public int getAllRowCount(SysUser sysUser) throws Exception;
}
