package com.marilyzj.dao;

import java.util.List;

import com.marilyzj.model.DeptRepair;
import com.marilyzj.model.OrderRepair;
import com.marilyzj.model.RepairItems;

public interface RepairItemsDao {
	/**
	 * 维修项目处理模块
	 */
	//获取HomeList
	public abstract List<DeptRepair> getHomeList();
	//获取getDeptRepairByRepairId
	public abstract List<DeptRepair> getDeptRepairByRepairId(String repairId);
	//删除所有Homeist
	public abstract boolean deleteAllInfo();
	//获取所有的items
	public abstract List<RepairItems> getAllItems();
	//repairName
	public abstract List<RepairItems> getItemsByRepairName(String repairName);
	//根据id获取项目名
	public abstract RepairItems getItemById(String repairItemsId);
	//根据id获取详情
	public abstract DeptRepair getInfoById(String id);
	//根据deptid获取详情
	public abstract DeptRepair getInfoByDeptId(String deptId);
	//根据repairId获取详情
	public abstract DeptRepair getInfoByRepairId(String repairId);
	//获取deptRepair
	public abstract List<DeptRepair> getDeptRepair();
	
	
	public abstract boolean insertDeptReapir(DeptRepair deptRepair);
	
	public abstract OrderRepair getOrderRepairByOrderId(String repairItemsId);
}
