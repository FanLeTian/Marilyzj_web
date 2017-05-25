package com.marilyzj.dao.impl;

import java.util.List;

import com.marilyzj.dao.RepairItemsDao;
import com.marilyzj.db.BaseDAO;
import com.marilyzj.model.DeptRepair;
import com.marilyzj.model.OrderRepair;
import com.marilyzj.model.RepairItems;

public class RepairItemsDaoImpl extends BaseDAO<RepairItems> implements RepairItemsDao{

	@Override
	public List<DeptRepair> getHomeList() {
//		String sql = "select repairName,price,deptName,repairitems.repairItemsId,deptId from repairItems left join depts on repairItems.repairItemsId=depts.repairItemsId";
		String sql="select * from deptrepair";
		return getForList(DeptRepair.class, sql);
	}
	@Override
	public boolean deleteAllInfo() {
		// TODO Auto-generated method stub
		String sql = "delete from info ";
		update(sql);
		return true;
	}

	@Override
	public List<RepairItems> getAllItems() {
		// TODO Auto-generated method stub
		String sql="select * from repairitems";
		return getForList(RepairItems.class, sql);
	}

	@Override
	public boolean insertDeptReapir(DeptRepair deptRepair) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO deptrepair (id,deptsId,repairItemsId) VALUES(?,?,?)";
		return insert(sql,deptRepair.getId(), deptRepair.getDeptsId(),deptRepair.getRepairItemsId());
	}

	@Override
	public RepairItems getItemById(String repairItemsId) {
		String sql="select *from repairitems where repairItemsId=?";
		return get(RepairItems.class, sql, repairItemsId);
	}

	@Override
	public List<DeptRepair> getDeptRepair() {
		// TODO Auto-generated method stub
		String sql="select * from deptrepair";
		return getForList(DeptRepair.class, sql);
	}

	@Override
	public DeptRepair getInfoById(String id) {
		String sql="select * from deptrepair where id=?";
		return get(DeptRepair.class, sql,id);
	}
	@Override
	public DeptRepair getInfoByDeptId(String deptId) {
		String sql="select * from deptrepair where deptsId=?";
		return get(DeptRepair.class, sql,deptId);
	}
	@Override
	public OrderRepair getOrderRepairByOrderId(String repairItemsId) {
		String sql="select * from orderrepair where repairItemsId=?";
		return get(OrderRepair.class,sql, repairItemsId);
	}
	@Override
	public DeptRepair getInfoByRepairId(String repairId) {
		String sql="select * from deptrepair where repairItemsId=?";
		return get(DeptRepair.class, sql,repairId);
	}
	@Override
	public List<RepairItems> getItemsByRepairName(String repairName) {
		String sql="select * from repairitems where repairName like ?";
		return getForList(RepairItems.class, sql,"%"+repairName+"%");
	}
	@Override
	public List<DeptRepair> getDeptRepairByRepairId(String repairId) {
		String sql="select * from deptrepair where repairItemsId= ?";
		return getForList(DeptRepair.class, sql,repairId);
	}

}
