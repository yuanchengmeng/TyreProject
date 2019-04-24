package com.kexun.wm.icStock.bean;

import java.util.Date;

import com.kexun.wm.system.bean.K3User;


public class ICStockBill {
	private Integer FInterID;
	private String FBillNo;// 
	private Date FDate;//  
	private K3User k3User;//
	public Integer getFInterID() {
		return FInterID;
	}
	public void setFInterID(Integer fInterID) {
		FInterID = fInterID;
	}
	public String getFBillNo() {
		return FBillNo;
	}
	public void setFBillNo(String fBillNo) {
		FBillNo = fBillNo;
	}
	public Date getFDate() {
		return FDate;
	}
	public void setFDate(Date fDate) {
		FDate = fDate;
	}
	public K3User getK3User() {
		return k3User;
	}
	public void setK3User(K3User k3User) {
		this.k3User = k3User;
	}
}
