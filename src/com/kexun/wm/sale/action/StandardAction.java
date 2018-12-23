package com.kexun.wm.sale.action;

import java.util.List;

import com.kexun.wm.sale.bean.Standard;
import com.kexun.wm.sale.service.StandardService;
import com.kexun.wm.sale.service.impl.StandardServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class StandardAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Standard standard;
	private StandardService standardService = new StandardServiceImpl();
	private String flag;
	private String ids;
	private String nameId = "";
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private List<PageSize> pageSizeList;
	private List<Standard> standardList;

	public String getStandardItem() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		return "standardForm";
	}

	public String addStandard() throws Exception {
		
		if (standardService.getStandardByCode(standard) != null) {
			ShowMessageUtil.showRepeatCode();
		}else if (standardService.getStandardByName(standard) != null){
			ShowMessageUtil.showRepeatName();
		}else{
			standard.setCtime(AllSelectItemUtil.getNowTime());
			if(AllSelectItemUtil.getCurrentUser()==null){
				return "501";
			}
			standard.setCuser(AllSelectItemUtil.getCurrentUser().getJobNo()+AllSelectItemUtil.getCurrentUser().getName());
			int result = standardService.saveStandard(standard);
			if (result != 1) {
				ShowMessageUtil.showAddFalse();
				return "false";
			}
		}
		standard=new Standard();
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = standardService.queryStandardSize(standard).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
 		standardList = standardService.queryStandard(standard, pageNo,pageSize);
 		return "queryStandard";
	}

	public String getStandardById() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		standard = standardService.getStandardById(standard.getId());
		return "modify";
	}

	public String modifyStandard() throws Exception {
		standard.setCtime(AllSelectItemUtil.getNowTime());
		if(AllSelectItemUtil.getCurrentUser()==null){
			return "501";
		}
		standard.setCuser(AllSelectItemUtil.getCurrentUser().getJobNo()+AllSelectItemUtil.getCurrentUser().getName());
		if (standardService.queryStandardByCode(standard) != null) {
			ShowMessageUtil.showRepeatCode();
		}else if (standardService.queryStandardByName(standard) != null){
			ShowMessageUtil.showRepeatName();
		}else{
			int result = standardService.updateStandard(standard);
			if (result != 1) {
				ShowMessageUtil.showModifyFalse();
				return "false";
			}
		}
		
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = standardService.queryStandardSize(standard).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		standardList = standardService.queryStandard(standard, pageNo,
				pageSize);
		return "queryStandard";
	}

	public String deleteStandard() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
			result += standardService.deleteStandard(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = standardService.queryStandardSize(standard).size();
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			standardList = standardService.queryStandard(standard, pageNo,
					pageSize);
			return "delete";
		} else {
			ShowMessageUtil.showDeleteFalse();
			return "false";
		}
	}

	public String queryStandard() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = standardService.queryStandardSize(standard).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		standardList = standardService.queryStandard(standard, pageNo,
				pageSize);
		return "queryStandard";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = standardService.queryStandardSize(standard).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		standardList = standardService.queryStandard(standard, --pageNo,
				pageSize);
		return "queryStandard";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = standardService.queryStandardSize(standard).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		standardList = standardService.queryStandard(standard, ++pageNo,
				pageSize);
		return "queryStandard";
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public StandardService getStandardService() {
		return standardService;
	}

	public void setStandardService(StandardService standardService) {
		this.standardService = standardService;
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

	public List<Standard> getStandardList() {
		return standardList;
	}

	public void setStandardList(List<Standard> standardList) {
		this.standardList = standardList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
