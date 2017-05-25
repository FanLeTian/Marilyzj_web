package com.marilyzj.dao;

import java.util.List;

import com.marilyzj.model.Dept;
import com.marilyzj.model.RepairItems;

public interface DeptDao {
	/**
	 * 维修单位处理信息
	 */
	//查询所有单位
	public abstract List<Dept> getAllDept();
	//根据地址查找单位
	public abstract List<Dept> getDeptByAddress(String address);
	//根据级别查找单位
	public abstract List<Dept> getDeptByLevel();
	//根据id查找单位
	public abstract Dept getDeptById(String Id);
	//根据名字查找单位
	public abstract List<Dept> getDeptByName(String Name);
	//查找单位的维修项目
	public abstract List<RepairItems> getRepairItemsByDept(String deptName);
	//增加单位
	public abstract boolean insertDept(Dept dept);
}
