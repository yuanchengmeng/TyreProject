package com.kexun.wm.system.service.impl;

import java.util.List;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.LoginLog;
import com.kexun.wm.system.dao.LoginLogDao;
import com.kexun.wm.system.dao.impl.LoginLogDaoImpl;
import com.kexun.wm.system.service.LoginLogService;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:16:46
 */
public class LoginLogServiceImpl implements LoginLogService {

	private LoginLogDao loginLogDao = new LoginLogDaoImpl();
	public void addLoginLog(LoginLog loginLog) throws Exception {
		loginLogDao.addLoginLog(loginLog);
	}

	public PageBean queryLoginLog(LoginLog loginLog, int pageNo, int pageSize)
			throws Exception {
		int allRow = loginLogDao.getAllRowCount(loginLog);
		int totalPage = PageBean.counTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, pageNo);
		final int length = pageSize;
		final int currentPage = PageBean.countCurrentPage(pageNo);
		List loginLogList = loginLogDao.queryLoginLog(loginLog, offset, length);
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(loginLogList);
		pageBean.init();
		return pageBean;
	}

	public int queryAllRows(LoginLog loginLog) throws Exception {
		return loginLogDao.getAllRowCount(loginLog);
	}

}
