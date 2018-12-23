package com.kexun.wm.system.service;

import java.util.List;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.SysMenu;

/** 
 * @author Frank  
 * @date 2014-9-26 下午3:20:24
 */
public interface SysMenuService {
	
	public List<SysMenu> findSysMenus() throws Exception;
	
	public List<SysMenu> findParentMenus() throws Exception;

	public void saveSysMenu(SysMenu sysMenu) throws Exception;
	
	public PageBean findSysMenus(SysMenu sysMenu,int pageSize,int page) throws Exception;
	
	public SysMenu getSysMenuById(int id) throws Exception;
	
	public void updateSysMenu(SysMenu sysMenu) throws Exception;
	
	public void deleteSysMenu(int[] id) throws Exception;
}
