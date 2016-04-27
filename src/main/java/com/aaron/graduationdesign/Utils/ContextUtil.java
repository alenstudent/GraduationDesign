package com.aaron.graduationdesign.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aaron.framework.exception.UnLoginException;
import com.aaron.framework.utils.EhCacheUtil;
import com.aaron.graduationdesign.models.User;



/**
 * @author aaron Email: aaronhong0610@sina.com
 * @version 创建时间 ：2016年4月27日 上午12:46:39
 * 类说明：
 */
public class ContextUtil {

	public static User getUserFromContext() {
		HttpServletRequest request = getRequestFromContext();
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase(EhCacheUtil.JSESSIONID_CACHE_NAME)) {
				return (User) EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue());
			}
		}
		throw new UnLoginException("用户未登录");
	}
	public static HttpServletRequest getRequestFromContext() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
}
