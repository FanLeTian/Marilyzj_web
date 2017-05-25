package com.marilyzj.model;

import java.util.List;
/**
 * 单位
 *
 */
public class Dept {
	private String deptId;
	private String deptName;
	private String deptAddress;
	private String deptPhone;
	private String deptEmail;
	private String deptDesc;
	private Integer deptLevel;
	private String remark;
	
	private List<RepairItems> items;
	
	public Dept() {
		super();
	}

	public Dept(String deptId, String deptName, String deptAddress,
			String deptPhone, String deptEmail, String deptDesc,
			Integer deptLevel, String remark) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptAddress = deptAddress;
		this.deptPhone = deptPhone;
		this.deptEmail = deptEmail;
		this.deptDesc = deptDesc;
		this.deptLevel = deptLevel;
		this.remark = remark;
	}
	public List<RepairItems> getItems() {
		return items;
	}

	public void setItems(List<RepairItems> items) {
		this.items = items;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptAddress() {
		return deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	public String getDeptPhone() {
		return deptPhone;
	}

	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}

	public String getDeptEmail() {
		return deptEmail;
	}

	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public Integer getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName
				+ ", deptAddress=" + deptAddress + ", deptPhone=" + deptPhone
				+ ", deptEmail=" + deptEmail + ", deptDesc=" + deptDesc
				+ ", deptLevel=" + deptLevel + ", remark=" + remark + "]";
	}

}
