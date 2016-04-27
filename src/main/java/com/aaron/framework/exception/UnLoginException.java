package com.aaron.framework.exception;

/**
 * 未登录异常
 * @author aaron
 *
 */
public class UnLoginException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnLoginException(String msg) {
		super();
		this.msg = msg;
	}

	public UnLoginException() {
		super();
	}
}
