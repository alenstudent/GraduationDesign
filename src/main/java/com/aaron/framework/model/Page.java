package com.aaron.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p>
 * Title: PageModel
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author aaron
 * @date 2016年3月4日 上午1:05:08
 */
public class Page<T> extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int currentPage;
	private int pageSize;
	private int startRow;
	private int endRow;
	private int totalCount;
	private int pageCount;
	private List<T> result = new ArrayList<T>();

	public Page(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.startRow = currentPage > 0 ? (currentPage - 1) * pageSize : 0;
		this.endRow = currentPage * pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setcCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
