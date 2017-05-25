package com.marilyzj.test;

import java.util.List;

import org.junit.Test;

import com.marilyzj.dao.DeptDao;
import com.marilyzj.dao.impl.DeptDaoImpl;
import com.marilyzj.model.Dept;
import com.marilyzj.model.RepairItems;
import com.marilyzj.utils.CommonUtils;

public class TestDept {
	DeptDao dd=new DeptDaoImpl();
//	@Test
//	public void insertDept(){
//		for(int i=0;i<10;i++){
//			Dept dept = new Dept();
//			String uuid = CommonUtils.uuid();
//			dept.setDeptId(uuid);
//			dept.setDeptName("dept"+i);
//			dept.setDeptLevel(i);
//			dept.setDeptAddress("dept"+i);
//			boolean flag =dd.insertDept(dept);
//			System.out.println(flag);
//		}
//	}
//	@Test
//	public void getAllDept(){
//		List<Dept> list = dd.getAllDept();
//		System.out.println(list);
//	}
//	@Test
//	public void getDeptByAddress(){
//		List<Dept> list = dd.getDeptByAddress("唐");
//		System.out.println(list);
//	}
//	@Test
//	public void getDeptByAddress(){
//		List<Dept> list = dd.getDeptByLevel();
//		System.out.println(list);
//	}
//	@Test
//	public void getDeptByName(){
//		List<Dept> list = dd.getDeptByName("陕西");
//		System.out.println(list);
//	}
//	@Test
//	public void getRepairItemsByDept(){
//		List<RepairItems> list = dd.getRepairItemsByDept("陕西4s");
//		System.out.println(list);
//	}
}
