package com.marilyzj.dao.impl;

import java.util.List;

import com.marilyzj.dao.DeptDao;
import com.marilyzj.db.BaseDAO;
import com.marilyzj.model.Dept;
import com.marilyzj.model.RepairItems;

public class DeptDaoImpl extends BaseDAO<Dept> implements DeptDao{

	@Override
	public List<Dept> getAllDept() {
		String sql="select * from depts";
		return getForList(Dept.class, sql);
	}

	@Override
	public List<Dept> getDeptByAddress(String address) {
		String sql="select * from depts where deptAddress like ?";
		return getForList(Dept.class, sql,"%"+address+"%");
	}

	@Override
	public List<Dept> getDeptByLevel() {
		String sql="select * from depts order by deptLevel";
		return getForList(Dept.class, sql);
	}

	@Override
	public List<Dept> getDeptByName(String Name) {
		String sql="select * from depts where deptName like ?";
		return getForList(Dept.class, sql, "%"+Name+"%");
	}

	@Override
	public List<RepairItems> getRepairItemsByDept(String deptName) {
		String sql="select * from repairitems where repairItemsId  in (select repairItemsId from depts where deptName =?) ";
		return getForList(RepairItems.class, sql, deptName);
	}

	@Override
	public boolean insertDept(Dept dept) {
		String sql="INSERT INTO depts (deptId,deptName,deptAddress,deptPhone,"
				+ "deptEmail,deptDesc,deptLevel,remark) VALUES (?,?,?,?,?,?,?,?)";
		return insert(sql, dept.getDeptId(),dept.getDeptName(),dept.getDeptAddress(),
				dept.getDeptPhone(),dept.getDeptEmail(),dept.getDeptDesc(),dept.getDeptLevel(),
				dept.getRemark());
	}

	@Override
	public Dept getDeptById(String Id) {
		// TODO Auto-generated method stub
		String sql= "select * from depts where deptId =?";
		return get(Dept.class, sql, Id);
	}

	

}
