package com.kexun.wm.manage.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;
import com.kexun.wm.manage.service.DeptService;
import com.kexun.wm.manage.service.impl.DeptServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;

public class DeptAction {
	static Log log = LogFactory.getLog(DeptAction.class);
 	private Dept dept;
	private DeptService deptService = new DeptServiceImpl();
	private List<Dept> deptList;
	private List<Emp> empList;
	private String flag;
	private String ids;
	private String nameId = "";
	private int pageNo = 1;
	private int pageSize;
	private int recordCount;
	private int pageCount = 1;
	private List<PageSize> pageSizeList;

	
	public String getDeptItem() throws Exception {
 		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
 		empList=AllSelectItemUtil.queryLeader();
		return "deptForm";
	}

	public String addDept() throws Exception {
		if (deptService.getDeptByName(dept.getDeptname()) == null) {
			if(dept.getBoss().getId()==0){
				dept.setBoss(null);
			}
			int result = deptService.saveDept(dept);
			if (result == 1) {
				dept = deptService.findDeptById(dept.getId());
				return "dept";
			} else {
				return "false";
			}
		} else {
			ShowMessageUtil.showExistSuccess();
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = deptService.queryAllRows(dept);
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			deptList = deptService.queryDept(dept, pageNo, pageSize);
			return "queryDept";
		}
	}

	public String getDeptById() throws Exception {
 		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		dept = deptService.findDeptById(dept.getId());
		if (("first").equals(flag)) {
			return "dept";
		} else {
			empList=AllSelectItemUtil.queryLeader();
			return "modify";
		}
	}

	public String modifyDept() throws Exception {
		if(dept.getBoss().getId()==0){
			dept.setBoss(null);
		}
 		int result = deptService.updateDept(dept);
		if (result == 1) {
			dept = deptService.findDeptById(dept.getId());
			return "dept";
		} else {
			return "false";
		}
	}

	public String deleteDept() throws Exception {
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
 			result += deptService.deleteDept(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			return "delete";
		} else {
			return "false";
		}
	}

	public String queryDept() throws Exception {
 		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize==0) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = deptService.queryAllRows(dept);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		deptList = deptService.queryDept(dept, pageNo, pageSize);
		return "queryDept";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = deptService.queryAllRows(dept);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		deptList = deptService.queryDept(dept, --pageNo, pageSize);
		return "queryDept";

	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = deptService.queryAllRows(dept);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		deptList = deptService.queryDept(dept, ++pageNo, pageSize);
		return "queryDept";

	}
 	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		DeptAction.log = log;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public DeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

}
