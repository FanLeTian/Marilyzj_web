package com.marilyzj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.marilyzj.dao.OrderDao;
import com.marilyzj.dao.impl.OrderDaoImpl;
import com.marilyzj.model.Order;
import com.marilyzj.model.jsonbean.Root;
import com.marilyzj.model.jsonbean.Rows;
import com.marilyzj.model.jsonbean.Userdata;

public class OrderServlet extends BaseServlet{
	OrderDao od = new OrderDaoImpl();
	Gson gson = new Gson();
//	HistoryDao hd = new HistoryDaoImpl();
	protected  static  Logger LOG=LoggerFactory.getLogger(OrderServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Order> orders=od.getAllOrders();
		Root root = new Root();
		Userdata userdata = new Userdata();
		List<Rows> listRows = new ArrayList<Rows>();
		userdata.setAmount(3220);
		userdata.setName("Totals");
		userdata.setTax(342);
		userdata.setTotal(3564);
		for(Order order:orders){
			if(order.getPayStatus().equals("1")||order.getPayStatus().equals("2")){
				Rows rows = new Rows();
				rows.setId(order.getOrderId());
				List<String> list = new ArrayList<String>();
				list.add(order.getOrderId());
				list.add(order.getOrderName());
				list.add(order.getUserName());
				list.add(String.valueOf(order.getPrice()));
				list.add(order.getOrderData());
				if(order.getPayStatus().equals("1")){
					list.add("待确认");
				}else if(order.getPayStatus().equals("2")){
					list.add("预定中");
				}
				rows.setCell(list);
				listRows.add(rows);
			}
		}
		root.setPage("1");
		root.setRecords("13");
		root.setTotal(2);
		root.setRows(listRows);
		root.setUserdata(userdata);
		String result=gson.toJson(root);
		LOG.info(result);
		response.getWriter().write(result);
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//		String oper=request.getParameter("del");
		//1：待确认 。2.预定中；3：已完成；4.未订单  
		String oper=request.getParameter("oper");
		String orderId = request.getParameter("id");
		String payStatus = request.getParameter("payStatus");
//		Enumeration<String> maps=request.getParameterNames();
		if(oper.equals("edit")){
			od.changeType(payStatus, orderId);
		}
		LOG.info(od.getOrderById(orderId).toString());
	}
	
	/**
	 * 获取历史记录
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void getHistory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		List<Order> orders=od.getAllOrders();
		Root root = new Root();
		Userdata userdata = new Userdata();
		List<Rows> listRows = new ArrayList<Rows>();
		userdata.setAmount(3220);
		userdata.setName("Totals");
		userdata.setTax(342);
		userdata.setTotal(3564);
		for(Order order:orders){
			if(order.getPayStatus().equals("3")||order.getPayStatus().equals("4")){
				Rows rows = new Rows();
				rows.setId(order.getOrderId());
				List<String> list = new ArrayList<String>();
				list.add(order.getOrderId());
				list.add(order.getOrderName());
				list.add(order.getUserName());
				list.add(String.valueOf(order.getPrice()));
				list.add(order.getOrderData());
				if(order.getPayStatus().equals("3")){
					list.add("已完成");
				}else if(order.getPayStatus().equals("4")){
					list.add("取消订单");
				}
				rows.setCell(list);
				listRows.add(rows);
			}
		}
		root.setPage("1");
		root.setRecords("13");
		root.setTotal(2);
		root.setRows(listRows);
		root.setUserdata(userdata);
		String result=gson.toJson(root);
		LOG.info(result);
		response.getWriter().write(result);
	}
}
