package com.kexun.wm.system.service;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.LoginLog;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:15:47
 */
public interface LoginLogService {

	public void addLoginLog(LoginLog loginLog) throws Exception;
	
	public PageBean queryLoginLog(LoginLog loginLog,int pageNo,int pageSize) throws Exception;
	
	public int queryAllRows(LoginLog loginLog) throws Exception;
}
