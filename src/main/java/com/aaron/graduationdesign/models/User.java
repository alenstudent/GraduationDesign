package com.aaron.graduationdesign.models;


import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.aaron.framework.model.BaseModel;

/**
 *
 * @author aaron Email: aaronhong0610@sina.com
 * @verson 2016年4月25日 上午11:36:28 类说明：TODO
 */
public class User extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 *  主键
	 */
	private String id;
	/**
	 * 登录用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 用户类型 （1管理员，2销售人员）
	 */
	private String userType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
