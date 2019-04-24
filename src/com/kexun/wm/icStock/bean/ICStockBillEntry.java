package com.kexun.wm.icStock.bean;

import java.io.Serializable;

import com.kexun.wm.sale.bean.Product;


public class ICStockBillEntry  implements Serializable{
	private Integer FInterID;
	private Integer FEntryID;// 
	private Double FQty;//  
	private Product product;//
	public Integer getFInterID() {
		return FInterID;
	}
	public void setFInterID(Integer fInterID) {
		FInterID = fInterID;
	}
	public Integer getFEntryID() {
		return FEntryID;
	}
	public void setFEntryID(Integer fEntryID) {
		FEntryID = fEntryID;
	}
	public Double getFQty() {
		return FQty;
	}
	public void setFQty(Double fQty) {
		FQty = fQty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
