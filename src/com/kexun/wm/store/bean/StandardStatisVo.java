package com.kexun.wm.store.bean;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.system.bean.SysUser;

/**
 * 规格统计vo
 * @author Administrator
 *
 */
public class StandardStatisVo {
	private int id;//库存类型
	private String storeType;//库存类型
	private String classes;//班次
    private String person;//操作员
    private SysUser sysUser;
	private Integer productID;//规格ID
	private Product product;//规格
	private Integer amount;//数量
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	 
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
