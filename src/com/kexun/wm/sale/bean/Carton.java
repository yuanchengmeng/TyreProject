package com.kexun.wm.sale.bean;


public class Carton {

	private Integer id;
	private String cartonNo;
	private Vehicle vehicle;
	private Integer orderId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCartonNo() {
		return cartonNo;
	}
	public void setCartonNo(String cartonNo) {
		this.cartonNo = cartonNo;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	 
 }
