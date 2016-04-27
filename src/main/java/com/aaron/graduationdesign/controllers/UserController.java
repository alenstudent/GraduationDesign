package com.aaron.graduationdesign.controllers;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.framework.controller.BaseController;
import com.aaron.framework.dao.IDUtil;
import com.aaron.framework.model.ReturnCodeEnum;
import com.aaron.framework.model.ReturnModel;
import com.aaron.framework.utils.EhCacheUtil;
import com.aaron.graduationdesign.models.User;
import com.aaron.graduationdesign.services.UserService;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年4月25日 上午11:48:59
* 类说明：TODO
*/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping("/register/page")
	public ModelAndView registerPage() {
		ModelAndView mav = getJSPView("register");
		return mav;
	}
	/**
	 * 注册用户
	 * @param userName 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping("/register/{userName}/{password}/{userType}")
	public ModelAndView register(@PathVariable("userName") String userName, @PathVariable("password") String password, @PathVariable("userType") String userType) {
		ModelAndView mav = getJsonView();
		User user = new User();
		user.setUserName(userName.toLowerCase());
		user.setPassword(password);
		user.setCreateTime(new Date());
		user.setNickName(userName);
		user.setId(IDUtil.generateUUID());
		user.setUserType(userType);
		mav.addObject(this.userService.registerUser(user));
		return mav;
	}
	
	
	@RequestMapping("/login/page")
	public ModelAndView loginPage() {
		ModelAndView mav = getJSPView("login");
		return mav;
	}
	
	
	@RequestMapping("/login/{userName}/{password2}")
	public ModelAndView login(@PathVariable("userName") String userName, @PathVariable("password2") String password, HttpServletRequest request) {
		ModelAndView mav = getJsonView();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		ReturnModel returnModel = this.userService.authenticatedUser(user);
		if (returnModel.getCode() == ReturnCodeEnum.SUCCESS.getCode()) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equalsIgnoreCase(EhCacheUtil.JSESSIONID_CACHE_NAME)) {
					User u = ((User)returnModel.getBody());
					EhCacheUtil.getInstance().put(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue(), u);	
					int index = 0;
					while (EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue()) == null) {
						if (index == 5) break;
						try {
							Thread.sleep(1000);
							index++;
						} catch (InterruptedException e) {
							log.error(e.getMessage(), e);;
						}
					}
				}
			}
		}
		mav.addObject(returnModel);
		return mav;
	}
	@RequestMapping("/sales/page")
	public ModelAndView toSalesPage() {
		ModelAndView mav = getJSPView("salesPage");
		return mav;
	}
	@RequestMapping("/admin/page")
	public ModelAndView toAdminPage() {
		ModelAndView mav = getJSPView("adminPage");
		return mav;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = getJsonView();
		ReturnModel rm = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), null);
		mav.addObject(rm);
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie:cookies) {
			if (cookie.getName().equalsIgnoreCase(EhCacheUtil.JSESSIONID_CACHE_NAME)) {
				EhCacheUtil.getInstance().remove(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue());
				break;
			}
		}
		return mav;
	}
}
