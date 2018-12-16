package com.kexun.wm.store.bean;

import com.kexun.wm.sale.bean.Product;

public class StoreReport {
	private Integer ProductID;
	
	private String storeClass;
	
	private Product product;
	
	private int collectCount;// 汇总数
	
	private String timeStart;
	
	private String timeEnd;
	// private String productName;// 查询规格型号

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public String getStoreClass() {
		return storeClass;
	}

	public void setStoreClass(String storeClass) {
		this.storeClass = storeClass;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

}
