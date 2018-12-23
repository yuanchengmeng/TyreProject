package com.kexun.wm.store.service.impl;

import java.util.List;

import com.kexun.wm.store.bean.DayReport;
import com.kexun.wm.store.dao.DayReportDao;
import com.kexun.wm.store.dao.impl.DayReportDaoImpl;
import com.kexun.wm.store.service.DayReportService;

public class DayReportServiceImpl implements DayReportService {
	private DayReportDao dayReportDao = new DayReportDaoImpl();

    public List<DayReport> queryInDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception{
    	return dayReportDao.queryInDayReport(dayReport, pageNo, pageSize);
    }
	
	public List<DayReport> queryOutDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception{
		return dayReportDao.queryOutDayReport(dayReport, pageNo, pageSize);
	}
	
    public List<DayReport> queryAllInDayReport(DayReport dayReport) throws Exception{
    	return dayReportDao.queryAllInDayReport(dayReport);
    }
	
	public List<DayReport> queryAllOutDayReport(DayReport dayReport) throws Exception{
		return dayReportDao.queryAllOutDayReport(dayReport);
	}
	
	public int queryInDayReportSize(DayReport dayReport) throws Exception{
		return dayReportDao.queryInDayReportSize(dayReport);
	}
	
	public int queryOutDayReportSize(DayReport dayReport) throws Exception{
		return dayReportDao.queryOutDayReportSize(dayReport);
	}

	public List<DayReport> queryDayReport(DayReport dayReport, int pageNo,
			int pageSize) throws Exception {
		 
		return dayReportDao.queryDayReport(dayReport, pageNo, pageSize);
	}

	public List<DayReport> queryAllDayReport(DayReport dayReport)
			throws Exception {
		 
		return dayReportDao.queryAllDayReport(dayReport);
	}

	public int queryDayReportSize(DayReport dayReport) throws Exception {
		 
		return dayReportDao.queryDayReportSize(dayReport);
	}
}
