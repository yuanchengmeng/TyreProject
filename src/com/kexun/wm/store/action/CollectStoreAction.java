package com.kexun.wm.store.action;

import java.util.List;

import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.service.SeOrderService;
import com.kexun.wm.sale.service.impl.SeOrderServiceImpl;
import com.kexun.wm.store.bean.Store;
import com.kexun.wm.store.service.StoreService;
import com.kexun.wm.store.service.impl.StoreServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;

public class CollectStoreAction {
	private Store store =new Store();
	private StoreService storeService = new StoreServiceImpl();
	private SeOrderService seOrderService = new SeOrderServiceImpl();
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
	
	public String queryCollectStore() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		if("2".equals(flag)){
			store.setStoreState("已出库");
		}
		if("3".equals(flag)){
			store.setStoreState("在库");
		}
		recordCount = storeService.queryCollectStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		storeList = storeService.queryCollectStore(store, pageNo, pageSize);
		for(int i=0;i<storeList.size();i++){
			storeList.get(i).setProduct((storeService.getProductById(storeList.get(i).getProductID())));
			storeList.get(i).setCollectCount(storeService.queryCollectCount(storeList.get(i)));
		}
		
		if("2".equals(flag)){
			return "queryCollectOutStore";
		}
		if("3".equals(flag)){
			return "queryCollectInStore";
		}
		return "queryCollectStore";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		if("2".equals(flag)){
			store.setStoreState("已出库");
		}
		if("3".equals(flag)){
			store.setStoreState("在库");
		}
		recordCount = storeService.queryCollectStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		storeList = storeService.queryCollectStore(store, ++pageNo, pageSize);
		for(int i=0;i<storeList.size();i++){
			storeList.get(i).setProduct((storeService.getProductById(storeList.get(i).getProductID())));
			storeList.get(i).setCollectCount(storeService.queryCollectCount(storeList.get(i)));
		}
		
		if("2".equals(flag)){
			return "queryCollectOutStore";
		}
		if("3".equals(flag)){
			return "queryCollectInStore";
		}
		return "queryCollectStore";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageSize == 0) {
			pageSize = pageSizeList.get(1).getPsize();
		}
		if("2".equals(flag)){
			store.setStoreState("已出库");
		}
		if("3".equals(flag)){
			store.setStoreState("在库");
		}
		recordCount = storeService.queryCollectStoreSize(store);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		storeList = storeService.queryCollectStore(store, --pageNo, pageSize);
		for(int i=0;i<storeList.size();i++){
			storeList.get(i).setProduct((storeService.getProductById(storeList.get(i).getProductID())));
			storeList.get(i).setCollectCount(storeService.queryCollectCount(storeList.get(i)));
		}
		
		if("2".equals(flag)){
			return "queryCollectOutStore";
		}
		if("3".equals(flag)){
			return "queryCollectInStore";
		}
		return "queryCollectStore";
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

}
