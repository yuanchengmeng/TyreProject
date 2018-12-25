package com.kexun.wm.store.action;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;
import com.kexun.wm.store.bean.StoreStatisVo;
import com.kexun.wm.store.service.StatisManageService;
import com.kexun.wm.store.service.impl.StatisManageServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.opensymphony.xwork2.ActionContext;


/**
 * 统计管理
 * @author Administrator
 *
 */
public class StatisManageAction {
	StatisManageService statisManageService = new StatisManageServiceImpl();
	private String flag = "";
	private int pageNo = 1;
	private int pageCount = 1;
	private int pageSize;
	private int recordCount;
	private StatisParams params = new StatisParams();
	private StoreStatisVo storeStatisVo = new StoreStatisVo();
	private List<StandardStatisVo> standardList;
	private List<PageSize> pageSizeList;
	
	public String queryStandardStatis() throws Exception {
		if("1".equals(flag) && StringUtils.isNotBlank(params.getPerson())){
			params.setPerson(URLDecoder.decode(params.getPerson(), "UTF-8"));
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		
		if(StringUtils.isBlank(params.getTimeStart())){
			params.setTimeStart(AllSelectItemUtil.getDateByDay(0));
		}
		if(StringUtils.isBlank(params.getTimeEnd())){
			params.setTimeEnd(AllSelectItemUtil.getNowTime());
		}
		recordCount = statisManageService.queryStandardStatisSize(params);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		standardList = statisManageService.queryStandardStatis(params, pageNo, pageSize);
		return "queryStandardStatis";
	}
	
	public String queryStoreAmount() throws Exception {
		if(StringUtils.isBlank(params.getTimeStart())){
			params.setTimeStart(AllSelectItemUtil.getDateByDay(0));
		}
		if(StringUtils.isBlank(params.getTimeEnd())){
			params.setTimeEnd(AllSelectItemUtil.getNowTime());
		}
		storeStatisVo = statisManageService.queryStoreAmount(params);
		return "queryStoreAmount";
	}
	
	public String exportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String fileModelUrl = request.getSession().getServletContext().getRealPath("/")+"standardStatis.xls";
		String filename = "规格统计 " + AllSelectItemUtil.defaultTime("yyyyMMddHHmmss") + ".xls";
			 
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		OutputStream os = response.getOutputStream();
 		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(filename.getBytes(), "UTF-8"));
		response.setContentType("application/msexcel");
		POIFSFileSystem fs=new POIFSFileSystem(new FileInputStream(fileModelUrl));
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheet("规格统计");
		HSSFRow row = sheet.getRow(0);
		row.getCell(0).setCellValue("时间："+params.getTimeStart() +"——"+params.getTimeEnd());
		if("1".equals(flag) && StringUtils.isNotBlank(params.getPerson())){
			params.setPerson(URLDecoder.decode(params.getPerson(), "UTF-8"));
		}
		List<StandardStatisVo> list = statisManageService.queryAllStandardStatis(params);
		int i=1;
		for (StandardStatisVo s: list) {
			row = sheet.getRow((int) i + 1);
			row.getCell(0).setCellValue(s.getStoreType());
			row.getCell(1).setCellValue(s.getProduct().getFName());
			row.getCell(2).setCellValue(s.getAmount());
			row.getCell(3).setCellValue(s.getPerson());
			row.getCell(4).setCellValue(s.getSysUser().getJobNo());
			row.getCell(5).setCellValue(s.getClasses());
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

	public StatisManageService getStatisManageService() {
		return statisManageService;
	}

	public void setStatisManageService(StatisManageService statisManageService) {
		this.statisManageService = statisManageService;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public StatisParams getParams() {
		return params;
	}

	public void setParams(StatisParams params) {
		this.params = params;
	}

	public List<StandardStatisVo> getStandardList() {
		return standardList;
	}

	public void setStandardList(List<StandardStatisVo> standardList) {
		this.standardList = standardList;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public StoreStatisVo getStoreStatisVo() {
		return storeStatisVo;
	}

	public void setStoreStatisVo(StoreStatisVo storeStatisVo) {
		this.storeStatisVo = storeStatisVo;
	}
	 
}
