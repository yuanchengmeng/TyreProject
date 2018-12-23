package com.kexun.wm.sale.service;

import java.util.List;

import com.kexun.wm.sale.bean.SaleAfter;

public interface SaleAfterService {
	public int saveSaleAfter(SaleAfter saleAfter) throws Exception;

	public int deleteSaleAfter(int id) throws Exception;

	public int updateSaleAfter(SaleAfter saleAfter) throws Exception;

	public List<SaleAfter> querySaleAfter(SaleAfter saleAfter, int pageNo,
			int pageSize) throws Exception;

	public SaleAfter findSaleAfterById(int id) throws Exception;

	public int queryAllRows(SaleAfter saleAfter) throws Exception;

	public SaleAfter getSaleAfterByName(String name) throws Exception;

}
