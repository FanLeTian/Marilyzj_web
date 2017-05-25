package com.marilyzj.web;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.google.gson.Gson;
import com.marilyzj.dao.DeptDao;
import com.marilyzj.dao.RepairItemsDao;
import com.marilyzj.dao.impl.DeptDaoImpl;
import com.marilyzj.dao.impl.RepairItemsDaoImpl;
import com.marilyzj.model.Dept;
import com.marilyzj.model.DeptRepair;
import com.marilyzj.model.RepairItems;
import com.marilyzj.model.jsonbean.DeptRepairInfo;
import com.marilyzj.model.jsonbean.HomeListInfo;
import com.marilyzj.model.jsonbean.Msg;
import com.marilyzj.model.jsonbean.Msgs;
import com.marilyzj.model.jsonbean.Obj;
import com.marilyzj.servlet.BaseServlet;
import com.marilyzj.utils.Send;
import com.marilyzj.utils.StringUtils;

public class WebRepairItems extends BaseServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RepairItemsDao rd = new RepairItemsDaoImpl();
	DeptDao dd = new DeptDaoImpl();
	Gson gson = new Gson();
	protected static final Logger LOG = LoggerFactory.getLogger(WebRepairItems.class);
	
	/**
	 * 首页数据
	 * @param request
	 * @param response
	 */
	public void getHomeList(HttpServletRequest request, HttpServletResponse response){
		
		Msgs<HomeListInfo> msgs=new Msgs<HomeListInfo>();
		//
		List<HomeListInfo> infos =new ArrayList<HomeListInfo>();
		//获取所有列表
		List<DeptRepair> deptRepairs=rd.getHomeList();
		
		for(int i=0;i<deptRepairs.size();i++){
			LOG.info("getHomeList----"+deptRepairs.get(i).toString());
			//获取维修项目
			RepairItems deptRepair = rd.getItemById(deptRepairs.get(i).getRepairItemsId());
			//获取单位
			Dept dept = dd.getDeptById(deptRepairs.get(i).getDeptsId());
			//组装
			HomeListInfo info = new HomeListInfo();
			info.setId(deptRepairs.get(i).getId());
			info.setRepairItemsId(deptRepair.getRepairItemsId());
			info.setRepairName(deptRepair.getRepairName());
			info.setPrice(deptRepair.getPrice());
			info.setDeptAddress(dept.getDeptAddress());
			info.setDeptName(dept.getDeptName());
			info.setDeptId(dept.getDeptId());
			infos.add(info);
		}
		msgs.setCode("0");
		msgs.setMsg("获取成功");
		Obj<HomeListInfo> obj= new Obj<HomeListInfo>();
		obj.setReslut(infos);
		msgs.setObj(obj);
		String result =  gson.toJson(msgs);
		LOG.info("getHomeList----"+result);
		Send.SendJson(result, request, response);
	}
	
	/**
	 * 根据id获取详情
	 * @param request
	 * @param response
	 */
	public void getInfoById(HttpServletRequest request, HttpServletResponse response){
		String repairId = request.getParameter("repairid");
		Msg<DeptRepairInfo> msg=new Msg<DeptRepairInfo>();
		if(StringUtils.isNotEmpty(repairId)){
			DeptRepair deptRepair = rd.getInfoById(repairId);
			
			RepairItems item= rd.getItemById(deptRepair.getRepairItemsId());
			Dept dept = dd.getDeptById(deptRepair.getDeptsId());
			
			DeptRepairInfo info =new DeptRepairInfo();
			info.setDept(dept);
			info.setRepairItems(item);
			//获取所有列表
			msg.setCode("0");
			msg.setMsg("获取成功");	
			msg.setObj(info);
			String result =  gson.toJson(msg);
			LOG.info("getInfoById-----"+result);
			Send.SendJson(result, request, response);
		}else{
			msg.setCode("1");
			msg.setMsg("参数错误");
			msg.setObj(null);
			String result =  gson.toJson(msg);
			LOG.info("getInfoById-----"+result);
			Send.SendJson(result, request, response);
		}
	}
}
