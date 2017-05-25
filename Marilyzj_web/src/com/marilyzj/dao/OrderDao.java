package com.marilyzj.dao;

import java.util.List;

import com.marilyzj.model.Order;
import com.marilyzj.model.OrderRepair;
import com.marilyzj.model.UserOrder;

public interface OrderDao {
	//插入订单
	public abstract boolean insertOrder(Order order);
	public abstract boolean insertOrderUser(String orderId,String userId);
	public abstract boolean insertOrderRepair(String id,String orderId,String repairId);
	//获取全部订单
	public abstract List<Order> getAllOrders();
	//根据订单状态获取订单
	public abstract List<Order> getOrdersByType(String type);
	//获取订单详情id
	public abstract List<OrderRepair> getAllOrderInfo();
	//根据orderid获取订单详情
	public abstract OrderRepair getOrderRepairByOrderId(String orderId);
	//更改订单状态
	public abstract boolean changeType(String type,String orderId);
	//根据orderId获取Order
	public abstract Order getOrderById(String orderId);
	//获取所有用户订单
	public abstract List<UserOrder> getAllUserOrder(String userId);
	//根据orderid获取UserOrder
	public abstract UserOrder getUserOrderByOrderId(String orderId);
	//删除订单
	public abstract boolean deleteOrder(String orderId);
	//根据状态获取订单
	public abstract List<Order> getOrderInfoByType(String type);
}
