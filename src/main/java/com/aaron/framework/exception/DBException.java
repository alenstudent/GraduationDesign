package com.aaron.framework.exception;

import com.aaron.framework.model.ReturnCodeEnum;

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
		this.code = ReturnCodeEnum.NETWORK_ERROR.getCode();
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
