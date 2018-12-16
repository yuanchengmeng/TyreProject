package com.kexun.wm.manage.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;
import com.kexun.wm.manage.bean.Job;
import com.kexun.wm.manage.service.EmpService;
import com.kexun.wm.manage.service.impl.EmpServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;

public class EmpAction {
	static Log log = LogFactory.getLog(EmpAction.class);
 	private Emp emp;
	private List<Emp> empList;
	private List<Dept> deptList;
	private List<Job> jobList;
	private EmpService empService = new EmpServiceImpl();
 	private String nameId = "";
	private String flag;
	private String ids;
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private List<PageSize> pageSizeList;

	public String getEmpItem() throws Exception {
 		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
 		deptList = AllSelectItemUtil.queryDept();
 		jobList=AllSelectItemUtil.queryJob();
 		return "empForm";

	}

	public String addEmp() throws Exception {
		if (empService.getEmpByName(emp.getEname(), emp.getDept()) == null) {
			int result = empService.saveEmp(emp);
  			if (result == 1) {
 				ShowMessageUtil.showAddSuccess();
				pageSizeList = AllSelectItemUtil.queryPageSize();
				recordCount = empService.queryAllRows(emp);
				if (pageSize != 0) {
					pageCount = (recordCount + pageSize - 1) / pageSize;
				}
				empList = empService.queryEmp(emp, pageNo, pageSize);
				return "queryEmp";
			} else {
				return "false";
			}
		} else {
			ShowMessageUtil.showExistSuccess();
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = empService.queryAllRows(emp);
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			empList = empService.queryEmp(emp, pageNo, pageSize);
			return "queryEmp";
		}
	}

	public String getEmpById() throws Exception {
 		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		deptList = AllSelectItemUtil.queryDept();
		emp = empService.findEmpById(emp.getId());
 		if (("first").equals(flag)) {
			return "emp";
		} else {
			deptList = AllSelectItemUtil.queryDept();
			jobList=AllSelectItemUtil.queryJob();
			return "modify";
		}
	}

	public String modifyEmp() throws Exception {
 		int result = empService.updateEmp(emp);
		if (result == 1) {
 			ShowMessageUtil.showModifySuccess();
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = empService.queryAllRows(emp);
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			empList = empService.queryEmp(emp, pageNo, pageSize);
			ShowMessageUtil.showModifySuccess();
			return "queryEmp";
		} else {
			ShowMessageUtil.showModifyFalse();
			return "false";
		}
	}

	public String deleteEmp() throws Exception {
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
 			result += empService.deleteEmp(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			return "delete";
		} else {
			return "false";
		}
	}

	public String queryEmp() throws Exception {
 		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		deptList = AllSelectItemUtil.queryDept();
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize==0) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		emp = new Emp(nameId);
		recordCount = empService.queryAllRows(emp);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		empList = empService.queryEmp(emp, pageNo, pageSize);
		return "queryEmp";

	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = empService.queryAllRows(emp);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		empList = empService.queryEmp(emp, --pageNo, pageSize);
		return "queryEmp";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = empService.queryAllRows(emp);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		empList = empService.queryEmp(emp, ++pageNo, pageSize);
		return "queryEmp";
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}
	
	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		EmpAction.log = log;
	}
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
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

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}

}
