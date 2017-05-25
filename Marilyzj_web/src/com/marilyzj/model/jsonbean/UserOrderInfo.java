package com.marilyzj.model.jsonbean;

import com.marilyzj.model.Order;
import com.marilyzj.model.User;

public class UserOrderInfo {
	private User user;
	private Order order;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
