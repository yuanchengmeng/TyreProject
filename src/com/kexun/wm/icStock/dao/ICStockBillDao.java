package com.kexun.wm.icStock.dao;

import java.util.List;

import com.kexun.wm.icStock.bean.ICStockBill;
import com.kexun.wm.icStock.bean.ICStockBillEntry;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:09:41
 */
public interface ICStockBillDao {

	public List<ICStockBill> queryOutStock(ICStockBill vo, int offset, int length) throws Exception;
  		
	public int getOutStockRows(ICStockBill vo) throws Exception;
	
	public List<ICStockBillEntry> getDetail(int FInterID) throws Exception;
}
