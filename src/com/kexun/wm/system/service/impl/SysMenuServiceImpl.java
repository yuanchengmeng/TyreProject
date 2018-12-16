package com.kexun.wm.system.service.impl;

import java.util.List;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.SysMenu;
import com.kexun.wm.system.dao.SysMenuDao;
import com.kexun.wm.system.dao.impl.SysMenuDaoImpl;
import com.kexun.wm.system.service.SysMenuService;

/** 
 * @author Frank  
 * @date 2014-9-26 下午3:25:02
 */
public class SysMenuServiceImpl implements SysMenuService {

	private SysMenuDao sysMenuDao = new SysMenuDaoImpl();
	
	public void saveSysMenu(SysMenu sysMenu) throws Exception {
		sysMenuDao.saveSysMenu(sysMenu);
	}

	public SysMenu getSysMenuById(int id) throws Exception {
		return sysMenuDao.getSysMenuById(id);
	}

	public void updateSysMenu(SysMenu sysMenu) throws Exception {
		sysMenuDao.updateSysMenu(sysMenu);
	}

	public void deleteSysMenu(int[] id) throws Exception {
		sysMenuDao.deleteSysMenu(id);
	}

	public PageBean findSysMenus(SysMenu sysMenu,int pageSize,int page) throws Exception {
		int allRow = sysMenuDao.getAllRowCount(sysMenu);
		int totalPage = PageBean.counTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		List sysMenuList = sysMenuDao.findSysMenus(sysMenu,offset, length);
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(sysMenuList);
		pageBean.init();
		return pageBean;
	}

	public List<SysMenu> findSysMenus() throws Exception {
		return sysMenuDao.findSysMenus();
	}

	public List<SysMenu> findParentMenus() throws Exception {
		return sysMenuDao.findParentMenus();
	}

}
