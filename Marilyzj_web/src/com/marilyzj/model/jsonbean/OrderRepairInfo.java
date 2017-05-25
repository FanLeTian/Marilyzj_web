package com.marilyzj.model.jsonbean;

import com.marilyzj.model.Dept;
import com.marilyzj.model.Order;
import com.marilyzj.model.RepairItems;

public class OrderRepairInfo {
	private Order order;
	private RepairItems repairItems;
	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public RepairItems getRepairItems() {
		return repairItems;
	}

	public void setRepairItems(RepairItems repairItems) {
		this.repairItems = repairItems;
	}

}
