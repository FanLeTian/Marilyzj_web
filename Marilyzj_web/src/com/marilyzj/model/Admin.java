package com.marilyzj.model;

/**
 *管理员
 */
public class Admin {
	private String id;
	private String adminName;
	private String password;
	private String remark;
	
	public Admin() {
		super();
	}

	public Admin(String id, String adminName, String password, String remark) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
		this.remark = remark;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminName=" + adminName + ", password="
				+ password + ", remark=" + remark + "]";
	}

}
