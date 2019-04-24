package com.kexun.wm.icStock.action;

import java.util.List;

import com.kexun.wm.icStock.bean.ICStockBill;
import com.kexun.wm.icStock.bean.ICStockBillEntry;
import com.kexun.wm.icStock.service.ICStockBillService;
import com.kexun.wm.icStock.service.impl.ICStockBillServiceImpl;
import com.kexun.wm.page.PageBean;

public class ICStockBillAction {
	private ICStockBillService service = new ICStockBillServiceImpl();
	private ICStockBill vo;
	private List<ICStockBill> outStockList;
	private List<ICStockBillEntry> detailList;
	private PageBean pageBean;
	private int pageNo;
	private int pageSize;
	
	public String queryOutStock() throws Exception {
		pageBean = service.getOutStockRows(vo, pageNo, pageSize);
		outStockList = service.queryOutStock(vo, pageNo, pageSize);
		return "queryOutStock";
	}
	
	public String getDetail() throws Exception {
		detailList = service.getDetail(vo);
		return "getDetail";
	}
	
	

	public ICStockBillService getService() {
		return service;
	}

	public void setService(ICStockBillService service) {
		this.service = service;
	}

	public ICStockBill getVo() {
		return vo;
	}

	public void setVo(ICStockBill vo) {
		this.vo = vo;
	}

	public List<ICStockBill> getOutStockList() {
		return outStockList;
	}

	public void setOutStockList(List<ICStockBill> outStockList) {
		this.outStockList = outStockList;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<ICStockBillEntry> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<ICStockBillEntry> detailList) {
		this.detailList = detailList;
	}
	
}
