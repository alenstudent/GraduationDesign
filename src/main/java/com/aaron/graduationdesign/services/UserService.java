package com.aaron.graduationdesign.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.model.ReturnCodeEnum;
import com.aaron.framework.model.ReturnModel;
import com.aaron.framework.service.AbstractService;
import com.aaron.framework.utils.NamespaceUtil;
import com.aaron.graduationdesign.daos.UserDao;
import com.aaron.graduationdesign.models.User;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年4月25日 上午11:51:01
* 类说明：TODO
*/
@Service("userService")
public class UserService extends AbstractService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	public BaseDao getDao() {
		return this.userDao;
	}
	
	public ReturnModel registerUser(User user) {
		// 1检查用户是否已经注册过
		User cacheUser = this.userDao.selectUniqueOneBySqlIdAndParam(NamespaceUtil.getNamespace(User.class, "getUserByUserName"), user);
		if (cacheUser != null) {
			return new ReturnModel(ReturnCodeEnum.PARAM_ERROR.getCode(), "用户已经被注册", user);
		} else {
			this.userDao.insertBySqlIdAndParam("saveUser", user);
			return new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), user);
		}
	}

	public ReturnModel authenticatedUser(User user) {
		User cacheUser = this.userDao.selectUniqueOneBySqlIdAndParam(NamespaceUtil.getNamespace(User.class, "getUserByUserName"), user);
		ReturnModel returnModel = new ReturnModel();
		if (null == cacheUser) {
			returnModel.setCode(ReturnCodeEnum.PARAM_ERROR.getCode());
			returnModel.setMsg("用户名或密码错误");
			returnModel.setBody(user);
		} else {
			if (!cacheUser.getPassword().equals(user.getPassword())) {
				returnModel.setCode(ReturnCodeEnum.PARAM_ERROR.getCode());
				returnModel.setMsg("用户名或密码错误");
				returnModel.setBody(user);
			} else {
				returnModel.setCode(ReturnCodeEnum.SUCCESS.getCode());
				returnModel.setMsg(ReturnCodeEnum.SUCCESS.getTips());
				returnModel.setBody(cacheUser);
			}
		}
		return returnModel;
	}

}
