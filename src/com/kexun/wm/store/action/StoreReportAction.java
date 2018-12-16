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

import com.kexun.wm.manage.bean.HandClass;
import com.kexun.wm.store.bean.StoreReport;
import com.kexun.wm.store.service.StoreReportService;
import com.kexun.wm.store.service.StoreService;
import com.kexun.wm.store.service.impl.StoreReportServiceImpl;
import com.kexun.wm.store.service.impl.StoreServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.opensymphony.xwork2.ActionContext;

public class StoreReportAction {
	private StoreReport storeReport =new StoreReport();
	private StoreReportService storeReportService = new StoreReportServiceImpl();
	private StoreService storeService = new StoreServiceImpl();
	private List<StoreReport> storeReportList;
	private List<HandClass> handClassList;
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
	
 	public String queryStoreReport() throws Exception {
		handClassList = AllSelectItemUtil.queryAllHandClass();
		String handClass="";
		if("0".equals(sign)){
			storeReport.setTimeStart(AllSelectItemUtil.getNowDay());
			storeReport.setTimeEnd(AllSelectItemUtil.getNowTime());
			handClass="甲班";
		}else{
			handClass = AllSelectItemUtil.getHandClassById(classId).getName();
		}
		storeReport.setStoreClass(handClass);
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		
		if("1".equals(flag)){
			recordCount = storeReportService.queryInStoreReportSize(storeReport);
			storeReportList = storeReportService.queryInStoreReport(storeReport, pageNo, pageSize);
		}else if("2".equals(flag)){
			recordCount = storeReportService.queryOutStoreReportSize(storeReport);
			storeReportList = storeReportService.queryOutStoreReport(storeReport, pageNo, pageSize);
		}else{
			recordCount = storeReportService.queryStoreReportSize(storeReport);
			storeReportList = storeReportService.queryStoreReport(storeReport, pageNo, pageSize);
		}
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		for(int i=0;i<storeReportList.size();i++){
			storeReportList.get(i).setProduct((storeService.getProductById(storeReportList.get(i).getProductID())));
		}
		
		if("1".equals(flag)){
			return "queryInStoreReport";
		}else if("2".equals(flag)){
			return "queryOutStoreReport";
		}else{
			return "queryStoreReport";
		}
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		handClassList = AllSelectItemUtil.queryAllHandClass();
		String handClass = AllSelectItemUtil.getHandClassById(classId).getName();
		storeReport.setStoreClass(handClass);
		if("1".equals(flag)){
			recordCount = storeReportService.queryInStoreReportSize(storeReport);
			storeReportList = storeReportService.queryInStoreReport(storeReport, ++pageNo, pageSize);
		}else if("2".equals(flag)){
			recordCount = storeReportService.queryOutStoreReportSize(storeReport);
			storeReportList = storeReportService.queryOutStoreReport(storeReport, ++pageNo, pageSize);
		}else{
			recordCount = storeReportService.queryStoreReportSize(storeReport);
			storeReportList = storeReportService.queryStoreReport(storeReport, ++pageNo, pageSize);
		}
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		for(int i=0;i<storeReportList.size();i++){
			storeReportList.get(i).setProduct((storeService.getProductById(storeReportList.get(i).getProductID())));
		}
		
		if("1".equals(flag)){
			return "queryInStoreReport";
		}else if("2".equals(flag)){
			return "queryOutStoreReport";
		}else{
			return "queryStoreReport";
		}
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		handClassList = AllSelectItemUtil.queryAllHandClass();
		String handClass = AllSelectItemUtil.getHandClassById(classId).getName();
		storeReport.setStoreClass(handClass);
		if("1".equals(flag)){
			recordCount = storeReportService.queryInStoreReportSize(storeReport);
			storeReportList = storeReportService.queryInStoreReport(storeReport, --pageNo, pageSize);
		}else if("2".equals(flag)){
			recordCount = storeReportService.queryOutStoreReportSize(storeReport);
			storeReportList = storeReportService.queryOutStoreReport(storeReport, --pageNo, pageSize);
		}else{
			recordCount = storeReportService.queryStoreReportSize(storeReport);
			storeReportList = storeReportService.queryStoreReport(storeReport, --pageNo, pageSize);
		}
		for(int i=0;i<storeReportList.size();i++){
			storeReportList.get(i).setProduct((storeService.getProductById(storeReportList.get(i).getProductID())));
		}

		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		if("1".equals(flag)){
			return "queryInStoreReport";
		}else if("2".equals(flag)){
			return "queryOutStoreReport";
		}else{
			return "queryStoreReport";
		}
	}
	
	public String exportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String filename = "";
		String fileModelUrl = request.getSession().getServletContext().getRealPath("/")+"StoreReport.xls";
		if("1".equals(flag)){
			filename = "入库报表统计" + AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
		}else if("2".equals(flag)){
			filename = "出库报表统计" + AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
		}else{
			filename = "库存报表统计" + AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
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
		String handClass = AllSelectItemUtil.getHandClassById(classId).getName();
		storeReport.setStoreClass(handClass);
		if("1".equals(flag)){
			storeReportList = storeReportService.queryAllInStoreReport(storeReport);
		}else if("2".equals(flag)){
			storeReportList = storeReportService.queryAllOutStoreReport(storeReport);
		}else{
			storeReportList = storeReportService.queryAllStoreReport(storeReport);
		}
	    
		for (StoreReport s: storeReportList) {
			s.setProduct(storeService.getProductById(s.getProductID()));
			row = sheet.getRow((int) i + 1);
			row.getCell(0).setCellValue(s.getStoreClass());
			row.getCell(1).setCellValue(s.getProduct().getFModel());
			row.getCell(2).setCellValue(s.getProduct().getFName());
			row.getCell(3).setCellValue(s.getCollectCount());
			row.getCell(4).setCellValue("条");
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

	public StoreReport getStoreReport() {
		return storeReport;
	}

	public void setStoreReport(StoreReport storeReport) {
		this.storeReport = storeReport;
	}

	public StoreReportService getStoreReportService() {
		return storeReportService;
	}

	public void setStoreReportService(StoreReportService storeReportService) {
		this.storeReportService = storeReportService;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public List<StoreReport> getStoreReportList() {
		return storeReportList;
	}

	public void setStoreReportList(List<StoreReport> storeReportList) {
		this.storeReportList = storeReportList;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public List<HandClass> getHandClassList() {
		return handClassList;
	}

	public void setHandClassList(List<HandClass> handClassList) {
		this.handClassList = handClassList;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

}
