package com.marilyzj.model.jsonbean;

import java.util.List;

public class Obj<T> {
	private T obj;
	private List<T> reslut;
	
	public void setReslut(List<T> reslut) {
		this.reslut = reslut;
	}

	public List<T> getReslut() {
		return reslut;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}
