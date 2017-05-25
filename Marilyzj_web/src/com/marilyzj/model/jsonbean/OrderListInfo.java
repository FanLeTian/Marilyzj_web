package com.marilyzj.model.jsonbean;

import java.util.List;

public class OrderListInfo<T> {
	
	private String orderListType;
	private String userId;
	private List<T> reslut;
	public String getOrderListType() {
		return orderListType;
	}
	public void setOrderListType(String orderListType) {
		this.orderListType = orderListType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<T> getReslut() {
		return reslut;
	}
	public void setReslut(List<T> reslut) {
		this.reslut = reslut;
	}
	
}
