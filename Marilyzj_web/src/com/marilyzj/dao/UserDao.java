package com.marilyzj.dao;

import com.marilyzj.model.Admin;
import com.marilyzj.model.User;


public interface UserDao {
	/**
	 * 用户模块处理信息
	 */
	//获取管理员信息
	public abstract Admin getAdmin(String loginName);
	//通过昵称查找id
	public abstract String getIdByLoginName(String loginName);
	//根据id获取用户
	public abstract User getUserById(String userId);
	//根据昵称获取用户
	public abstract User getUser(String loginName);
	//插入用户
	public abstract boolean insertUser(User user);
	//更新信息
	public abstract boolean updateUser(User user);
	//根据昵称删除用户
	public abstract boolean deleteUser(String userId);
}
