package com.kexun.wm.store.action;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;
import com.kexun.wm.store.service.StatisManageService;
import com.kexun.wm.store.service.impl.StatisManageServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;


/**
 * 统计管理
 * @author Administrator
 *
 */
public class StatisManageAction {
	StatisManageService statisManageService = new StatisManageServiceImpl();
	private int pageNo = 1;
	private int pageCount = 1;
	private int pageSize;
	private StatisParams params = new StatisParams();
	private List<StandardStatisVo> standardList;
	private List<PageSize> pageSizeList;
	
	public String queryStandardStatis() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		
		if(StringUtils.isBlank(params.getTimeStart())){
			params.setTimeStart(AllSelectItemUtil.getDateByDay(-1));
		}
		if(StringUtils.isBlank(params.getTimeEnd())){
			params.setTimeEnd(AllSelectItemUtil.getDateByDay(0));
		}
		standardList = statisManageService.queryStandardStatis(params, pageNo, pageSize);
		return "queryStandardStatis";
	}

	public StatisManageService getStatisManageService() {
		return statisManageService;
	}

	public void setStatisManageService(StatisManageService statisManageService) {
		this.statisManageService = statisManageService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public StatisParams getParams() {
		return params;
	}

	public void setParams(StatisParams params) {
		this.params = params;
	}

	public List<StandardStatisVo> getStandardList() {
		return standardList;
	}

	public void setStandardList(List<StandardStatisVo> standardList) {
		this.standardList = standardList;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}
	
}
