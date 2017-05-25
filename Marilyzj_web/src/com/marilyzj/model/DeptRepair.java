package com.marilyzj.model;
/**
 * 单位维修
 *
 */
public class DeptRepair {
	private String Id;
	private String deptsId;
	private String repairItemsId;
	
	public DeptRepair() {
		super();
	}

	public DeptRepair(String id, String deptsId, String repairItemsId) {
		super();
		Id = id;
		this.deptsId = deptsId;
		this.repairItemsId = repairItemsId;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDeptsId() {
		return deptsId;
	}

	public void setDeptsId(String deptsId) {
		this.deptsId = deptsId;
	}

	public String getRepairItemsId() {
		return repairItemsId;
	}

	public void setRepairItemsId(String repairItemsId) {
		this.repairItemsId = repairItemsId;
	}

	@Override
	public String toString() {
		return "DeptRepair [Id=" + Id + ", deptsId=" + deptsId
				+ ", repairItemsId=" + repairItemsId + "]";
	}

}
