package com.kexun.wm.icStock.service;

import java.util.List;

import com.kexun.wm.icStock.bean.ICStockBill;
import com.kexun.wm.page.PageBean;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:15:47
 */
public interface ICStockBillService {

	public List<ICStockBill> queryOutStock(ICStockBill vo, int offset, int length) throws Exception;
		
	public PageBean getOutStockRows(ICStockBill vo, int offset, int length) throws Exception;
}
