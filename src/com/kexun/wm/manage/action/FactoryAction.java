package com.kexun.wm.manage.action;

import java.util.List;

import com.kexun.wm.manage.bean.Factory;
import com.kexun.wm.manage.service.FactoryService;
import com.kexun.wm.manage.service.impl.FactoryServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class FactoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Factory factory;
	private FactoryService factoryService = new FactoryServiceImpl();
	private String flag;
	private String ids;
	private String nameId = "";
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private List<PageSize> pageSizeList;
	private List<Factory> factoryList;

	public String getFactoryItem() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		return "factoryForm";
	}

	public String addFactory() throws Exception {
		if (factoryService.getFactoryByName(factory.getName()) == null) {
			int result = factoryService.saveFactory(factory);
			if (result != 1) {
				ShowMessageUtil.showAddFalse();
				return "false";
			}
		}else{
			ShowMessageUtil.showAddRepeat();
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = factoryService.queryFactorySize(factory).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		factoryList = factoryService.queryFactory(factory, pageNo,
				pageSize);
 		return "queryFactory";
	}

	public String getFactoryById() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		factory = factoryService.getFactoryById(factory.getId());
		return "modify";
	}

	public String modifyFactory() throws Exception {
		int result = factoryService.updateFactory(factory);
		if (result != 1) {
			ShowMessageUtil.showModifyFalse();
			return "false";
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = factoryService.queryFactorySize(factory).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		factoryList = factoryService.queryFactory(factory, 1,
				pageSize);
		return "queryFactory";
	}

	public String deleteFactory() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
			result += factoryService.deleteFactory(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = factoryService.queryFactorySize(factory).size();
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			factoryList = factoryService.queryFactory(factory, pageNo,
					pageSize);
			return "delete";
		} else {
			ShowMessageUtil.showDeleteFalse();
			return "false";
		}
	}

	public String queryFactory() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = factoryService.queryFactorySize(factory).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		factoryList = factoryService.queryFactory(factory, pageNo,
				pageSize);
		return "queryFactory";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = factoryService.queryFactorySize(factory).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		factoryList = factoryService.queryFactory(factory, --pageNo,
				pageSize);
		return "queryFactory";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = factoryService.queryFactorySize(factory).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		factoryList = factoryService.queryFactory(factory, ++pageNo,
				pageSize);
		return "queryFactory";
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public FactoryService getFactoryService() {
		return factoryService;
	}

	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
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

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
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

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
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

	public List<Factory> getFactoryList() {
		return factoryList;
	}

	public void setFactoryList(List<Factory> factoryList) {
		this.factoryList = factoryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 
}
