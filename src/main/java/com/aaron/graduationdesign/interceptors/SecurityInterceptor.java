package com.aaron.graduationdesign.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aaron.framework.exception.UnKnowException;
import com.aaron.framework.exception.UnLoginException;
import com.aaron.framework.utils.EhCacheUtil;

/**
 * 
 * @author aaron Email: aaronhong0610@sina.com
 *
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.debug("requestURI: " + request.getRequestURI());
		String accessToken = request.getHeader("accessToken");
		if (StringUtils.isBlank(accessToken)) {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				log.debug("cookie.name:" + cookie.getName() + ",cookie.value:" + cookie.getValue());
				if (cookie.getName().equals(EhCacheUtil.JSESSIONID_CACHE_NAME) 
						&& EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue()) != null) {
					return true;
				}
			}
			throw new UnLoginException("获取不到头部accessToken字段");
		}
		if (null == EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, accessToken)) {
			throw new UnLoginException("用户未登录");
		}
		return true;
	}

}
