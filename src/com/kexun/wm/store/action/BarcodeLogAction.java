package com.kexun.wm.store.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kexun.wm.store.bean.BarcodeLog;
import com.kexun.wm.store.service.BarcodeLogService;
import com.kexun.wm.store.service.impl.BarcodeLogServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;

public class BarcodeLogAction {
	static Log log = LogFactory.getLog(BarcodeLogAction.class);
	private BarcodeLog barcodeLog;
	private BarcodeLogService barcodeLogService = new BarcodeLogServiceImpl();
	private List<BarcodeLog> barcodeLogList;
	private String flag;
	private String ids;
	private int recordCount;
	private int pageCount = 1;
	private int pageNo = 1;
	private int result1 = 0;
	private int result2 = 0;
	private int pageSize;
	private List<PageSize> pageSizeList;

	public String queryBarcodeLog() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = barcodeLogService.queryBarcodeLogSize(barcodeLog);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		barcodeLogList = barcodeLogService.queryBarcodeLog(barcodeLog, pageNo,
				pageSize);
		return "queryBarcodeLog";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = barcodeLogService.queryBarcodeLogSize(barcodeLog);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		barcodeLogList = barcodeLogService.queryBarcodeLog(barcodeLog, --pageNo,
				pageSize);
		return "queryBarcodeLog";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = barcodeLogService.queryBarcodeLogSize(barcodeLog);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		barcodeLogList = barcodeLogService.queryBarcodeLog(barcodeLog, ++pageNo,pageSize);
		return "queryBarcodeLog";
	}

	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		BarcodeLogAction.log = log;
	}

	public BarcodeLog getBarcodeLog() {
		return barcodeLog;
	}

	public void setBarcodeLog(BarcodeLog barcodeLog) {
		this.barcodeLog = barcodeLog;
	}

	public BarcodeLogService getBarcodeLogService() {
		return barcodeLogService;
	}

	public void setBarcodeLogService(BarcodeLogService barcodeLogService) {
		this.barcodeLogService = barcodeLogService;
	}

	public List<BarcodeLog> getBarcodeLogList() {
		return barcodeLogList;
	}

	public void setBarcodeLogList(List<BarcodeLog> barcodeLogList) {
		this.barcodeLogList = barcodeLogList;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getResult1() {
		return result1;
	}

	public void setResult1(int result1) {
		this.result1 = result1;
	}

	public int getResult2() {
		return result2;
	}

	public void setResult2(int result2) {
		this.result2 = result2;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

}
