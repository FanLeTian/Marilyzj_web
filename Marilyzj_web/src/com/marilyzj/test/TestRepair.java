package com.marilyzj.test;

import java.util.List;

import org.junit.Test;

import com.marilyzj.dao.DeptDao;
import com.marilyzj.dao.RepairItemsDao;
import com.marilyzj.dao.impl.DeptDaoImpl;
import com.marilyzj.dao.impl.RepairItemsDaoImpl;
import com.marilyzj.model.Dept;
import com.marilyzj.model.DeptRepair;
import com.marilyzj.model.RepairItems;
import com.marilyzj.utils.CommonUtils;
import com.marilyzj.utils.StringUtils;

public class TestRepair {
	RepairItemsDao rd = new RepairItemsDaoImpl();
	DeptDao dd=new DeptDaoImpl();
	@Test
	public void getAll(){
//		List<DeptRepair> items = rd.getHomeList();
		List<RepairItems> items=rd.getAllItems();
		List<Dept> items1=dd.getAllDept();
		List<DeptRepair> dr = rd.getDeptRepair();
//		for(int i=0;i<items.size();i++){
//			if(!StringUtils.isNotEmpty(items.get(i).getId())){
//				items.get(i).setId(String.valueOf(i));
//				boolean flag =rd.insertInfo(items.get(i));
//			}
//		}
		
		System.out.println(items1);
		System.out.println(items);
		System.out.println(dr);
	}
//	@Test
//	public void deleteAll(){
//		rd.deleteAllInfo();
//	}
//	@Test
//	public void getParent(){
//		List<RepairItems> list =rd.getParentItems();
//		System.out.println(list);
//	}
//	@Test
//	public void getParent(){
//		List<RepairItems> list =rd.getChildItems(1);
//		System.out.println(list);
//	}
}
