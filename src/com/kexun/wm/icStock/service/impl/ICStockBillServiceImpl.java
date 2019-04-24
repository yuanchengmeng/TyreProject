package com.kexun.wm.icStock.service.impl;

import java.util.List;

import com.kexun.wm.icStock.bean.ICStockBill;
import com.kexun.wm.icStock.dao.ICStockBillDao;
import com.kexun.wm.icStock.dao.impl.ICStockBillDaoImpl;
import com.kexun.wm.icStock.service.ICStockBillService;
import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:16:46
 */
public class ICStockBillServiceImpl implements ICStockBillService {

	private ICStockBillDao dao = new ICStockBillDaoImpl();

	public List<ICStockBill> queryOutStock(ICStockBill vo, int pageNo, int pageSize) throws Exception {
		List<PageSize> pageSizeList = AllSelectItemUtil.queryPageSize();
		if (pageNo == 0) {
			pageNo = 1;
			pageSize = pageSizeList.get(1).getPsize();
		}
		List<ICStockBill> list = dao.queryOutStock(vo, pageNo, pageSize);
		return list;
	}

	public PageBean getOutStockRows(ICStockBill vo, int pageNo, int pageSize) throws Exception {
		PageBean pageBean = new PageBean();
		int pageCount = 0;
		List<PageSize> pageSizeList = AllSelectItemUtil.queryPageSize();
		int rows = dao.getOutStockRows(vo);
		if (pageNo == 0) {
			pageNo = 1;
			pageSize = pageSizeList.get(1).getPsize();
		}
		pageCount = (rows + pageSize - 1) / pageSize;
		
		pageBean.setAllRow(rows);
		pageBean.setList(pageSizeList);
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(pageNo);
		pageBean.setTotalPage(pageCount);
		return pageBean;
	}
	 
}
