package com.kexun.wm.manage.action;

import java.util.List;

import com.kexun.wm.manage.bean.HandClass;
import com.kexun.wm.manage.service.HandClassService;
import com.kexun.wm.manage.service.impl.HandClassServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class HandClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HandClass handClass;
	private HandClassService handClassService = new HandClassServiceImpl();
	private String flag;
	private String ids;
	private String nameId = "";
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private List<PageSize> pageSizeList;
	private List<HandClass> handClassList;

	public String getHandClassItem() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		return "handClassForm";
	}

	public String addHandClass() throws Exception {
		if (handClassService.getHandClassByName(handClass.getName()) == null) {
			int result = handClassService.saveHandClass(handClass);
			if (result != 1) {
				ShowMessageUtil.showAddFalse();
				return "false";
			}
		} else {
			ShowMessageUtil.showAddRepeat();
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = handClassService.queryHandClassSize(handClass).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		handClassList = handClassService.queryHandClass(handClass, pageNo,
				pageSize);
		return "queryHandClass";
	}

	public String getHandClassById() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		handClass = handClassService.getHandClassById(handClass.getId());
		return "modify";
	}

	public String modifyHandClass() throws Exception {
		int result = handClassService.updateHandClass(handClass);
		if (result != 1) {
			ShowMessageUtil.showModifyFalse();
			return "false";
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = handClassService.queryHandClassSize(handClass).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		handClassList = handClassService.queryHandClass(handClass, pageNo,
				pageSize);
		return "queryHandClass";
	}

	public String deleteHandClass() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
			result += handClassService.deleteHandClass(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = handClassService.queryHandClassSize(handClass).size();
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			handClassList = handClassService.queryHandClass(handClass, pageNo,
					pageSize);
			return "delete";
		} else {
			ShowMessageUtil.showDeleteFalse();
			return "false";
		}
	}

	public String queryHandClass() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = handClassService.queryHandClassSize(handClass).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		handClassList = handClassService.queryHandClass(handClass, pageNo,
				pageSize);
		return "queryHandClass";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = handClassService.queryHandClassSize(handClass).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		handClassList = handClassService.queryHandClass(handClass, --pageNo,
				pageSize);
		return "queryHandClass";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = handClassService.queryHandClassSize(handClass).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		handClassList = handClassService.queryHandClass(handClass, ++pageNo,
				pageSize);
		return "queryHandClass";
	}

	public HandClass getHandClass() {
		return handClass;
	}

	public void setHandClass(HandClass handClass) {
		this.handClass = handClass;
	}

	public HandClassService getHandClassService() {
		return handClassService;
	}

	public void setHandClassService(HandClassService handClassService) {
		this.handClassService = handClassService;
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

	public List<HandClass> getHandClassList() {
		return handClassList;
	}

	public void setHandClassList(List<HandClass> handClassList) {
		this.handClassList = handClassList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
