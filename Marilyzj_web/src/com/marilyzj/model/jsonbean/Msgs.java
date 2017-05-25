package com.marilyzj.model.jsonbean;

public class Msgs<T> {
	private String code;
	private String msg;
	private Obj<T> obj;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Obj<T> getObj() {
		return obj;
	}
	public void setObj(Obj<T> obj) {
		this.obj = obj;
	}
}
