package com.aaron.framework.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.framework.exception.BaseException;
import com.aaron.framework.exception.ForbiddenException;
import com.aaron.framework.exception.UnLoginException;
import com.aaron.framework.model.ReturnCodeEnum;
import com.aaron.framework.model.ReturnModel;
import com.aaron.graduationdesign.Utils.ContextUtil;
import com.mysql.jdbc.log.LogUtils;


/**
 * <p>Title: BaseController</p>
 * <p>Description:</p>
 * @author aaron
 * @date 2016年3月3日 下午8:49:37
 */
public abstract class BaseController {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	protected final String RETURN_MODEL_KEY = "returnModel";
	protected final String URI_KEYString = "uri";
	protected ModelAndView getJsonView() {
		ModelAndView mav = new ModelAndView("json");
		mav.addObject(URI_KEYString, ContextUtil.getRequestFromContext().getRequestURI());
		return mav;
	}
	
	protected ModelAndView getJSPView(String jspViewName) {
		ModelAndView mav = new ModelAndView(jspViewName);
		mav.addObject(URI_KEYString, ContextUtil.getRequestFromContext().getRequestURI());
		return mav;
	}
	/**
	 * 捕获运行时异常
	 * @param e 运行时异常
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	protected ModelAndView handlerException(RuntimeException e) {
		log.error(e.getMessage(), e);
		if (!ContextUtil.isAjaxRequest()) { return returnErrorPage(ReturnCodeEnum.NETWORK_ERROR); }
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), e.getMessage());
		mav.addObject(RETURN_MODEL_KEY, model);
		return mav;
	}
	/**
	 * 捕获绑定异常
	 * @param e 绑定异常
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	protected ModelAndView handlderBinException(BindException e) {
		log.error(e.getMessage(), e);
		if (!ContextUtil.isAjaxRequest()) { return returnErrorPage(ReturnCodeEnum.PARAM_ERROR); }
		BindingResult resutl = e.getBindingResult();
		List<ObjectError> list = resutl.getAllErrors();
		StringBuilder sb = new StringBuilder();
		for (ObjectError error : list) {
			sb.append(error.getDefaultMessage()).append(",");
		}
		if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(ReturnCodeEnum.PARAM_ERROR.getCode(), ReturnCodeEnum.PARAM_ERROR.getTips(), sb.toString());
		mav.addObject(RETURN_MODEL_KEY, model);
		return mav;
	}
	/**
	 * 捕捉到自定义异常的处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BaseException.class)
	protected ModelAndView handlerBaseException(BaseException e) {
		log.error(e.getMessage(), e);
		if (!ContextUtil.isAjaxRequest()) { return returnErrorPage(ReturnCodeEnum.NETWORK_ERROR); }
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), e.getMsg());
		mav.addObject(RETURN_MODEL_KEY, model);
		return mav;
	}

	/**
	 * 没有登录的处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(UnLoginException.class)
	protected ModelAndView handlerUnloginException(UnLoginException e) {
		log.error(e.getMessage(), e);
		if (!ContextUtil.isAjaxRequest()) { return returnErrorPage(ReturnCodeEnum.UNLOGIN); }
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(ReturnCodeEnum.UNLOGIN.getCode(), ReturnCodeEnum.UNLOGIN.getTips(), e.getMsg());
		mav.addObject(RETURN_MODEL_KEY, model);
		return mav;
	}
	/**
	 * 没有权限的处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ForbiddenException.class)
	protected ModelAndView handlerForbiddenException(ForbiddenException e) {
		log.error(e.getMessage(), e);
		if (!ContextUtil.isAjaxRequest()) { return returnErrorPage(ReturnCodeEnum.FORBIDDEN); }
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(ReturnCodeEnum.FORBIDDEN.getCode(), ReturnCodeEnum.FORBIDDEN.getTips(), e.getMsg());
		mav.addObject(RETURN_MODEL_KEY, model);
		return mav;
	}
	
	private ModelAndView returnErrorPage(ReturnCodeEnum returnCodeNum) {
		log.debug("code: " + returnCodeNum.getCode());
		ModelAndView mav = this.getJSPView("redirect:/" + returnCodeNum.getCode());
		ReturnModel returnModel = new ReturnModel(returnCodeNum.getCode(), returnCodeNum.getTips(), returnCodeNum.getTips());
		mav.addObject(RETURN_MODEL_KEY, returnModel);
		return mav;
	}
}

