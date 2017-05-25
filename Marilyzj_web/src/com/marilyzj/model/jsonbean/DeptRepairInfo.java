package com.marilyzj.model.jsonbean;

import com.marilyzj.model.Dept;
import com.marilyzj.model.RepairItems;

public class DeptRepairInfo {
	private RepairItems repairItems;
	private Dept dept;
	public RepairItems getRepairItems() {
		return repairItems;
	}
	public void setRepairItems(RepairItems repairItems) {
		this.repairItems = repairItems;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
