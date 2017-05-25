package com.marilyzj.model.jsonbean;

import java.util.List;

public class Root {
	private String page;

	private int total;

	private String records;

	private List<Rows> rows;

	private Userdata userdata;

	public void setPage(String page) {
		this.page = page;
	}

	public String getPage() {
		return this.page;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return this.total;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public String getRecords() {
		return this.records;
	}

	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}

	public List<Rows> getRows() {
		return this.rows;
	}

	public void setUserdata(Userdata userdata) {
		this.userdata = userdata;
	}

	public Userdata getUserdata() {
		return this.userdata;
	}

}
