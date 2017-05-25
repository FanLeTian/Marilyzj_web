package com.marilyzj.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.marilyzj.dao.OrderDao;
import com.marilyzj.dao.impl.OrderDaoImpl;
import com.marilyzj.model.Order;

public class TestOrder {
	OrderDao od = new OrderDaoImpl();
//	@Test
//	public void insertOrder(){
//		for(int i=10;i<15;i++){
//			String var = String.valueOf(i);
//			Order order = new Order();
//			order.setOrderId(var);
//			order.setUserId(var);
//			order.setDeptId(var);
//			order.setOrderData(new Date());
//			order.setPayStatus(var);
//			order.setPrice(i*100);
//			od.insertOrder(order);
//		}
//	}
//	@Test
//	public void getAll(){
//		List<Order> orders = od.getAllOrders();
//		for(Order order:orders){
//			System.out.println(order);
//		}
//	}
	@Test
	public void change(){
		od.changeType("2", "11");
	}
}
