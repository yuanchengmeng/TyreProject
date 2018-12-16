package com.kexun.wm.store.action;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.kexun.wm.store.bean.DayReport;
import com.kexun.wm.store.service.DayReportService;
import com.kexun.wm.store.service.StoreService;
import com.kexun.wm.store.service.impl.DayReportServiceImpl;
import com.kexun.wm.store.service.impl.StoreServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.opensymphony.xwork2.ActionContext;

public class DayReportAction {
	private DayReport dayReport =new DayReport();
	private DayReportService dayReportService = new DayReportServiceImpl();
	private StoreService storeService = new StoreServiceImpl();
	private List<DayReport> dayReportList;
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private String flag;
	private List<PageSize> pageSizeList;
	private String ids;
	private int id;
	private String barcodes;
	private String sign;
	private int classId;
	
 	public String queryDayReport() throws Exception {
		if("0".equals(sign)){
			dayReport.setTimeStart(AllSelectItemUtil.getDayStart());
			dayReport.setTimeEnd(AllSelectItemUtil.getDayEnd());
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		
		if("1".equals(flag)){
			recordCount = dayReportService.queryInDayReportSize(dayReport);
			dayReportList = dayReportService.queryInDayReport(dayReport, pageNo, pageSize);
		}else if("2".equals(flag)){
			recordCount = dayReportService.queryOutDayReportSize(dayReport);
			dayReportList = dayReportService.queryOutDayReport(dayReport, pageNo, pageSize);
		}else{
			recordCount = dayReportService.queryDayReportSize(dayReport);
			dayReportList = dayReportService.queryDayReport(dayReport, pageNo, pageSize);
		}
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		
		if("1".equals(flag)){
			return "queryInDayReport";
		}else if("2".equals(flag)){
			return "queryOutDayReport";
		}else{
			return "queryDayReport";
		}
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		if("1".equals(flag)){
			recordCount = dayReportService.queryInDayReportSize(dayReport);
			dayReportList = dayReportService.queryInDayReport(dayReport, ++pageNo, pageSize);
		}else if("2".equals(flag)){
			recordCount = dayReportService.queryOutDayReportSize(dayReport);
			dayReportList = dayReportService.queryOutDayReport(dayReport, ++pageNo, pageSize);
		}else{
			recordCount = dayReportService.queryDayReportSize(dayReport);
			dayReportList = dayReportService.queryDayReport(dayReport, ++pageNo, pageSize);
		}
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		if("1".equals(flag)){
			return "queryInDayReport";
		}else if("2".equals(flag)){
			return "queryOutDayReport";
		}else{
			return "queryDayReport";
		}
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		if("1".equals(flag)){
			recordCount = dayReportService.queryInDayReportSize(dayReport);
			dayReportList = dayReportService.queryInDayReport(dayReport, --pageNo, pageSize);
		}else if("2".equals(flag)){
			recordCount = dayReportService.queryOutDayReportSize(dayReport);
			dayReportList = dayReportService.queryOutDayReport(dayReport, --pageNo, pageSize);
		}else{
			recordCount = dayReportService.queryDayReportSize(dayReport);
			dayReportList = dayReportService.queryDayReport(dayReport, --pageNo, pageSize);
		}

		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		if("1".equals(flag)){
			return "queryInDayReport";
		}else if("2".equals(flag)){
			return "queryOutDayReport";
		}else{
			return "queryDayReport";
		}
	}
	
	public String exportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String filename = "";
		String fileModelUrl = request.getSession().getServletContext().getRealPath("/")+"DayReport.xls";
		if("1".equals(flag)){
			filename = "入库数量统计" + AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
		}else if("2".equals(flag)){
			filename = "出库数量统计" + AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
		}else{
			filename = "库存数量统计" + AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
		}
		
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		OutputStream os = response.getOutputStream();
 		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(filename.getBytes(), "UTF-8"));
		response.setContentType("application/msexcel");
		POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(fileModelUrl));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheet("报表统计");
		HSSFRow row=null;
		int i=0;
		if("1".equals(flag)){
			dayReportList = dayReportService.queryAllInDayReport(dayReport);
		}else if("2".equals(flag)){
			dayReportList = dayReportService.queryAllOutDayReport(dayReport);
		}else{
//			dayReportList = dayReportService.queryAllDayReport(dayReport);
		}
	    
		for (DayReport s: dayReportList) {
			row = sheet.getRow((int) i + 1);
			row.getCell(0).setCellValue(s.getReportDay());
			row.getCell(1).setCellValue(s.getSum0());
			row.getCell(2).setCellValue(s.getSum1());
			row.getCell(3).setCellValue(s.getSum2());
			row.getCell(4).setCellValue(s.getSum3());
			row.getCell(3).setCellValue(s.getSum4());
			row.getCell(4).setCellValue(s.getSum5());
			i++;
		}
		try {
			wb.write(os);
			fs.close();
			os.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(String barcodes) {
		this.barcodes = barcodes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public DayReport getDayReport() {
		return dayReport;
	}

	public void setDayReport(DayReport dayReport) {
		this.dayReport = dayReport;
	}

	public DayReportService getDayReportService() {
		return dayReportService;
	}

	public void setDayReportService(DayReportService dayReportService) {
		this.dayReportService = dayReportService;
	}

	public List<DayReport> getDayReportList() {
		return dayReportList;
	}

	public void setDayReportList(List<DayReport> dayReportList) {
		this.dayReportList = dayReportList;
	}

}
