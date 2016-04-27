package com.aaron.framework.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @version 创建时间 ：2016年3月15日 下午2:42:11
 * @author aaron Email: aaronhong0610@sina.com
 *         <p>
 *         类说明：返回实体类
 *         <p>
 */
public class ReturnModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态码（200-正常，500-异常，400-参数异常）
	 */
	private int code;
	/**
	 * 提示信息
	 */
	private String msg;
	/**
	 * 返回实体
	 */
	private Object body;
	/**
	 * 返回时间
	 */
	private Date date;
	/**
	 * 当前页数
	 */
	private int currentPage = 0;
	/**
	 * 分页记录数量大小
	 */
	private int pageSize = 0;
	/**
	 * 总页数
	 */
	private int pageCount = 0;
	/**
	 * 总记录数
	 */
	private int totalCount = 0;

	@SuppressWarnings("rawtypes")
	public ReturnModel(int code, String msg, Object body) {
		this.code = code;
		this.msg = msg;
		this.body = body;
		this.date = new Date();
		if (null != this.body) {
			if (this.body instanceof Collection) {
				Collection list = (Collection) body;
				this.pageSize = list.size();
				this.pageCount = 1;
				this.totalCount = list.size();
			} else if (this.body instanceof Map) {
				Map map = (Map) this.body;
				this.pageSize = map.size();
				this.pageCount = 1;
				this.totalCount = map.size();
			} else {
				this.pageSize = 1;
				this.pageCount = 1;
				this.totalCount = 1;
			}
		}
	}

	public ReturnModel(Object body) {
		this(200, "ok", body);
	}

	@SuppressWarnings("rawtypes")
	public ReturnModel(int code, String msg, Page page) {
		this.code = code;
		this.msg = msg;
		this.date = new Date();
		if (null != page) {
			this.body = page.getResult();
			this.currentPage = page.getCurrentPage();
			this.pageSize = page.getPageSize();
			this.pageCount = page.getPageCount();
			this.totalCount = page.getTotalCount();
		}
	}

	@SuppressWarnings("rawtypes")
	public ReturnModel(Page page) {
		this(200, "ok", page);
	}

	public ReturnModel(int code, String msg, Object body, int currentPage, int pageSize, int pageCount,
			int totalCount) {
		this.code = code;
		this.msg = msg;
		this.body = body;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.totalCount = totalCount;
		this.date = new Date();
	}

	public ReturnModel() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
