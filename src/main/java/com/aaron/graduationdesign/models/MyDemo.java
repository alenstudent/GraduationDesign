package com.aaron.graduationdesign.models;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.aaron.framework.model.BaseModel;

/**
 * 对象功能:my_demo Model对象
 * 开发人员:aaron
 * 创建时间:2016-04-28 17:07:55
 */
public class MyDemo extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	private String  id;
	/**
	 * 姓名
	 */
	private String  name;
	/**
	 * 年龄
	 */
	private Long  age;
	/**
	 * 薪水
	 */
	private Double  salary;

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
	 * 设置 姓名
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * 设置 年龄
	 * @return
	 */
	public void setAge(Long age) {
		this.age = age;
	}
	/**
	 * 返回 年龄
	 * @return
	 */
	public Long getAge() {
		return this.age;
	}
	/**
	 * 设置 薪水
	 * @return
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	/**
	 * 返回 薪水
	 * @return
	 */
	public Double getSalary() {
		return this.salary;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this); 
	}
   
  

}