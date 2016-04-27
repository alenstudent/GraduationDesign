package com.aaron.framework.exception;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年3月18日 上午12:09:52
* 类说明：TODO
*/
public class DBException extends BaseException {


	private static final long serialVersionUID = 1L;
	public DBException(String msg) {
		super();
		this.msg = msg;
		this.code = 500;
	}

	public DBException(String msg, int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	
	public DBException() {
		super();
	}
}
