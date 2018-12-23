package com.kexun.wm.sale.bean;

public class SaleAfter {
	private int id;
	private String barcode;
	private String product;//轮胎规格
	private String sperson;//销售客户
	private String lperson;//理赔客户
//	private int reason;//病象
//	private double rate;//赔率
	private String reason;//病象
	private String rate;//赔率
	private String remark;//备注
	private StatusAfter statusAfter;//状态
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSperson() {
		return sperson;
	}
	public void setSperson(String sperson) {
		this.sperson = sperson;
	}
	public String getLperson() {
		return lperson;
	}
	public void setLperson(String lperson) {
		this.lperson = lperson;
	}
//	public int getReason() {
//		return reason;
//	}
//	public void setReason(int reason) {
//		this.reason = reason;
//	}
//	public double getRate() {
//		return rate;
//	}
//	public void setRate(double rate) {
//		this.rate = rate;
//	}
	
	public String getRemark() {
		return remark;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public StatusAfter getStatusAfter() {
		return statusAfter;
	}
	public void setStatusAfter(StatusAfter statusAfter) {
		this.statusAfter = statusAfter;
	}
}
