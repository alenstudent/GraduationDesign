package com.aaron.framework.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.aaron.framework.model.ReturnCodeEnum;

/**
 * 基本异常类
 * @author aaron
 */
public abstract class BaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	protected String msg;
	protected int code = ReturnCodeEnum.NETWORK_ERROR.getCode();
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}


	
}
