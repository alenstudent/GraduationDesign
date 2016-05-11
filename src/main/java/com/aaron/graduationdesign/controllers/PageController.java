package com.aaron.graduationdesign.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.framework.controller.BaseController;

/**
*
* @author aaron Email: aaronhong0610@sina.com
* @verson 2016年4月29日 上午10:42:15
* 类说明：TODO
*/
@Controller
public class PageController extends BaseController {

	@RequestMapping("/{page}")
	public ModelAndView toPage(@PathVariable("page") String page) {
		ModelAndView mav = getJSPView(page);
		return mav;
	}
}
