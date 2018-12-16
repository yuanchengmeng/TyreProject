package com.kexun.wm.store.dao;

import java.util.List;

import com.kexun.wm.store.bean.BarcodeLog;

public interface BarcodeLogDao {
	// 库存信息
	public List<BarcodeLog> queryBarcodeLog(BarcodeLog barcodeLog, int pageNo, int pageSize) throws Exception;

	public int queryBarcodeLogSize(BarcodeLog barcodeLog) throws Exception;
	 
 
}
