package com.kexun.wm.store.service.impl;

import java.util.List;

import com.kexun.wm.store.bean.StoreReport;
import com.kexun.wm.store.dao.StoreReportDao;
import com.kexun.wm.store.dao.impl.StoreReportDaoImpl;
import com.kexun.wm.store.service.StoreReportService;

public class StoreReportServiceImpl implements StoreReportService {
	private StoreReportDao storeReportDao = new StoreReportDaoImpl();

    public List<StoreReport> queryInStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception{
    	return storeReportDao.queryInStoreReport(storeReport, pageNo, pageSize);
    }
	
	public List<StoreReport> queryOutStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception{
		return storeReportDao.queryOutStoreReport(storeReport, pageNo, pageSize);
	}
	
	public List<StoreReport> queryStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception{
		return storeReportDao.queryStoreReport(storeReport, pageNo, pageSize);
	}

	public int queryInStoreReportSize(StoreReport storeReport) throws Exception{
		return storeReportDao.queryInStoreReportSize(storeReport);
	}
	
	public int queryOutStoreReportSize(StoreReport storeReport) throws Exception{
		return storeReportDao.queryOutStoreReportSize(storeReport);
	}
	
	public int queryStoreReportSize(StoreReport storeReport) throws Exception{
		return storeReportDao.queryStoreReportSize(storeReport);
	}
	
    public List<StoreReport> queryAllInStoreReport(StoreReport storeReport) throws Exception{
    	return storeReportDao.queryAllInStoreReport(storeReport);
    }
	
	public List<StoreReport> queryAllOutStoreReport(StoreReport storeReport) throws Exception{
		return storeReportDao.queryAllOutStoreReport(storeReport);
	}
	
	public List<StoreReport> queryAllStoreReport(StoreReport storeReport) throws Exception{
		return storeReportDao.queryAllStoreReport(storeReport);
	}
}
