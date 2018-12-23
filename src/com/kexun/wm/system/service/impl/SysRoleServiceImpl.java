package com.kexun.wm.system.service.impl;

import java.util.List;

import com.kexun.wm.system.bean.SysRole;
import com.kexun.wm.system.dao.SysRoleDao;
import com.kexun.wm.system.dao.impl.SysRoleDaoImpl;
import com.kexun.wm.system.service.SysRoleService;

/** 
 * @author Frank  
 * @date 2014-9-28 下午2:30:23
 */
public class SysRoleServiceImpl implements SysRoleService {

	private SysRoleDao sysRoleDao = new SysRoleDaoImpl();
	
	public void saveSysRole(SysRole sysRole) throws Exception {
		sysRoleDao.saveSysRole(sysRole);
	}

	public SysRole getSysRoleById(int id) throws Exception {
		return sysRoleDao.getSysRoleById(id);
	}

	public void updateSysRole(SysRole sysRole) throws Exception {
		sysRoleDao.updateSysRole(sysRole);
	}

	public void deleteSysRole(int id) throws Exception {
		sysRoleDao.deleteSysRole(id);
	}

	public List<SysRole> findSysRoles(SysRole sysRole, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		return sysRoleDao.findSysRoles(sysRole, pageNo, pageSize);
	}

	public List<SysRole> findSysRoles() throws Exception {
		// TODO Auto-generated method stub
		return sysRoleDao.findSysRoles();
	}

	public int queryAllRows(SysRole sysRole) throws Exception {
		// TODO Auto-generated method stub
		return sysRoleDao.queryAllRows(sysRole);
	}

}
