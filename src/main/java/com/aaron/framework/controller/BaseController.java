package com.aaron.framework.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.framework.exception.BaseException;
import com.aaron.framework.exception.UnLoginException;
import com.aaron.framework.model.ReturnModel;
import com.aaron.graduationdesign.Utils.ContextUtil;


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
		ModelAndView mav = this.getJsonView();
		mav.addObject("code", "500");
		mav.addObject("msg", e.getMessage());
		mav.addObject("detail", e);
		return mav;
	}
	/**
	 * 捕获绑定异常
	 * @param e 绑定异常
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	protected ModelAndView handlderBinException(BindException e) {
		BindingResult resutl = e.getBindingResult();
		List<ObjectError> list = resutl.getAllErrors();
		StringBuilder sb = new StringBuilder();
		for (ObjectError error : list) {
			sb.append(error.getDefaultMessage()).append(",");
		}
		if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
		
		log.error(e.getMessage(), e);
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(400, "paramValidateErrors", sb.toString());
		mav.addObject(model);
		return mav;
	}
	@ExceptionHandler(BaseException.class)
	protected ModelAndView handlerInteceptorException(BaseException e) {
		log.error(e.getMessage(), e);
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(e.getCode(), "请求发生异常", e.getMsg());
		mav.addObject(model);
		return mav;
	}

	@ExceptionHandler(UnLoginException.class)
	protected ModelAndView handlerUnloginException(BaseException e) {
		log.error(e.getMessage(), e);
		ModelAndView mav = this.getJsonView();
		ReturnModel model = new ReturnModel(403, "请先登录", e.getMsg());
		mav.addObject(model);
		return mav;
	}
}

