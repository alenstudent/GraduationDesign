package com.aaron.framework.exception;

/**
 * 未知异常
 * @author aaron
 *
 */
public class UnKnowException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnKnowException(String msg) {
		super();
		this.msg = msg;
		
	}

	public UnKnowException() {
		super();
	}
}
