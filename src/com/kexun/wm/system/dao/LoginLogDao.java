package com.kexun.wm.system.dao;

import java.util.List;

import com.kexun.wm.system.bean.LoginLog;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:09:41
 */
public interface LoginLogDao {

public void addLoginLog(LoginLog loginLog) throws Exception;
	
	public List<LoginLog> queryLoginLog(LoginLog loginLog,final int offset,final int length) throws Exception;
  		
	public int getAllRowCount(LoginLog loginLog) throws Exception;
}
