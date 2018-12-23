package com.kexun.wm.sale.bean;

import java.sql.Date;

/*
 * 订单表
 */
public class SeOrderEntry {
	/**
	 * 
	 */
	private int FDetailID;// 主键
	private Date FAdviceConsignDate;// 建议交货日期
	private float FAmount; // 金额
	private float FAuxPrice; // 单价
	private float FAuxQty;// 数量
	private float FAuxStockQty;// //出库数量(辅助单位):
	private String FBatchNo; // 产品批号
	private float FBCommitQty;// //退货数量
	private int FBomInterID;// //批号/客户BOM
	private String FBrNo;// //公司机构内码
	private float FCommitQty;// //发货数量
	private Date FDate; // 交货日期
	private float FFinalAmount;// 折后金额
	// private int FInterID;// 订单内码
	private SeOrder seOrder;// 订单内码
	private float FInvoiceQty;// 发票数量
	// private int FItemID;// 产品代码
	private Product product;// 产品
	private String FMapName;// 对应名称
	private String FMapNumber;// 对应代码
	private float FPrice;// 单价
	private float FQty;// 基本单位数量
	private int FSourceEntryID;// 源单行号
	private float FStockQty;// 出库数量:
	private float FTax;//
	private float FTaxAmount;// 折扣额
	private float FTaxRate;// 折扣率(%)
	private int FUnitID;// 单位
	private int allBarcode;// 扫码数量

	public int getFDetailID() {
		return FDetailID;
	}

	public void setFDetailID(int fDetailID) {
		FDetailID = fDetailID;
	}

	public Date getFAdviceConsignDate() {
		return FAdviceConsignDate;
	}

	public void setFAdviceConsignDate(Date fAdviceConsignDate) {
		FAdviceConsignDate = fAdviceConsignDate;
	}

	public float getFAmount() {
		return FAmount;
	}

	public void setFAmount(float fAmount) {
		FAmount = fAmount;
	}

	public float getFAuxPrice() {
		return FAuxPrice;
	}

	public void setFAuxPrice(float fAuxPrice) {
		FAuxPrice = fAuxPrice;
	}

	public float getFAuxQty() {
		return FAuxQty;
	}

	public void setFAuxQty(float fAuxQty) {
		FAuxQty = fAuxQty;
	}

	public float getFAuxStockQty() {
		return FAuxStockQty;
	}

	public void setFAuxStockQty(float fAuxStockQty) {
		FAuxStockQty = fAuxStockQty;
	}

	public String getFBatchNo() {
		return FBatchNo;
	}

	public void setFBatchNo(String fBatchNo) {
		FBatchNo = fBatchNo;
	}

	public float getFBCommitQty() {
		return FBCommitQty;
	}

	public void setFBCommitQty(float fBCommitQty) {
		FBCommitQty = fBCommitQty;
	}

	public int getFBomInterID() {
		return FBomInterID;
	}

	public void setFBomInterID(int fBomInterID) {
		FBomInterID = fBomInterID;
	}

	public String getFBrNo() {
		return FBrNo;
	}

	public void setFBrNo(String fBrNo) {
		FBrNo = fBrNo;
	}

	public float getFCommitQty() {
		return FCommitQty;
	}

	public void setFCommitQty(float fCommitQty) {
		FCommitQty = fCommitQty;
	}

	public Date getFDate() {
		return FDate;
	}

	public void setFDate(Date fDate) {
		FDate = fDate;
	}

	public float getFFinalAmount() {
		return FFinalAmount;
	}

	public void setFFinalAmount(float fFinalAmount) {
		FFinalAmount = fFinalAmount;
	}

	public SeOrder getSeOrder() {
		return seOrder;
	}

	public void setSeOrder(SeOrder seOrder) {
 		this.seOrder = seOrder;
	}

	public float getFInvoiceQty() {
		return FInvoiceQty;
	}

	public void setFInvoiceQty(float fInvoiceQty) {
		FInvoiceQty = fInvoiceQty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getFMapName() {
		return FMapName;
	}

	public void setFMapName(String fMapName) {
		FMapName = fMapName;
	}

	public String getFMapNumber() {
		return FMapNumber;
	}

	public void setFMapNumber(String fMapNumber) {
		FMapNumber = fMapNumber;
	}

	public float getFPrice() {
		return FPrice;
	}

	public void setFPrice(float fPrice) {
		FPrice = fPrice;
	}

	public float getFQty() {
		return FQty;
	}

	public void setFQty(float fQty) {
		FQty = fQty;
	}

	public int getFSourceEntryID() {
		return FSourceEntryID;
	}

	public void setFSourceEntryID(int fSourceEntryID) {
		FSourceEntryID = fSourceEntryID;
	}

	public float getFStockQty() {
		return FStockQty;
	}

	public void setFStockQty(float fStockQty) {
		FStockQty = fStockQty;
	}

	public float getFTax() {
		return FTax;
	}

	public void setFTax(float fTax) {
		FTax = fTax;
	}

	public float getFTaxAmount() {
		return FTaxAmount;
	}

	public void setFTaxAmount(float fTaxAmount) {
		FTaxAmount = fTaxAmount;
	}

	public float getFTaxRate() {
		return FTaxRate;
	}

	public void setFTaxRate(float fTaxRate) {
		FTaxRate = fTaxRate;
	}

	public int getFUnitID() {
		return FUnitID;
	}

	public void setFUnitID(int fUnitID) {
		FUnitID = fUnitID;
	}

	public int getAllBarcode() {
		return allBarcode;
	}

	public void setAllBarcode(int allBarcode) {
		this.allBarcode = allBarcode;
	}
	
}
