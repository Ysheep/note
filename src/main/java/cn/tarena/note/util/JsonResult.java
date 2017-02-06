package cn.tarena.note.util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
	private static final int SUCCESS = 0;
	private static final int ERROR = 1;
	
	private int state;
	private String msg = "";
	private T data;
	
	public JsonResult() {
		state = SUCCESS;
	}
	
	public JsonResult(int state, String msg, T data) {
		this.state = state;
		this.msg = msg;
		this.data = data;
	}
	
	public JsonResult(String error) {
		this(ERROR,error,null);
	}
	
	public JsonResult(T data) {
		this (SUCCESS,"",data);
	}
	
	public JsonResult(Throwable e) {
		this (ERROR,e.getMessage(),null);
	}
	
	public JsonResult(int state) {
		this(state,"",null);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
