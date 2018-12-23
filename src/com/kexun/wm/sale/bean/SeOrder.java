package com.kexun.wm.sale.bean;

import java.io.Serializable;
import java.util.Date;
  
/*
 * 订单表
 */
public class SeOrder implements Serializable{
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	/**
	 * 
	 */
 	private int fareaPS;	//销售范围
	private int ftranType;	//单据类型
 	private int fbillerID;	//制单:
	private String fbillNo;	//编    号:
	private int fbrID;	//制单机构
//	private int fCustID;	//购货单位:
	private Customer customer;//购货单位
	private Date fdate;	//日期:
	private int fdeptID;	//部门:
	private int fempID;	//业务员:
	private int finterID;	//订单内码
	private int fmangerID;	//主管:
	private String fpOOrdBillNo;	//采购订单号:
	private int frelateBrID;	//订货机构:
	private int fsaleStyle;	//销售方式:
	private float allCount;	//订单数量:
	private float allMoney;	//订单金额:
	private int allBarcode;//扫码数量
	private String orderDate1;//订单开始日期 
	private String orderDate2;//订单结束日期
	private int carId;//车牌
	private String outMan;//出库人
	public int getFareaPS() {
		return fareaPS;
	}
	public void setFareaPS(int fareaPS) {
		this.fareaPS = fareaPS;
	}
	public int getFtranType() {
		return ftranType;
	}
	public void setFtranType(int ftranType) {
		this.ftranType = ftranType;
	}
	public int getFbillerID() {
		return fbillerID;
	}
	public void setFbillerID(int fbillerID) {
		this.fbillerID = fbillerID;
	}
	public String getFbillNo() {
		return fbillNo;
	}
	public void setFbillNo(String fbillNo) {
		this.fbillNo = fbillNo;
	}
	public int getFbrID() {
		return fbrID;
	}
	public void setFbrID(int fbrID) {
		this.fbrID = fbrID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public int getFdeptID() {
		return fdeptID;
	}
	public void setFdeptID(int fdeptID) {
		this.fdeptID = fdeptID;
	}
	public int getFempID() {
		return fempID;
	}
	public void setFempID(int fempID) {
		this.fempID = fempID;
	}
	public int getFinterID() {
		return finterID;
	}
	public void setFinterID(int finterID) {
		this.finterID = finterID;
	}
	public int getFmangerID() {
		return fmangerID;
	}
	public void setFmangerID(int fmangerID) {
		this.fmangerID = fmangerID;
	}
	public String getFpOOrdBillNo() {
		return fpOOrdBillNo;
	}
	public void setFpOOrdBillNo(String fpOOrdBillNo) {
		this.fpOOrdBillNo = fpOOrdBillNo;
	}
	public int getFrelateBrID() {
		return frelateBrID;
	}
	public void setFrelateBrID(int frelateBrID) {
		this.frelateBrID = frelateBrID;
	}
	public int getFsaleStyle() {
		return fsaleStyle;
	}
	public void setFsaleStyle(int fsaleStyle) {
		this.fsaleStyle = fsaleStyle;
	}
	public float getAllCount() {
		return allCount;
	}
	public void setAllCount(float allCount) {
		this.allCount = allCount;
	}
	public float getAllMoney() {
		return allMoney;
	}
	public void setAllMoney(float allMoney) {
		this.allMoney = allMoney;
	}
	public int getAllBarcode() {
		return allBarcode;
	}
	public void setAllBarcode(int allBarcode) {
		this.allBarcode = allBarcode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public String getOrderDate1() {
		return orderDate1;
	}
	public void setOrderDate1(String orderDate1) {
		this.orderDate1 = orderDate1;
	}
	public String getOrderDate2() {
		return orderDate2;
	}
	public void setOrderDate2(String orderDate2) {
		this.orderDate2 = orderDate2;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		SeOrder.serialVersionUID = serialVersionUID;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getOutMan() {
		return outMan;
	}
	public void setOutMan(String outMan) {
		this.outMan = outMan;
	}
	
 }
