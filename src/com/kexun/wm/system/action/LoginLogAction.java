package com.kexun.wm.system.action;

import java.util.List;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.LoginLog;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.service.LoginLogService;
import com.kexun.wm.system.service.impl.LoginLogServiceImpl;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.opensymphony.xwork2.ActionSupport;

public class LoginLogAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginLogService loginLogService = new LoginLogServiceImpl();
	private LoginLog loginLog;
	private List<LoginLog> loginLogList;
	private PageBean pageBean;
	private int page = 1;
	private int pageSize = 5;
	private int totalPage;
	private List<PageSize> pageSizeList = null;
	private String logtime;
  	
	public String queryLoginLog() throws Exception{
		if (page == 0) {
			pageSize = pageSizeList.get(0).getPsize();
		}
	    pageSizeList = AllSelectItemUtil.queryPageSize();
		pageBean = loginLogService.queryLoginLog(loginLog, page, pageSize);
		totalPage = pageBean.getTotalPage();
		loginLogList = pageBean.getList();
		return SUCCESS;
	}

	public LoginLogService getLoginLogService() {
		return loginLogService;
	}

	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}

	public LoginLog getLoginLog() {
		return loginLog;
	}

	public void setLoginLog(LoginLog loginLog) {
		this.loginLog = loginLog;
	}

	public List<LoginLog> getLoginLogList() {
		return loginLogList;
	}

	public void setLoginLogList(List<LoginLog> loginLogList) {
		this.loginLogList = loginLogList;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
}
