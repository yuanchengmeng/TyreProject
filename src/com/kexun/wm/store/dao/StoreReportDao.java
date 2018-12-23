package com.kexun.wm.store.dao;

import java.util.List;

import com.kexun.wm.store.bean.StoreReport;

public interface StoreReportDao {

	public List<StoreReport> queryInStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception;
	
	public List<StoreReport> queryOutStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception;
	
	public List<StoreReport> queryStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception;
	
    public List<StoreReport> queryAllInStoreReport(StoreReport storeReport) throws Exception;
	
	public List<StoreReport> queryAllOutStoreReport(StoreReport storeReport) throws Exception;
	
	public List<StoreReport> queryAllStoreReport(StoreReport storeReport) throws Exception;

	public int queryInStoreReportSize(StoreReport storeReport) throws Exception;
	
	public int queryOutStoreReportSize(StoreReport storeReport) throws Exception;
	
	public int queryStoreReportSize(StoreReport storeReport) throws Exception;
}
