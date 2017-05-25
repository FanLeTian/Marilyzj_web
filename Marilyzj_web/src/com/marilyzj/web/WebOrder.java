package com.marilyzj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.google.gson.Gson;
import com.marilyzj.dao.DeptDao;
import com.marilyzj.dao.OrderDao;
import com.marilyzj.dao.RepairItemsDao;
import com.marilyzj.dao.UserDao;
import com.marilyzj.dao.impl.DeptDaoImpl;
import com.marilyzj.dao.impl.OrderDaoImpl;
import com.marilyzj.dao.impl.RepairItemsDaoImpl;
import com.marilyzj.dao.impl.UserDaoImpl;
import com.marilyzj.model.Dept;
import com.marilyzj.model.DeptRepair;
import com.marilyzj.model.Order;
import com.marilyzj.model.OrderRepair;
import com.marilyzj.model.RepairItems;
import com.marilyzj.model.UserOrder;
import com.marilyzj.model.jsonbean.Msg;
import com.marilyzj.model.jsonbean.Msgs;
import com.marilyzj.model.jsonbean.Obj;
import com.marilyzj.model.jsonbean.OrderListInfo;
import com.marilyzj.model.jsonbean.OrderRepairInfo;
import com.marilyzj.servlet.BaseServlet;
import com.marilyzj.utils.CommonUtils;
import com.marilyzj.utils.Send;
import com.marilyzj.utils.StringUtils;

