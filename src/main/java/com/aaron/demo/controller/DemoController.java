package com.aaron.demo.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.demo.model.Demo;
import com.aaron.demo.service.DemoService;
import com.aaron.framework.controller.BaseController;
import com.aaron.framework.model.Page;
import com.aaron.framework.model.ReturnModel;
import com.aaron.framework.model.Sexy;
import com.aaron.framework.utils.EhCacheUtil;

/**
 * <p>Title: DemoController</p>
 * <p>Description:</p>
 * @author aaron
 * @date 2016年3月3日 下午8:49:55
 */
@Controller
@RequestMapping("demo")
public class DemoController extends BaseController {

	@Resource(name = "demoService")
	private DemoService demoService;
	
	
	@RequestMapping("/helloworld/json")
	public ModelAndView helloWorld() {
		ModelAndView modelAndView = getJsonView();
		modelAndView.addObject("hello", "hello world");
		return modelAndView;
	}
	
	@RequestMapping("/helloworld/jsp")
	public ModelAndView helloWorld2() {
		ModelAndView modelAndView = getJSPView("helloworld");
		modelAndView.addObject("hello", "hello world");
		return modelAndView;
	}
	@RequestMapping("/add")
	public ModelAndView saveUser(@Valid Demo demo) {
		log.debug(demo.toString());
		ModelAndView mav = getJsonView();
		return mav;
	}
	@RequestMapping("/add/cache")
	public ModelAndView saveCache() {
		EhCacheUtil.getInstance().put(EhCacheUtil.JSESSIONID_CACHE_NAME, "abc", "abc");
		String cacheValue = (String) EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, "abc");
		ModelAndView modelAndView = getJsonView();
		modelAndView.addObject(cacheValue);
		return modelAndView;
	}
	
	@RequestMapping("/update/cache")
	public ModelAndView updateCache() {
		EhCacheUtil.getInstance().put(EhCacheUtil.JSESSIONID_CACHE_NAME, "abc", "abcd");
		ModelAndView modelAndView = getJsonView();
		return modelAndView;
	}

	
	@RequestMapping("/get/cache")
	public ModelAndView getCache() {
		String cacheValue = (String) EhCacheUtil.getInstance().get(EhCacheUtil.JSESSIONID_CACHE_NAME, "abc");
		ModelAndView modelAndView = getJsonView();
		modelAndView.addObject(cacheValue);
		return modelAndView;
	}
	
	@RequestMapping("/add/demo/100")
	public ModelAndView addUser() {
		ModelAndView modelAndView = getJsonView();
//		this.demoService.insert100Demo();
//		ReturnModel returnModel = new ReturnModel(null);
//		modelAndView.addObject(returnModel);
		return modelAndView;
	}
	
	@RequestMapping("/update/demo")
	public ModelAndView updateDemo() {
		EhCacheUtil.getInstance().put(EhCacheUtil.JSESSIONID_CACHE_NAME, "abc", "abcd");
		ModelAndView modelAndView = getJsonView();
		return modelAndView;
	}

	
	@RequestMapping("/get/demo")
	public ModelAndView getDemo() {
		String uniqueId = "402897e95382ab79015382aba94f0000";
		ModelAndView modelAndView = getJsonView();
		return modelAndView;
	}
	@RequestMapping("/list/demo")
	public ModelAndView listDemo() {
		ModelAndView maView = getJsonView();
//		Page<Demo> page = new Page<Demo>(currentPage, pageSize);
//		this.demoService.selectListBySqlIdAndParamWithPage("selectDemo", null, page);
//		ReturnModel rModel = new ReturnModel(page);
//		maView.addObject(rModel);
		return maView;
	}
	
}

