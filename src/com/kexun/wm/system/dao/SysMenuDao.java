package com.kexun.wm.system.dao;

import java.util.List;

import com.kexun.wm.system.bean.SysMenu;

/** 
 * @author Frank  
 * @date 2014-9-26 上午11:11:12
 */
public interface SysMenuDao {
	
	public List<SysMenu> findSysMenus() throws Exception;
	
	public List<SysMenu> findParentMenus() throws Exception;

	public void saveSysMenu(SysMenu sysMenu) throws Exception;
	
	public List<SysMenu> findSysMenus(SysMenu sysMenu,final int offset,final int length) throws Exception;
	
	public SysMenu getSysMenuById(int id) throws Exception;
	
	public void updateSysMenu(SysMenu sysMenu) throws Exception;
	
	public void deleteSysMenu(int[] id) throws Exception;
	
	public int getAllRowCount(SysMenu sysMenu) throws Exception;
}
