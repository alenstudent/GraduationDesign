package com.aaron.graduationdesign.models;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.aaron.framework.model.BaseModel;

/**
 * 对象功能:产品信息表 Model对象
 * 开发人员:aaron
 * 创建时间:2016-04-27 00:04:20
 */
public class Product extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String  id;
	/**
	 * 产品编号
	 */
	private String  proNum;
	/**
	 * 产品名称
	 */
	private String  proName;
	/**
	 * 规格型号
	 */
	private String  proGgxh;
	/**
	 * 计量单位
	 */
	private String  proUnion;
	/**
	 * 累计销售量
	 */
	private Long  proTotalSaleCount;
	/**
	 * 当前库存
	 */
	private Long  proCurrentStock;
	/**
	 * 建议销售价
	 */
	private Double  proAdviceSalePrice;
	/**
	 * 生产厂商
	 */
	private String  proManufacturer;
	/**
	 * 创建时间
	 */
	private java.util.Date  proCraeteTime;
	/**
	 * 更新时间
	 */
	private java.util.Date  proUpdateTime;
	/**
	 * 更新人
	 */
	private String  proUpdateUser;

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
	 * 设置 产品编号
	 * @return
	 */
	public void setProNum(String proNum) {
		this.proNum = proNum;
	}
	/**
	 * 返回 产品编号
	 * @return
	 */
	public String getProNum() {
		return this.proNum;
	}
	/**
	 * 设置 产品名称
	 * @return
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * 返回 产品名称
	 * @return
	 */
	public String getProName() {
		return this.proName;
	}
	/**
	 * 设置 规格型号
	 * @return
	 */
	public void setProGgxh(String proGgxh) {
		this.proGgxh = proGgxh;
	}
	/**
	 * 返回 规格型号
	 * @return
	 */
	public String getProGgxh() {
		return this.proGgxh;
	}
	/**
	 * 设置 计量单位
	 * @return
	 */
	public void setProUnion(String proUnion) {
		this.proUnion = proUnion;
	}
	/**
	 * 返回 计量单位
	 * @return
	 */
	public String getProUnion() {
		return this.proUnion;
	}
	/**
	 * 设置 累计销售量
	 * @return
	 */
	public void setProTotalSaleCount(Long proTotalSaleCount) {
		this.proTotalSaleCount = proTotalSaleCount;
	}
	/**
	 * 返回 累计销售量
	 * @return
	 */
	public Long getProTotalSaleCount() {
		return this.proTotalSaleCount;
	}
	/**
	 * 设置 当前库存
	 * @return
	 */
	public void setProCurrentStock(Long proCurrentStock) {
		this.proCurrentStock = proCurrentStock;
	}
	/**
	 * 返回 当前库存
	 * @return
	 */
	public Long getProCurrentStock() {
		return this.proCurrentStock;
	}
	/**
	 * 设置 建议销售价
	 * @return
	 */
	public void setProAdviceSalePrice(Double proAdviceSalePrice) {
		this.proAdviceSalePrice = proAdviceSalePrice;
	}
	/**
	 * 返回 建议销售价
	 * @return
	 */
	public Double getProAdviceSalePrice() {
		return this.proAdviceSalePrice;
	}
	/**
	 * 设置 生产厂商
	 * @return
	 */
	public void setProManufacturer(String proManufacturer) {
		this.proManufacturer = proManufacturer;
	}
	/**
	 * 返回 生产厂商
	 * @return
	 */
	public String getProManufacturer() {
		return this.proManufacturer;
	}
	/**
	 * 设置 创建时间
	 * @return
	 */
	public void setProCraeteTime(java.util.Date proCraeteTime) {
		this.proCraeteTime = proCraeteTime;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getProCraeteTime() {
		return this.proCraeteTime;
	}
	/**
	 * 设置 更新时间
	 * @return
	 */
	public void setProUpdateTime(java.util.Date proUpdateTime) {
		this.proUpdateTime = proUpdateTime;
	}
	/**
	 * 返回 更新时间
	 * @return
	 */
	public java.util.Date getProUpdateTime() {
		return this.proUpdateTime;
	}
	/**
	 * 设置 更新人
	 * @return
	 */
	public void setProUpdateUser(String proUpdateUser) {
		this.proUpdateUser = proUpdateUser;
	}
	/**
	 * 返回 更新人
	 * @return
	 */
	public String getProUpdateUser() {
		return this.proUpdateUser;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
   
  

}