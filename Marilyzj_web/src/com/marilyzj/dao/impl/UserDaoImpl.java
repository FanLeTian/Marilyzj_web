package com.marilyzj.dao.impl;

import com.marilyzj.dao.UserDao;
import com.marilyzj.db.BaseDAO;
import com.marilyzj.model.Admin;
import com.marilyzj.model.User;


public class UserDaoImpl extends BaseDAO<User> implements UserDao {

	@Override
	public User getUser(String loginName) {
		String sql="select *from user where loginName=?";
		return (User)get(User.class,sql,loginName);
	}
	
	@Override
	public boolean insertUser(User user) {
		String sql="INSERT INTO user (userId,userName,loginName,password,sex,"
				+ "phone,email,remark) VALUES" 
				+"(?,?,?,?,?,?,?,?)";
		return insert(sql,user.getUserId(),user.getUserName(),user.getLoginName(),user.getPassword(),user.getSex(),
				user.getPhone(),user.getEmail(),user.getRemark());
		
	}

	@Override
	public boolean updateUser(User user) {
	 String sql="update user set userName=?,loginName=?,sex=?,phone=?"
				+ ",email=?,remark=? where userId=?";
	 update(sql,user.getUserName(),user.getLoginName(),user.getSex(),
				user.getPhone(),user.getEmail(),user.getRemark(),user.getUserId());
	 return true;
	}

	@Override
	public boolean deleteUser(String loginName) {
		 String sql="delete from user where loginName=?";
		 update(sql,loginName);
		 return true;
	}

	@Override
	public User getUserById(String id) {
		String sql="select *from user where userId=?";
		return (User)get(User.class,sql,id);
	}

	@Override
	public String getIdByLoginName(String loginName) {
		String sql="select userId from user where loginName=?";
		return getForValue(sql,loginName);
	}

	@Override
	public Admin getAdmin(String adminName) {
		String sql="select * from admin where adminName=?";
		return get(Admin.class, sql, adminName);
	}

}
