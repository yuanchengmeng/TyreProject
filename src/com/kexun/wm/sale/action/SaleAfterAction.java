package com.kexun.wm.sale.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.kexun.wm.sale.bean.SaleAfter;
import com.kexun.wm.sale.service.SaleAfterService;
import com.kexun.wm.sale.service.impl.SaleAfterServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;

public class SaleAfterAction {
	static Log log = LogFactory.getLog(SaleAfterAction.class);
	private File file;
	private SaleAfter saleAfter;
	private SaleAfterService saleAfterService = new SaleAfterServiceImpl();
	private List<SaleAfter> saleAfterList;
	private String nameId = "";
	private String flag;
	private String ids;
	private int recordCount;
	private int pageCount = 1;
	private int pageNo = 1;
	private int result1 = 0;
	private int result2 = 0;
	private int pageSize;
	private List<PageSize> pageSizeList;

	public String getSaleAfterItem() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		return "saleAfterForm";
	}

	public String addSaleAfter() throws Exception {
//		if (saleAfterService.getSaleAfterByName(saleAfter.getBarcode()) == null) {
			int result = saleAfterService.saveSaleAfter(saleAfter);
			if (result == 1) {
				ShowMessageUtil.showAddSuccess();
				saleAfter = saleAfterService.findSaleAfterById(saleAfter.getId());
				return "saleAfter";
			} else {
				ShowMessageUtil.showAddFalse();
				return "false";
			}
//		} else {
//			pageSizeList = AllSelectItemUtil.queryPageSize();
//			recordCount = saleAfterService.queryAllRows(saleAfter);
//			if (pageSize != 0) {
//				pageCount = (recordCount + pageSize - 1) / pageSize;
//			}
//			saleAfterList = saleAfterService.querySaleAfter(saleAfter, pageNo,
//					pageSize);
//			ShowMessageUtil.showExistSuccess();
//			return "querySaleAfter";
//		}
	}

	public String getSaleAfterById() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		saleAfter = saleAfterService.findSaleAfterById(saleAfter.getId());
		if (("first").equals(flag)) {
			return "saleAfter";
		} else {
			return "modify";
		}
	}

	public String modifySaleAfter() throws Exception {
		int result = saleAfterService.updateSaleAfter(saleAfter);
		if (result == 1) {
			ShowMessageUtil.showModifySuccess();
			saleAfter = saleAfterService.findSaleAfterById(saleAfter.getId());
			return "saleAfter";
		} else {
			ShowMessageUtil.showModifyFalse();
			return "false";

		}
	}

	public String querySaleAfter() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		HttpServletRequest request = ServletActionContext.getRequest();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
//		saleAfter = new SaleAfter(nameId);
		recordCount = saleAfterService.queryAllRows(saleAfter);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		saleAfterList = saleAfterService.querySaleAfter(saleAfter, pageNo,
				pageSize);
		if (result2 > 0) {
			ShowMessageUtil.showNotDelete();
		}
		return "querySaleAfter";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = saleAfterService.queryAllRows(saleAfter);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		saleAfterList = saleAfterService.querySaleAfter(saleAfter, --pageNo,
				pageSize);
		return "querySaleAfter";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = saleAfterService.queryAllRows(saleAfter);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		saleAfterList = saleAfterService.querySaleAfter(saleAfter, ++pageNo,
				pageSize);
		return "querySaleAfter";
	}

	public String deleteSaleAfter() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
			result += saleAfterService.deleteSaleAfter(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			recordCount = saleAfterService.queryAllRows(saleAfter);
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			saleAfterList = saleAfterService.querySaleAfter(saleAfter, pageNo, pageSize);
			return "delete";
		} else {
			ShowMessageUtil.showDeleteFalse();
			return "false";
		}
	}
	
	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		SaleAfterAction.log = log;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public SaleAfter getSaleAfter() {
		return saleAfter;
	}

	public void setSaleAfter(SaleAfter saleAfter) {
		this.saleAfter = saleAfter;
	}

	public SaleAfterService getSaleAfterService() {
		return saleAfterService;
	}

	public void setSaleAfterService(SaleAfterService saleAfterService) {
		this.saleAfterService = saleAfterService;
	}

	public List<SaleAfter> getSaleAfterList() {
		return saleAfterList;
	}

	public void setSaleAfterList(List<SaleAfter> saleAfterList) {
		this.saleAfterList = saleAfterList;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
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
