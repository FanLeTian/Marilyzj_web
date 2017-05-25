package com.marilyzj.model.jsonbean;

import java.util.List;


public class Rows {
	private String id;

	private List<String> cell;

	public List<String> getCell() {
		return cell;
	}

	public void setCell(List<String> cell) {
		this.cell = cell;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	
}