public class WebOrder extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected static final Logger LOG = LoggerFactory.getLogger(WebOrder.class);
	OrderDao od = new OrderDaoImpl();
	RepairItemsDao rd = new RepairItemsDaoImpl();
	UserDao ud = new UserDaoImpl();
	Gson gson = new Gson();
	DeptDao dd = new DeptDaoImpl();
	/**
	 * 订单详情页数据
	 * 
	 * @param request
	 * @param response
	 */
	public void getOrderInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String orderId = request.getParameter("orderid");
		Msg<OrderRepairInfo> msgs = new Msg<OrderRepairInfo>();
		if (StringUtils.isNotEmpty(orderId)) {
			Order order = od.getOrderById(orderId);
			
			OrderRepair orderRepair = od.getOrderRepairByOrderId(orderId);
			String repairId = orderRepair.getRepairItemsId();
			
			RepairItems items = rd.getItemById(repairId);
			
			Dept dept = dd.getDeptById(order.getDeptId());
			OrderRepairInfo info = new OrderRepairInfo();
			
			info.setOrder(order);
			info.setRepairItems(items);
			info.setDept(dept);
			Obj<OrderRepairInfo> obj = new Obj<OrderRepairInfo>();

			obj.setObj(info);

			msgs.setCode("0");
			msgs.setMsg("获取成功");
			msgs.setObj(obj);
			String result = gson.toJson(msgs);
			LOG.info(result);
			Send.SendJson(result, request, response);
		} else {
			msgs.setCode("1");
			msgs.setMsg("参数错误");
			msgs.setObj(null);
			String result = gson.toJson(msgs);
			LOG.info("getOrderInfo---"+result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 订单列表数据
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("rawtypes")
	public void getAllOrderByUser(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = request.getParameter("userid");
		String type = request.getParameter("type");
		Msgs<OrderListInfo> msgs = new Msgs<OrderListInfo>();
		//http://localhost:8080/Marilyzj/OrderInfo?method=getAllOrderByUser&userid=1&type=0
		//0：所有订单。1：待确认 。2.预定中；3：已完成；4.取消订单  
		if (StringUtils.isNotEmpty(userId) & StringUtils.isNotEmpty(type)) {
			if (type.equals("0")) {
				List<UserOrder> uo = od.getAllUserOrder(userId);
				List<OrderRepairInfo> orderRapair = new ArrayList<OrderRepairInfo>();

				for (int i = 0; i < uo.size(); i++) {
					OrderRepairInfo orderRepairInfo = new OrderRepairInfo();
					String orderId = uo.get(i).getOrderId();
					Order order = od.getOrderById(orderId);

					OrderRepair orderrepair = od
							.getOrderRepairByOrderId(orderId);

					String repairId = orderrepair.getRepairItemsId();
					RepairItems item = rd.getItemById(repairId);

					orderRepairInfo.setOrder(order);
					orderRepairInfo.setRepairItems(item);

					orderRapair.add(orderRepairInfo);
				}
				OrderListInfo<OrderRepairInfo> orderList = new OrderListInfo<OrderRepairInfo>();
				orderList.setUserId(userId);
				orderList.setReslut(orderRapair);
				msgs.setCode("0");
				msgs.setMsg("获取成功");
				Obj<OrderListInfo> obj = new Obj<OrderListInfo>();
				obj.setObj(orderList);
				msgs.setObj(obj);
				String result = gson.toJson(msgs);
				LOG.info("getAllOrderByUser---------"+result);
				Send.SendJson(result, request, response);
			} else if (type.equals("1") || type.equals("2")||type.equals("3")||type.equals("4")) {
				List<UserOrder> uo = od.getAllUserOrder(userId);
				List<OrderRepairInfo> orderRapair = new ArrayList<OrderRepairInfo>();

				for (int i = 0; i < uo.size(); i++) {
					OrderRepairInfo orderRepairInfo = new OrderRepairInfo();
					String orderId = uo.get(i).getOrderId();
					Order order = od.getOrderById(orderId);
					if (order.getPayStatus().equals(type)) {
						OrderRepair orderrepair = od
								.getOrderRepairByOrderId(orderId);

						String repairId = orderrepair.getRepairItemsId();
						RepairItems item = rd.getItemById(repairId);

						orderRepairInfo.setOrder(order);
						orderRepairInfo.setRepairItems(item);

						orderRapair.add(orderRepairInfo);
					}
				}
				OrderListInfo<OrderRepairInfo> orderList = new OrderListInfo<OrderRepairInfo>();
				orderList.setUserId(userId);
				orderList.setOrderListType("1");
				orderList.setReslut(orderRapair);
				msgs.setCode("0");
				msgs.setMsg("获取成功");
				Obj<OrderListInfo> obj = new Obj<OrderListInfo>();
				obj.setObj(orderList);
				msgs.setObj(obj);
				String result = gson.toJson(msgs);
				LOG.info("getAllOrderByUser---------"+result);
				Send.SendJson(result, request, response);
			}
		} else {

			msgs.setCode("1");
			msgs.setMsg("参数错误");
			msgs.setObj(null);
			String result = gson.toJson(msgs);
			LOG.info("getAllOrderByUser---------"+result);
			Send.SendJson(result, request, response);
		}
	}
	/**
	 * 生成订单
	 * @param request
	 * @param response
	 */
	
	public void createOrder(HttpServletRequest request,
			HttpServletResponse response) {
		//localhost:8080/Marilyzj/OrderInfo?method=createOrder&userid=1&repairId=1&date=2017-09-09&username=jiachao
		//&phone=199&remark=00&email=jiachao@qq.com
		String userId = request.getParameter("userid");
		String id = request.getParameter("id");
		String date = request.getParameter("date");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String remark = request.getParameter("remark");
		String email = request.getParameter("email");
		Msg<Order> msg = new Msg<Order>();
		if(StringUtils.isNotEmpty(userId,id,date,username
				,phone)){
			Order order = new Order();
			DeptRepair dr = rd.getInfoById(id);
			Dept dept = dd.getDeptById(dr.getDeptsId());
			RepairItems re = rd.getItemById(dr.getRepairItemsId());
			order.setDeptId(dept.getDeptId());
			order.setOrderData(date);
			String orderId = CommonUtils.uuid();
			order.setOrderId(orderId);
			order.setOrderName(re.getRepairName());
			order.setPayStatus("1");
			order.setPrice(re.getPrice());
			order.setUserId(userId);
			order.setUserName(username);
			order.setEamil(email);
			order.setPhone(phone);
			order.setRemark(remark);
			od.insertOrder(order);
			od.insertOrderUser(orderId, userId);
			od.insertOrderRepair(CommonUtils.uuid(),orderId, re.getRepairItemsId());
			msg.setCode("0");
			msg.setMsg("获取成功");
			msg.setObj(order);
			String result = gson.toJson(msg);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}else {
			msg.setCode("1");
			msg.setMsg("参数错误");
			msg.setObj(null);
			String result = gson.toJson(msg);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}
		
	}
	
	/**
	 * 更改订单状态
	 * @param request
	 * @param response
	 */
	public void changeType(HttpServletRequest request,
			HttpServletResponse response) {
		//localhost:8080/Marilyzj/OrderInfo?method=changeType&orderid=1F228A6FA9CB4D68B8D2193D06B2BE10&type=3
		String orderId = request.getParameter("orderid");
		String type = request.getParameter("type");
		Msg<Order> msg = new Msg<Order>();
		if(StringUtils.isNotEmpty(orderId,type)){
			od.changeType(type, orderId);
			Order order = od.getOrderById(orderId);
			msg.setCode("0");
			msg.setMsg("获取成功");
			msg.setObj(order);
			String result = gson.toJson(msg);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}else {
			msg.setCode("1");
			msg.setMsg("参数错误");
			msg.setObj(null);
			String result = gson.toJson(msg);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}
		
	}
	/**
	 * 根据状态获取订单信息
	 * @param request
	 * @param response
	 */
	public void getOrderByType(HttpServletRequest request,
			HttpServletResponse response) {
		String userId=request.getParameter("userid");
		String type = request.getParameter("type");
		Msgs<Order> msgs = new Msgs<Order>();
		if(StringUtils.isNotEmpty(userId,type)){
			List<UserOrder> userOrders = od.getAllUserOrder(userId);
			List<Order> orders = new ArrayList<Order>();
			for(UserOrder userOrder:userOrders){
				Order order = od.getOrderById(userOrder.getOrderId());
				if(type.equals(order.getPayStatus())){
					orders.add(order);
				}
			}
			msgs.setCode("0");
			msgs.setMsg("获取成功");
			Obj<Order> obj = new Obj<Order>();
			obj.setReslut(orders);
			msgs.setObj(obj);
			String result = gson.toJson(msgs);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}else {
			msgs.setCode("1");
			msgs.setMsg("参数错误");
			msgs.setObj(null);
			String result = gson.toJson(msgs);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}
	}
}
