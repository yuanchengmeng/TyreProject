package com.kexun.wm.system.service.impl;

import java.util.List;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.SysUser;
import com.kexun.wm.system.dao.SysUserDao;
import com.kexun.wm.system.dao.impl.SysUserDaoImpl;
import com.kexun.wm.system.service.SysUserService;

public class SysUserServiceImpl implements SysUserService {
	private SysUserDao sysUserDao = new SysUserDaoImpl();

	public SysUser querySysUser(String jobNo, String password) throws Exception {
		// TODO Auto-generated method stub
		return sysUserDao.querySysUser(jobNo, password);
	}

	public void saveSysUser(SysUser sysUser) throws Exception {
		sysUserDao.saveSysUser(sysUser);
	}

	public SysUser getSysUserById(int id) throws Exception {
		return sysUserDao.getSysUserById(id);
	}

	public void updateSysUser(SysUser sysUser) throws Exception {
		sysUserDao.updateSysUser(sysUser);
	}

	public void deleteSysUser(int[] id) throws Exception {
		sysUserDao.deleteSysUser(id);
	}

	public PageBean findSysUsers(SysUser sysUser,int pageSize, int page) throws Exception {
		int allRow = sysUserDao.getAllRowCount(sysUser);
		int totalPage = PageBean.counTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(page);
		List sysUserList = sysUserDao.findSysUsers(sysUser,offset, length);
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(sysUserList);
		pageBean.init();
		return pageBean;
	}

	public List<SysUser> querySysUserList(SysUser sysUser) throws Exception {
		return sysUserDao.querySysUserList(sysUser);
	}

	public SysUser findByJobNo(String name) throws Exception {
		return sysUserDao.findByJobNo(name);
	}

	public SysUser findByName(String name) throws Exception {
		return sysUserDao.findByName(name);
	}
}
