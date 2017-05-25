package com.marilyzj.dao.impl;

import java.util.List;

import com.marilyzj.dao.OrderDao;
import com.marilyzj.db.BaseDAO;
import com.marilyzj.model.Order;
import com.marilyzj.model.OrderRepair;
import com.marilyzj.model.UserOrder;

public class OrderDaoImpl extends BaseDAO<Order> implements OrderDao {

	@Override
	public boolean insertOrder(Order order) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO orders (orderId,deptId,userId,orderData,payStatus,price"
				+ ",phone,email,orderName,remark,userName) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		return insert(sql,order.getOrderId(), order.getDeptId(),
				order.getUserId(),order.getOrderData(),order.getPayStatus(),order.getPrice(),order.getPhone(),
				order.getEamil(),order.getOrderName(),order.getRemark(),
				order.getUserName());
	}

	@Override
	public List<Order> getAllOrders() {
		String sql="select * from orders";
		return getForList(Order.class, sql);
	}

	@Override
	public List<OrderRepair> getAllOrderInfo() {
		// TODO Auto-generated method stub
		String sql="select * from orderrepair";
		return getForList(OrderRepair.class, sql);
	}

	@Override
	public Order getOrderById(String orderId) {
		// TODO Auto-generated method stub
		String sql ="select * from orders where orderId=?";
		return get(Order.class, sql,orderId);
	}

	@Override
	public List<UserOrder> getAllUserOrder(String userId) {
		// TODO Auto-generated method stub
		String sql="select * from userorder where userId=?";
		return getForList(UserOrder.class, sql,userId);
	}

	@Override
	public OrderRepair getOrderRepairByOrderId(String orderId) {
		// TODO Auto-generated method stub
		String sql="select * from orderrepair where orderId=?";
		return get(OrderRepair.class,sql, orderId);
	}

	@Override
	public UserOrder getUserOrderByOrderId(String orderId) {
		// TODO Auto-generated method stub
		String sql="select * from userorder where orderId=?";
		return get(UserOrder.class,sql,orderId);
	}

	@Override
	public boolean deleteOrder(String orderId) {
		// TODO Auto-generated method stub
		String sql="delete from orders where orderId=?";
		update(sql, orderId);
		return true;
	}

	@Override
	public List<Order> getOrdersByType(String type) {
		// TODO Auto-generated method stub
		String sql="select * from orders where payStatus=?";
		return getForList(Order.class, sql,type);
	}

	@Override
	public boolean changeType(String type,String orderId) {
		// TODO Auto-generated method stub
		String sql="update orders set payStatus=? where orderId=?";
		update(sql, type,orderId);
		return true;
	}

	@Override
	public List<Order> getOrderInfoByType(String type) {
		// TODO Auto-generated method stub
		String sql="select * from orders where payStatus=?";
		return getForList(Order.class, sql, type);
	}

	@Override
	public boolean insertOrderUser(String orderId, String userId) {
		// TODO Auto-generated method stub
		String sql="insert into userorder (orderId,userId) VALUES(?,?)";
		return insert(sql, orderId,userId);
	}

	@Override
	public boolean insertOrderRepair(String id,String orderId, String repairId) {
		// TODO Auto-generated method stub
		String sql="insert into orderrepair (orderRepairId,orderId,repairItemsId) VALUES(?,?,?)";
		return insert(sql, id,orderId,repairId);
	}

}
