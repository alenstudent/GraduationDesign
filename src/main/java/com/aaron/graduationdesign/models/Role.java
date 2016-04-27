package com.aaron.graduationdesign.models;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.aaron.framework.model.BaseModel;

/**
 * 对象功能:角色表 Model对象
 * 开发人员:aaron
 * 创建时间:2016-04-26 00:24:02
 */
public class Role extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String  id;
	/**
	 * 角色名称
	 */
	private String  RName;
	/**
	 * 创建时间
	 */
	private java.util.Date  RCreateTime;

	/**
	 * 设置 主键
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * 设置 角色名称
	 * @return
	 */
	public void setRName(String RName) {
		this.RName = RName;
	}
	/**
	 * 返回 角色名称
	 * @return
	 */
	public String getRName() {
		return this.RName;
	}
	/**
	 * 设置 创建时间
	 * @return
	 */
	public void setRCreateTime(java.util.Date RCreateTime) {
		this.RCreateTime = RCreateTime;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getRCreateTime() {
		return this.RCreateTime;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
   
  

}