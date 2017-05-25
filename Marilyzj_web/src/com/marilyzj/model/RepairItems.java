package com.marilyzj.model;

public class RepairItems {
	private String repairItemsId;
	private String repairName;
	private String price;
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String remark;
	public RepairItems() {
		super();
	}
	public RepairItems(String repairItemsId, String repairName, String remark) {
		super();
		this.repairItemsId = repairItemsId;
		this.repairName = repairName;
		this.remark = remark;
	}
	public String getRepairItemsId() {
		return repairItemsId;
	}
	public void setRepairItemsId(String repairItemsId) {
		this.repairItemsId = repairItemsId;
	}
	public String getRepairName() {
		return repairName;
	}
	public void setRepairName(String repairName) {
		this.repairName = repairName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "RepairItems [repairItemsId=" + repairItemsId + ", repairName="
				+ repairName + ", price=" + price + ", remark=" + remark + "]";
	}
	
	
}
