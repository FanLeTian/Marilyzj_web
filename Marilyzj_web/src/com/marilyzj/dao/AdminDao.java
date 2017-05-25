package com.marilyzj.dao;

import com.marilyzj.db.BaseDAO;
import com.marilyzj.model.Admin;

public class AdminDao extends BaseDAO<Admin>{
	public  void getAdmin(String username){
		String sql="select * from admin where username=?";
		get(Admin.class, sql, username);
	}
}
