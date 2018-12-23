package com.kexun.wm.system.service;

import java.util.List;

import com.kexun.wm.system.bean.SysRole;

/**
 * @author Frank
 * @date 2014-9-28 下午2:29:22
 */
public interface SysRoleService {

	public List<SysRole> findSysRoles(SysRole sysRole, int pageNo, int pageSize)
			throws Exception;

	public int queryAllRows(SysRole sysRole) throws Exception;

	public List<SysRole> findSysRoles() throws Exception;

	public void saveSysRole(SysRole sysRole) throws Exception;

	public SysRole getSysRoleById(int id) throws Exception;

	public void updateSysRole(SysRole sysRole) throws Exception;

	public void deleteSysRole(int id) throws Exception;
}
