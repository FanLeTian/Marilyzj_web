package com.marilyzj.model.jsonbean;


public class HomeListInfo {
	private String id;
	private String repairItemsId;
	private String deptName;
	private String deptAddress;
	private String repairName;
	private String price;
	private String deptId;
	
	public String getDeptAddress() {
		return deptAddress;
	}
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getRepairItemsId() {
		return repairItemsId;
	}
	public void setRepairItemsId(String repairItemsId) {
		this.repairItemsId = repairItemsId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRepairName() {
		return repairName;
	}
	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
