package com.aaron.framework.model;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年4月25日 下午2:39:28
* 类说明：TODO
*/
public enum ReturnCodeEnum {
	SUCCESS(200, "成功"), NETWORK_ERROR(500, "网络繁忙"), PARAM_ERROR(400, "参数异常");
	
	private int code;
	private String tips;
	private ReturnCodeEnum(int code, String tips) {
		this.code = code;
		this.tips = tips;
	}
	
	public int getCode() {
		return this.code;
	}
	public String getTips() {
		return this.tips;
	}
	
}
