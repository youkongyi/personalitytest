package com.personalitytest.utils;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
	//版本序列号
	private static final long serialVersionUID = 1L;
	//状态
	private int state;
	//数据
	private T data;
	//信息
	private String message;
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
