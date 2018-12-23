package com.kexun.wm.store.action;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.kexun.wm.store.bean.HUser;
import com.kexun.wm.store.service.HUserService;
import com.kexun.wm.store.service.impl.HUserServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;

public class HUserAction {
	static Log log = LogFactory.getLog(HUserAction.class);
	private File file;
	private HUser user1;
	private HUserService user1Service = new HUserServiceImpl();
	private List<HUser> user1List;
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

	public String getHUserItem() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		return "user1Form";
	}

	public String addHUser() throws Exception {
		if (user1Service.getHUserByName(user1.getName()) == null) {
			int result = user1Service.saveHUser(user1);
			if (result == 1) {
				ShowMessageUtil.showAddSuccess();
				user1 = user1Service.findHUserById(user1.getId());
				return "user1";
			} else {
				ShowMessageUtil.showAddFalse();
				return "false";
			}
		} else {
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = user1Service.queryAllRows(user1);
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			user1List = user1Service.queryHUser(user1, pageNo,
					pageSize);
			ShowMessageUtil.showExistSuccess();
			return "queryHUser";
		}
	}

	public String getHUserById() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		user1 = user1Service.findHUserById(user1.getId());
		if (("first").equals(flag)) {
			return "user1";
		} else {
			return "modify";
		}
	}

	public String modifyHUser() throws Exception {
		int result = user1Service.updateHUser(user1);
		if (result == 1) {
			ShowMessageUtil.showModifySuccess();
			user1 = user1Service.findHUserById(user1.getId());
			return "user1";
		} else {
			ShowMessageUtil.showModifyFalse();
			return "false";

		}
	}

	// public String deleteHUser() throws Exception {
	// HttpServletRequest request = ServletActionContext.getRequest();
	// nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
	// String id[] = ids.split(",");
	// for (int i = 0; i < id.length; i++) {
	// productList = user1Service.queryHProductByHUserId(Integer
	// .parseInt(id[i]));
	// if (productList == null || productList.size() == 0) {
	// result1 += user1Service.deleteHUser(Integer
	// .parseInt(id[i]));
	// } else {
	// result2++;
	// }
	// }
	// if ((result1 + result2) == id.length) {
	// return "delete";
	// } else {
	// ShowMessageUtil.showDeleteFalse();
	// return "false";
	// }
	// }

	public String queryHUser() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		HttpServletRequest request = ServletActionContext.getRequest();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		user1 = new HUser(nameId);
		recordCount = user1Service.queryAllRows(user1);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		user1List = user1Service.queryHUser(user1, pageNo,
				pageSize);
		if (result2 > 0) {
			ShowMessageUtil.showNotDelete();
		}
		return "queryHUser";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = user1Service.queryAllRows(user1);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		user1List = user1Service.queryHUser(user1, --pageNo,
				pageSize);
		return "queryHUser";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = user1Service.queryAllRows(user1);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		user1List = user1Service.queryHUser(user1, ++pageNo,
				pageSize);
		return "queryHUser";
	}

	public String addHUserExcel() throws Exception {
		// 创建对Excel工作簿文件的引用
		HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(file));
		// 在Excel文档中，第一张工作表的缺省索引是0
		// 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);­
		HSSFSheet sheet = wookbook.getSheet("Sheet1");
		// 获取到Excel文件中的所有行数
		int rows = sheet.getPhysicalNumberOfRows();
		// 遍历行
		for (int i = 1; i < rows; i++) {
			// 读取左上端单元格
			HSSFRow row = sheet.getRow(i);
			// 行不为空­
			// if (row != null) {
			// 获取到Excel文件中的所有的列­
			int cells = row.getPhysicalNumberOfCells();
			String value = "";
			// 遍历列­
			for (int j = 0; j < cells; j++) {
				// 获取到列的值即胶框号这一列，无id时，row.getCell(0)；有id时row.getCell(1)
				// 与下面的val[i]是一样的
				HSSFCell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC:
					BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
					value += bd.toPlainString() + ",";
					break;

				case HSSFCell.CELL_TYPE_STRING:
					if ("".equals(cell.getStringCellValue())) {
						value = "";
						j = cells;
					} else {
						value += cell.getStringCellValue() + ",";
					}
					break;
				/*
				 * default: break;
				 */
				}
			}
			// }
			// 将数据插入到mysql数据库中
			if (!"".equals(value)) {
				String[] val = value.split(",");
				user1.setName(val[0]);
				if (user1Service.getHUserByName(val[0]) == null) {
					user1Service.saveHUser(user1);
				} else {
					continue;
				}

			}

		}
		// }
		return "true";

	}

	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		HUserAction.log = log;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public HUser getUser1() {
		return user1;
	}

	public void setUser1(HUser user1) {
		this.user1 = user1;
	}

	public HUserService getUser1Service() {
		return user1Service;
	}

	public void setUser1Service(HUserService user1Service) {
		this.user1Service = user1Service;
	}

	public List<HUser> getUser1List() {
		return user1List;
	}

	public void setUser1List(List<HUser> user1List) {
		this.user1List = user1List;
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
