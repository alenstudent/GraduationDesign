package com.aaron.graduationdesign.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aaron.framework.exception.UnLoginException;
import com.aaron.framework.utils.EhCacheUtil;
import com.aaron.graduationdesign.Utils.ContextUtil;

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
			if (null == cookies) cookies = new Cookie[]{};
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(EhCacheUtil.JSESSIONID_CACHE_NAME) 
						&& EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, cookie.getValue()) != null) {
					return true;
				}
			}
		}
		
		if (ContextUtil.isAjaxRequest()) {
			StringBuilder sBuilder = new StringBuilder("");
			sBuilder.append("{");
			sBuilder.append("\"uri\":" + request.getRequestURI() + ",");
			sBuilder.append("\"returnModel\":{")
			.append("\"code\":-1, \"msg\": \"未登录\", \"body\":\"未登录\", \"date\": null, \"currentPage\": 0, \"pageSize\": 0 ,\"pageCount\": 0,\"totalCount\":0");
			sBuilder.append("}");
			sBuilder.append("}");
			response.getWriter().write(sBuilder.toString());
		} else {
			response.sendRedirect(request.getContextPath() + "/user/login/page");
		}
		return false;
	}

}
