package com.kexun.wm.store.action;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.service.SeOrderService;
import com.kexun.wm.sale.service.VehicleService;
import com.kexun.wm.sale.service.impl.SeOrderServiceImpl;
import com.kexun.wm.sale.service.impl.VehicleServiceImpl;
import com.kexun.wm.store.bean.SpecMap;
import com.kexun.wm.store.bean.Store;
import com.kexun.wm.store.service.StoreService;
import com.kexun.wm.store.service.impl.StoreServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.bean.SysUser;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionContext;

import freemarker.template.utility.StringUtil;

public class StoreAction {
	private Store store = new Store();
	private StoreService storeService = new StoreServiceImpl();
	private SeOrderService seOrderService = new SeOrderServiceImpl();
	private VehicleService vehicleService = new VehicleServiceImpl();
	private SeOrderEntry seOrderEntry = new SeOrderEntry();
	private List<Store> storeList;
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private String flag;
	private List<PageSize> pageSizeList;
	private String ids;
	private int id;
	private String barcodes;
	private int productID;
	private String product;
	private String inMan;
	private String outMan;

	public Store transManCode(Store store,String manIn,String manOut) throws Exception {
		
		if(manIn != null && !("").equals(manIn)){
			try {
				manIn = new String(manIn.getBytes("ISO-8859-1"), "utf-8");
				store.setInMan(manIn);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if(manOut != null && !("").equals(manOut)){
			try {
				manOut = new String(manOut.getBytes("ISO-8859-1"), "utf-8");
				store.setOutMan(manOut);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return store;
	}
	
	public String queryStore() throws Exception {
		store=transManCode(store,inMan,outMan);
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		if (productID > 0) {
			store.setProductID(productID);
		}
		if ("2".equals(flag)) {
			if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
				int fInterId=seOrderService.getSeOrderIdByNo(store.getSeOrderEntry().getSeOrder().getFbillNo());
				if(fInterId>0){
					store.setOrderId(fInterId);
				}
			} //增加销售单号查询
			store.setStoreState("已出库");
			//查询车牌号
			if(StringUtils.isNotBlank(store.getCarNo())){
				String carIds = vehicleService.queryVehicleByNo(store.getCarNo());
				if(StringUtils.isNotBlank(carIds)){
					store.setCarIds(carIds);
				}
			}
		}
		if ("3".equals(flag)) {
			store.setStoreState("在库");
		}
		store = changeClass(store);
		recordCount = storeService.queryStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		storeList = storeService.queryStore(store, pageNo, pageSize);
		if ("2".equals(flag)) {
			for (int i = 0; i < storeList.size(); i++) {
					storeList.get(i).setSeOrderEntry(
							storeService.getSeOrderEntryById(storeList.get(i).getOrderId(),storeList.get(i).getProductID()));
			}
			return "queryOutStore";
		}
		if ("3".equals(flag)) {
			for (int i = 0; i < storeList.size(); i++) {
				storeList.get(i).setProduct(storeService.getProductById(storeList.get(i).getProductID()));
			}
			return "queryInStore";
		}
		return "queryStore";
	}

	public Store changeClass(Store store) throws Exception {
		if (store != null && store.getClassId() != null) {
			if (1 == store.getClassId()) {
				store.setInClass("甲班");
			}
			if (2 == store.getClassId()) {
				store.setInClass("乙班");
			}
			if (3 == store.getClassId()) {
				store.setInClass("丙班");
			}
		}
		return store;
	}

	public String nextPage() throws Exception {
		store=transManCode(store,inMan,outMan);
		if (productID > 0) {
			store.setProductID(productID);
		}
		if ("2".equals(flag)) {
			if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
				int fInterId=seOrderService.getSeOrderIdByNo(store.getSeOrderEntry().getSeOrder().getFbillNo());
				if(fInterId>0){
					store.setOrderId(fInterId);
				}
			} //增加销售单号查询
			
			store.setStoreState("已出库");
		}
		if ("3".equals(flag)) {
			store.setStoreState("在库");
		}
		store = changeClass(store);
		recordCount = storeService.queryStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		storeList = storeService.queryStore(store, ++pageNo, pageSize);
		if ("2".equals(flag)) {
			for (int i = 0; i < storeList.size(); i++) {
				storeList.get(i).setSeOrderEntry(
						storeService.getSeOrderEntryById(storeList.get(i).getOrderId(),storeList.get(i).getProductID()));
			}
			return "queryOutStore";
		}
		if ("3".equals(flag)) {
			for (int i = 0; i < storeList.size(); i++) {
//				storeList.get(i).setProduct(storeService.queryProductByBarCode(storeList.get(i).getBarcode()));
				storeList.get(i).setProduct(storeService.getProductById(storeList.get(i).getProductID()));
				
			}
			return "queryInStore";
		}
		return "queryStore";
	}

	public String queryOutStore() throws Exception {
		store=transManCode(store,inMan,outMan);
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		store = changeClass(store);
		recordCount = storeService.queryStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		storeList = storeService.queryStore(store, pageNo, pageSize);
		if ("first".equals(flag)) {
			return "queryMarketOutStore";
		}
		return "queryOutStore";
	}

	public String lastPage() throws Exception {
		store=transManCode(store,inMan,outMan);
		if (productID > 0) {
			store.setProductID(productID);
		}
		if ("2".equals(flag)) {
			if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
				int fInterId=seOrderService.getSeOrderIdByNo(store.getSeOrderEntry().getSeOrder().getFbillNo());
				if(fInterId>0){
					store.setOrderId(fInterId);
				}
			} //增加销售单号查询
			
			store.setStoreState("已出库");
		}
		if ("3".equals(flag)) {
			store.setStoreState("在库");
		}
		store = changeClass(store);
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = storeService.queryStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		storeList = storeService.queryStore(store, --pageNo, pageSize);
		if ("2".equals(flag)) {
			for (int i = 0; i < storeList.size(); i++) {
				storeList.get(i).setSeOrderEntry(
						storeService.getSeOrderEntryById(storeList.get(i).getOrderId(),storeList.get(i).getProductID()));
			}
			return "queryOutStore";
		}
		if ("3".equals(flag)) {
			for (int i = 0; i < storeList.size(); i++) {
//				storeList.get(i).setProduct(storeService.queryProductByBarCode(storeList.get(i).getBarcode()));
				storeList.get(i).setProduct(storeService.getProductById(storeList.get(i).getProductID()));
			}
			return "queryInStore";
		}
		return "queryStore";
	}

	public String getStoreById() throws Exception {
		store = storeService.getStoreById(store.getId());
//		store.setProduct(storeService.queryProductByBarCode(store.getBarcode()));
		store.setProduct(storeService.getProductById(store.getProductID()));
		if ("2".equals(flag)) {
			store.setSeOrderEntry(storeService.getSeOrderEntryById(store.getOrderId(),store.getProductID()));
			return "storeOut";
		}
		return "storeIn";
	}

	public String getStoreOutById() throws Exception {
		if ("1".equals(flag)) {
			store = storeService.getStoreById(store.getId());
			return "StoreModify";
		}
		if ("2".equals(flag)) {
			store = storeService.getStoreById(store.getId());
			return "StoreOutModify";
		}
		store = storeService.getStoreById(store.getId());
		if ("first".equals(flag)) {
			return "marketStoreOut";
		}
		return "StoreOut";
	}

	public String updateStore() throws Exception {
		store = storeService.getStoreById(store.getId());
		int result = storeService.updateStore(store);
		if (result == 1) {
			store = storeService.getStoreById(store.getId());
			return "queryStore";
		} else {
			ShowMessageUtil.showModifyFalse();
			return "false";
		}
	}

	public String deleteIn() throws Exception {
		
		store = changeClass(store);
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
			store = storeService.getStoreById(Integer.parseInt(id[i]));
			int n = 0;
			if (store.getInCode() != null) {
				n = storeService.getFCheckerID(store.getInCode());
			}
			if (n == 1 || store.getInCode() == null) {
				// 已审核
				int fInterID = storeService.getFInterID();
				if (fInterID == 0) {// 当天没有红字入库
					fInterID = storeService.createFInterID();
					String BillNo = storeService.createBillNo();
					SysUser user = AllSelectItemUtil.getCurrentUser();
					if (user == null) {
						return "501";
					}
					storeService.insertICStockBill(fInterID, user.getEmpID(),
							2, BillNo);
				}

				int fqty = storeService.getFQty(fInterID, store.getProductID());
				if (fqty > 0) {
					storeService.updateICStockBillEntry(fInterID,
							store.getProductID());
				} else {
					int fcount = storeService
							.getICStockBillEntryCount(fInterID);
					int loc = storeService.getDefaultLoc(store.getProductID());
					storeService.insertICStockBillEntry(fInterID, fcount,
							store.getProductID(), loc);
				}

			} else {
				storeService.updateICStockBillEntry(store.getInCode(),
						store.getProductID());
				// 未审核
			}
			result += storeService.deleteStore(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			store.setStoreState("在库");
			store=transManCode(store,inMan,outMan);
			recordCount = storeService.queryStoreSize(store);
			pageSizeList = AllSelectItemUtil.queryPageSize();
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			storeList = storeService.queryStore(store, pageNo, pageSize);
			for (int i = 0; i < storeList.size(); i++) {
//				storeList.get(i).setProduct(storeService.queryProductByBarCode(storeList.get(i).getBarcode()));
				storeList.get(i).setProduct(storeService.getProductById(storeList.get(i).getProductID()));
			}
			return "delete";
		} else {
			return "false";
		}
	}

	public String exportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		store=transManCode(store,inMan,outMan);
		store = changeClass(store);
		String filename = "";
		String fileModelUrl = request.getSession().getServletContext().getRealPath("/");
		if (productID > 0) {
			store.setProductID(productID);
		}
		if ("2".equals(flag)) {
			fileModelUrl+="outStore.xls";
			filename = "出库信息 "
					+ AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
			if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
				int fInterId=seOrderService.getSeOrderIdByNo(store.getSeOrderEntry().getSeOrder().getFbillNo());
				if(fInterId>0){
					store.setOrderId(fInterId);
				}
			} //增加销售单号查询
			
			store.setStoreState("已出库");
		}
		if ("3".equals(flag)) {
			fileModelUrl+="inStore.xls";
			filename = "库存信息 "
					+ AllSelectItemUtil.defaultTime("yyyyMMdd HHmmss") + ".xls";
			store.setStoreState("在库");
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
 		if ("2".equals(flag)) {
 			HSSFSheet sheet = wb.getSheet("出库表");
			HSSFRow row=null;
				int i=0;
				storeList = storeService.queryAllStore(store);
				for (Store s: storeList) {
					s.setSeOrderEntry(storeService.getSeOrderEntryById(s.getOrderId(),s.getProductID()));
					row = sheet.getRow((int) i + 1);
					row.getCell(0).setCellValue(s.getBarcode());
					if(s.getSeOrderEntry()!=null){
						row.getCell(1).setCellValue(s.getSeOrderEntry().getProduct().getFName());
						row.getCell(2).setCellValue(s.getSeOrderEntry().getSeOrder().getFbillNo());
						row.getCell(3).setCellValue(s.getSeOrderEntry().getSeOrder().getCustomer().getFName());
					}
					
					row.getCell(4).setCellValue(AllSelectItemUtil.formatTime("yyyy-MM-dd HH:mm:ss",s.getOutTime()));
					row.getCell(5).setCellValue(s.getOutMan());
					i++;
				}
		}
		if ("3".equals(flag)) {
			HSSFSheet sheet = wb.getSheet("库存表");
			HSSFRow row=null;
			int i=0;
		    storeList = storeService.queryAllStore(store);
			for (Store s: storeList) {
//				s.setProduct(storeService.queryProductByBarCode(s.getBarcode()));
				s.setProduct(storeService.getProductById(s.getProductID()));
				row = sheet.getRow((int) i + 1);
				row.getCell(0).setCellValue(s.getBarcode());
				row.getCell(1).setCellValue(s.getBoxCode());
				row.getCell(2).setCellValue(s.getProduct().getFName());
				row.getCell(3).setCellValue(AllSelectItemUtil.formatTime("yyyy-MM-dd HH:mm:ss",s.getInTime()));
				row.getCell(4).setCellValue(s.getInMan());
				row.getCell(5).setCellValue(s.getInClass());
				i++;
			}
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

	public Product queryProduct(String barCode) throws Exception {
		SpecMap specMap = storeService.querySpecMapByBarcode(barCode);
		Product product = storeService.queryProductBySpecMap(specMap);
		return product;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public StoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
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

	public SeOrderService getSeOrderService() {
		return seOrderService;
	}

	public void setSeOrderService(SeOrderService seOrderService) {
		this.seOrderService = seOrderService;
	}

	public SeOrderEntry getSeOrderEntry() {
		return seOrderEntry;
	}

	public void setSeOrderEntry(SeOrderEntry seOrderEntry) {
		this.seOrderEntry = seOrderEntry;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getInMan() {
		return inMan;
	}

	public void setInMan(String inMan) {
		this.inMan = inMan;
	}

	public String getOutMan() {
		return outMan;
	}

	public void setOutMan(String outMan) {
		this.outMan = outMan;
	}

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

}
