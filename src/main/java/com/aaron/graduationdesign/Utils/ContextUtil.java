package com.aaron.graduationdesign.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.aaron.framework.exception.UnLoginException;
import com.aaron.framework.utils.EhCacheUtil;
import com.aaron.graduationdesign.models.User;



/**
 * @author aaron Email: aaronhong0610@sina.com
 * @version 创建时间 ：2016年4月27日 上午12:46:39
 * 类说明：
 */
public class ContextUtil {

	static public User getUserFromRequest(HttpServletRequest request) {
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase(EhCacheUtil.JSESSIONID_CACHE_NAME)) {
				return (User) EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue());
			}
		}
		throw new UnLoginException("用户未登录");
	}
}
