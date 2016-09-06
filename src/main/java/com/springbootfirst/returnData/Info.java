package com.springbootfirst.returnData;

import org.apache.commons.lang.StringUtils;

import com.springbootfirst.exception.StatusConstant;

/**
 * 
 * @author wangqiao
 * 		   wangzhiziqiao@163.com	
 *
 * @param <T>
 */
public class Info<T> {
	private String code = StatusConstant.OK;
	private String message = "返回正确的结果！";
	private T data;

	public Info() {
		super();
	}

	public Info(String code) {
		super();
		this.code = code;
	}

	public Info(String code, String message) {
		super();
		this.code = code;
		if (StatusConstant.OK.equals(code) && StringUtils.isEmpty(message)) {
			this.message = "返回正确的结果！";
		} else if (StatusConstant.ERROR.equals(code) && StringUtils.isEmpty(message)) {
			this.message = "返回错误的结果！";
		} else {
			this.message = message;
		}
	}

	public Info(String code, String message, T data) {
		super();
		this.code = code;
		if (StatusConstant.OK.equals(code) && StringUtils.isEmpty(message)) {
			this.message = "返回正确的结果！";
		} else if (StatusConstant.ERROR.equals(code) && StringUtils.isEmpty(message)) {
			this.message = "返回错误的结果！";
		} else {
			this.message = message;
		}
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
