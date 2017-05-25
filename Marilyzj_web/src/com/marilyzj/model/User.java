package com.marilyzj.model;


public class User {
	private String userId;
	private String userName;
	private String password;
	private String loginName;
	private String sex;
	private String phone;
	private String email;
	private String remark;
	
	
	public User() {
		super();
	}
	public User(String userId, String userName, String password,
			String loginName, String sex, String phone, String email,
			String remark) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.loginName = loginName;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.remark = remark;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", loginName=" + loginName
				+ ", sex=" + sex + ", phone=" + phone + ", email=" + email
				+ ", remark=" + remark + "]";
	}
	
	
}
