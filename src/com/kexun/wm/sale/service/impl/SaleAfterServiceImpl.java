package com.kexun.wm.sale.service.impl;

import java.util.List;

import com.kexun.wm.sale.bean.SaleAfter;
import com.kexun.wm.sale.dao.SaleAfterDao;
import com.kexun.wm.sale.dao.impl.SaleAfterDaoImpl;
import com.kexun.wm.sale.service.SaleAfterService;

public class SaleAfterServiceImpl  implements SaleAfterService{
    private SaleAfterDao dao=new SaleAfterDaoImpl();
	public int saveSaleAfter(SaleAfter saleAfter) throws Exception {
		// TODO Auto-generated method stub
		return dao.saveSaleAfter(saleAfter);
	}

	public int deleteSaleAfter(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteSaleAfter(id);
	}

	public int updateSaleAfter(SaleAfter saleAfter) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateSaleAfter(saleAfter);
	}

	public List<SaleAfter> querySaleAfter(SaleAfter saleAfter, int pageNo,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return dao.querySaleAfter(saleAfter, pageNo, pageSize);
	}

	public SaleAfter findSaleAfterById(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.findSaleAfterById(id);
	}

	public int queryAllRows(SaleAfter saleAfter) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryAllRows(saleAfter);
	}

	public SaleAfter getSaleAfterByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.getSaleAfterByName(name);
	}
}
