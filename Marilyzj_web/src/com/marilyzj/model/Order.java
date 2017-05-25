package com.marilyzj.model;


public class Order {

	private String orderId;
	private String deptId;
	private String userId;
	private String userName;
	private String orderName;
	private String orderData;
	private String payStatus;
	private String price;
	private String phone;
	private String eamil;
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	private String remark;

	public Order() {
		super();
	}

	public Order(String orderId, String deptId, String userName, String orderData,
			String payStatus, String price, String remark) {
		super();
		this.orderId = orderId;
		this.deptId = deptId;
		this.userName = userName;
		this.orderData = orderData;
		this.price = price;
		this.remark = remark;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderData() {
		return orderData;
	}

	public void setOrderData(String orderData) {
		this.orderData = orderData;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", deptId=" + deptId + ", userName="
				+ userName + ", orderData=" + orderData + ", payStatus="
				+ payStatus + ", price=" + price + ", remark=" + remark + "]";
	}

}
