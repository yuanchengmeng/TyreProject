package com.kexun.wm.store.service.impl;

import java.util.List;

import com.kexun.wm.store.bean.BarcodeLog;
import com.kexun.wm.store.dao.BarcodeLogDao;
import com.kexun.wm.store.dao.impl.BarcodeLogDaoImpl;
import com.kexun.wm.store.service.BarcodeLogService;

public class BarcodeLogServiceImpl implements BarcodeLogService {
	private BarcodeLogDao dao = new BarcodeLogDaoImpl();

	public List<BarcodeLog> queryBarcodeLog(BarcodeLog barcodeLog, int pageNo, int pageSize) throws Exception{
		return dao.queryBarcodeLog(barcodeLog, pageNo, pageSize);
	}

	public int queryBarcodeLogSize(BarcodeLog barcodeLog) throws Exception{
		return dao.queryBarcodeLogSize(barcodeLog);
	}
}
