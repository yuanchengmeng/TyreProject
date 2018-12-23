package com.kexun.wm.store.service;

import java.util.List;

import com.kexun.wm.store.bean.DayReport;

public interface DayReportService {

public List<DayReport> queryInDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception;
	
	public List<DayReport> queryOutDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception;
	
	public List<DayReport> queryDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception;
	
    public List<DayReport> queryAllInDayReport(DayReport dayReport) throws Exception;
	
	public List<DayReport> queryAllOutDayReport(DayReport dayReport) throws Exception;
	
	public List<DayReport> queryAllDayReport(DayReport dayReport) throws Exception;
	
	public int queryInDayReportSize(DayReport dayReport) throws Exception;
	
	public int queryOutDayReportSize(DayReport dayReport) throws Exception;
	
	public int queryDayReportSize(DayReport dayReport) throws Exception;
}
