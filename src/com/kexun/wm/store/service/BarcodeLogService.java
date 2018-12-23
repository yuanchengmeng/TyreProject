package com.kexun.wm.store.service;

import java.util.List;

import com.kexun.wm.store.bean.BarcodeLog;

public interface BarcodeLogService {
	public List<BarcodeLog> queryBarcodeLog(BarcodeLog barcodeLog, int pageNo, int pageSize) throws Exception;

	public int queryBarcodeLogSize(BarcodeLog barcodeLog) throws Exception;
}
