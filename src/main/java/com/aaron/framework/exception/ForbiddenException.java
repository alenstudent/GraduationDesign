package com.aaron.framework.exception;

import com.aaron.framework.model.ReturnCodeEnum;

/**
 * 未登录异常
 * @author aaron
 *
 */
public class ForbiddenException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ForbiddenException(String msg) {
		super();
		this.msg = msg;
		this.code = ReturnCodeEnum.FORBIDDEN.getCode();
	}

	public ForbiddenException() {
		super();
		this.code = ReturnCodeEnum.FORBIDDEN.getCode();
		this.msg = ReturnCodeEnum.FORBIDDEN.getTips();
	}
}
