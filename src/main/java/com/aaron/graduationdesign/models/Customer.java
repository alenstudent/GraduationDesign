package com.aaron.graduationdesign.models;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.aaron.framework.model.BaseModel;

/**
 * 对象功能:客户信息表 Model对象
 * 开发人员:aaron
 * 创建时间:2016-04-28 17:17:40
 */
public class Customer extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String  id;
	/**
	 * 客户名称
	 */
	private String  cusName;
	/**
	 * 联系地址
	 */
	private String  cusAddress;
	/**
	 * 邮编
	 */
	private String  cusZipCode;
	/**
	 * 联系电话
	 */
	private String  cusPhone;
	/**
	 * 联系人员
	 */
	private String  cusBelongTo;
	/**
	 * 纳税号码
	 */
	private String  cusTaxNum;
	/**
	 * 开户银行账号
	 */
	private String  cusBankAccount;
	/**
	 * 开户银行名称
	 */
	private String  cusBankName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

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
	 * 设置 客户名称
	 * @return
	 */
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	/**
	 * 返回 客户名称
	 * @return
	 */
	public String getCusName() {
		return this.cusName;
	}
	/**
	 * 设置 联系地址
	 * @return
	 */
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	/**
	 * 返回 联系地址
	 * @return
	 */
	public String getCusAddress() {
		return this.cusAddress;
	}
	/**
	 * 设置 邮编
	 * @return
	 */
	public void setCusZipCode(String cusZipCode) {
		this.cusZipCode = cusZipCode;
	}
	/**
	 * 返回 邮编
	 * @return
	 */
	public String getCusZipCode() {
		return this.cusZipCode;
	}
	/**
	 * 设置 联系电话
	 * @return
	 */
	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getCusPhone() {
		return this.cusPhone;
	}
	/**
	 * 设置 联系人员
	 * @return
	 */
	public void setCusBelongTo(String cusBelongTo) {
		this.cusBelongTo = cusBelongTo;
	}
	/**
	 * 返回 联系人员
	 * @return
	 */
	public String getCusBelongTo() {
		return this.cusBelongTo;
	}
	/**
	 * 设置 纳税号码
	 * @return
	 */
	public void setCusTaxNum(String cusTaxNum) {
		this.cusTaxNum = cusTaxNum;
	}
	/**
	 * 返回 纳税号码
	 * @return
	 */
	public String getCusTaxNum() {
		return this.cusTaxNum;
	}
	/**
	 * 设置 开户银行账号
	 * @return
	 */
	public void setCusBankAccount(String cusBankAccount) {
		this.cusBankAccount = cusBankAccount;
	}
	/**
	 * 返回 开户银行账号
	 * @return
	 */
	public String getCusBankAccount() {
		return this.cusBankAccount;
	}
	/**
	 * 设置 开户银行名称
	 * @return
	 */
	public void setCusBankName(String cusBankName) {
		this.cusBankName = cusBankName;
	}
	/**
	 * 返回 开户银行名称
	 * @return
	 */
	public String getCusBankName() {
		return this.cusBankName;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
   
  

}