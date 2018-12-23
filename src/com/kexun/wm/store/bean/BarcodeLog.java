package com.kexun.wm.store.bean;

import com.kexun.wm.sale.bean.SeOrder;


public class BarcodeLog {
	private Integer id;
	private String remark;// 
	private String logTime;//  
	private String logTime1;//查询用，开始时间  
	private String logTime2;// 查询用，结束时间
	private String logMan; 
	private Store store;//  
	private String orderNo;
	private SeOrder seOrder;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}

	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getLogMan() {
		return logMan;
	}
	public void setLogMan(String logMan) {
		this.logMan = logMan;
	}
	public SeOrder getSeOrder() {
		return seOrder;
	}
	public void setSeOrder(SeOrder seOrder) {
		this.seOrder = seOrder;
	}
	public String getLogTime1() {
		return logTime1;
	}
	public void setLogTime1(String logTime1) {
		this.logTime1 = logTime1;
	}
	public String getLogTime2() {
		return logTime2;
	}
	public void setLogTime2(String logTime2) {
		this.logTime2 = logTime2;
	}

}
