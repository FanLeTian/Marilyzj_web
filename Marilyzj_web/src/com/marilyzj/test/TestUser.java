package com.marilyzj.test;
import org.junit.Test;

import com.marilyzj.dao.UserDao;
import com.marilyzj.dao.impl.UserDaoImpl;
import com.marilyzj.model.User;
import com.marilyzj.utils.CommonUtils;


public class TestUser {
	UserDao ud=new UserDaoImpl();
	@Test
	public void addUser(){
		for(int i=0;i<10;i++){
			String val = String.valueOf(i);
			User user = new User();
			user.setUserId(CommonUtils.uuid());
			user.setUserName("我的姓名是"+val);
			user.setEmail(val+"@qq.com");
			user.setLoginName("loginName"+val);
			user.setPassword(val);
			user.setSex(val);
			boolean id = ud.insertUser(user);
			System.out.println(id);
		}
	}
//	@Test
//	public void getUser(){
//		
//		System.out.println("getUser:"+ud.getUser("loginName9"));
//	}
//	@Test
//	public void deleteUser(){
//		System.out.println("delete:"+ud.deleteUser("loginName9"));
//		System.out.println();
//	}
//	@Test
//	public void getIdByLoginName(){
//		System.out.println(ud.getIdByLoginName("222"));
//	}
	@Test
	public void getAdmin(){
		System.out.println(ud.getAdmin("admin"));
	}
}
