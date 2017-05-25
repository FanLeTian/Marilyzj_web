package com.marilyzj.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.marilyzj.model.jsonbean.HomeListInfo;
import com.marilyzj.model.jsonbean.Msgs;
import com.marilyzj.model.jsonbean.Obj;
import com.marilyzj.servlet.BaseServlet;
import com.marilyzj.utils.Send;
import com.marilyzj.utils.StringUtils;

public class WebDept extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Logger LOG = (Logger) LoggerFactory
			.getLogger(WebDept.class);
	DeptDao dd = new DeptDaoImpl();
	Gson gson = new Gson();
	RepairItemsDao rd = new RepairItemsDaoImpl();

	/**
	 * 添加单位
	 * 
	 * @param request
	 * @param response
	 */
	public void insertDept(HttpServletRequest request,
			HttpServletResponse response) {
		// List<RepairItems> items = ud.getAllItems();
		// String result = gson.toJson(items);
		// LOG.info(result);
		// Send.SendJson(result, request, response);
	}

	/**
	 * 获取所有单位
	 * 
	 * @param request
	 * @param response
	 */
	public void getAllDept(HttpServletRequest request,
			HttpServletResponse response) {
		List<Dept> list = dd.getAllDept();
		String result = gson.toJson(list);
		LOG.info("getAllDept----" + result);
		Send.SendJson(result, request, response);
	}

	/**
	 * 根据地址获取单位
	 * 
	 * @param request
	 * @param response
	 */
	public void getDeptByAddress(String param, HttpServletRequest request,
			HttpServletResponse response) {
		String result = null;
		Msgs<HomeListInfo> msgs = new Msgs<HomeListInfo>();
		List<HomeListInfo> infos = new ArrayList<HomeListInfo>();
		if (StringUtils.isNotEmpty(param)) {
			List<Dept> list = dd.getDeptByAddress(param);
			
			for (int i = 0; i < list.size(); i++) {
				DeptRepair dr = rd.getInfoByDeptId(list.get(i).getDeptId());
				RepairItems deptRepair = rd.getItemById(dr.getRepairItemsId());
				HomeListInfo info = new HomeListInfo();
				info.setId(dr.getId());
				info.setRepairItemsId(deptRepair.getRepairItemsId());
				info.setRepairName(deptRepair.getRepairName());
				info.setPrice(deptRepair.getPrice());
				info.setDeptAddress(list.get(i).getDeptAddress());
				info.setDeptName(list.get(i).getDeptName());
				info.setDeptId(list.get(i).getDeptId());
				infos.add(info);
			}
			msgs.setCode("0");
			msgs.setMsg("获取成功");
			Obj<HomeListInfo> obj = new Obj<HomeListInfo>();
			obj.setReslut(infos);
			msgs.setObj(obj);
			result = gson.toJson(msgs);
			LOG.info("getDeptByAddress-----" + result);
			Send.SendJson(result, request, response);
		} else {
			msgs.setCode("0");
			msgs.setMsg("地址不能为空");
			msgs.setObj(null);
			result = gson.toJson(msgs);
			LOG.info("getDeptByAddress-----" + result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 根据级别获取单位
	 * 
	 * @param request
	 * @param response
	 */
	public void getDeptByLevel(HttpServletRequest request,
			HttpServletResponse response) {
		List<Dept> list = dd.getDeptByLevel();
		String result = gson.toJson(list);
		LOG.info("getDeptByLevel-----" + result);
		Send.SendJson(result, request, response);
	}

	/**
	 * 根据单位名获取单位信息
	 * 
	 * @param request
	 * @param response
	 */
	public void getDeptByName(String param, HttpServletRequest request,
			HttpServletResponse response) {
		String result = null;
		Msgs<HomeListInfo> msgs = new Msgs<HomeListInfo>();
		List<HomeListInfo> infos = new ArrayList<HomeListInfo>();
		if (StringUtils.isNotEmpty(param)) {
			List<Dept> list = dd.getDeptByName(param);
			for (int i = 0; i < list.size(); i++) {
				DeptRepair dr = rd.getInfoByDeptId(list.get(i).getDeptId());
				RepairItems deptRepair = rd.getItemById(dr.getRepairItemsId());
				HomeListInfo info = new HomeListInfo();
				info.setId(dr.getId());
				info.setRepairItemsId(deptRepair.getRepairItemsId());
				info.setRepairName(deptRepair.getRepairName());
				info.setPrice(deptRepair.getPrice());
				info.setDeptName(list.get(i).getDeptName());
				info.setDeptId(list.get(i).getDeptId());
				info.setDeptAddress(list.get(i).getDeptAddress());
				infos.add(info);
			}
			msgs.setCode("0");
			msgs.setMsg("获取成功");
			Obj<HomeListInfo> obj = new Obj<HomeListInfo>();
			obj.setReslut(infos);
			msgs.setObj(obj);
			result = gson.toJson(msgs);
			LOG.info("getDeptByName-----" + result);
			Send.SendJson(result, request, response);
		} else {
			msgs.setCode("0");
			msgs.setMsg("地址不能为空");
			msgs.setObj(null);
			result = gson.toJson(msgs);
			LOG.info("getDeptByName-----" + result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 获取单位的维修项目
	 * 
	 * @param request
	 * @param response
	 */
	public void getRepairItemsByDept(String param, HttpServletRequest request,
			HttpServletResponse response) {
		String result = null;
		Msgs<HomeListInfo> msgs = new Msgs<HomeListInfo>();
		List<HomeListInfo> infos = new ArrayList<HomeListInfo>();
		if (StringUtils.isNotEmpty(param)) {
			List<RepairItems> list = rd.getItemsByRepairName(param);
			for (int i = 0; i < list.size(); i++) {
				List<DeptRepair> deptRepairs = rd.getDeptRepairByRepairId(list.get(i).getRepairItemsId());
				for(DeptRepair deptRepair:deptRepairs){
					Dept dept = dd.getDeptById(deptRepair.getDeptsId());
					HomeListInfo info = new HomeListInfo();
					info.setId(deptRepair.getId());
					info.setRepairItemsId(deptRepair.getRepairItemsId());
					info.setRepairName(list.get(i).getRepairName());
					info.setPrice(list.get(i).getPrice());
					info.setDeptName(dept.getDeptName());
					info.setDeptAddress(dept.getDeptAddress());
					info.setDeptId(dept.getDeptId());
					infos.add(info);
				}
			}
			msgs.setCode("0");
			msgs.setMsg("获取成功");
			Obj<HomeListInfo> obj = new Obj<HomeListInfo>();
			obj.setReslut(infos);
			msgs.setObj(obj);
			result = gson.toJson(msgs);
			LOG.info("getRepairItemsByDept-----" + result);
			Send.SendJson(result, request, response);
		} else {
			msgs.setCode("0");
			msgs.setMsg("地址不能为空");
			msgs.setObj(null);
			result = gson.toJson(msgs);
			LOG.info("getRepairItemsByDept-----" + result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 搜索
	 * 
	 * @param request
	 * @param response
	 */
	public void getInfoByType(HttpServletRequest request,
			HttpServletResponse response) {
		String param = request.getParameter("param");
		String type = request.getParameter("type");
		Map<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(type)) {
			if ("0".equals(type)) {
				getDeptByAddress(param, request, response);
			} else if ("1".equals(type)) {
				getDeptByName(param, request, response);
			} else if ("2".equals(type)) {
				getRepairItemsByDept(param, request, response);
			} else if ("3".equals(type)) {
				getDeptByLevel(request, response);
			}
		} else {
			map.put("code", "0");
			map.put("msg", "type不能为空");
			String result = gson.toJson(map);
			LOG.info("getInfoByType-----" + result);
			Send.SendJson(result, request, response);
		}
	}
}
