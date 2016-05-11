package com.aaron.graduationdesign.controllers;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.framework.controller.BaseController;
import com.aaron.framework.dao.IDUtil;
import com.aaron.framework.model.Page;
import com.aaron.framework.model.ReturnCodeEnum;
import com.aaron.framework.model.ReturnModel;

import com.aaron.graduationdesign.models.MyDemo;
import com.aaron.graduationdesign.services.MyDemoService;


 /**
 * @author aaron Email: aaronhong0610@sina.com
 * @version 创建时间 ：2016年-04月-28日 17:07:55
 * 类说明：
 */
@Controller
@RequestMapping("/myDemo/")
public class MyDemoController extends BaseController
{
	@Resource(name="myDemoService")
	private MyDemoService myDemoService;
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("/add/page")
	public ModelAndView toAddPage() {
		ModelAndView mav = getJSPView("myDemo/add");
		return mav;
	}
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list/page")
	public ModelAndView toListPage() {
		ModelAndView mav = getJSPView("myDemo/list");
		return mav;
	}
	/**
	 * 跳转到详情页面
	 */
	@RequestMapping("/info/page")
	public ModelAndView toInfoPage(String id) {
		ModelAndView mav = getJSPView("myDemo/info");
		MyDemo myDemo = this.myDemoService.Info(id, MyDemo.class);
		if (null != myDemo) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(myDemo));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), id));
		}
		return mav;
	}
	/**
	 * 跳转到编辑页面
	 */
	@RequestMapping("/edit/page")
	public ModelAndView toEditPage(String id) {
		ModelAndView mav = getJSPView("myDemo/edit");
		MyDemo myDemo = this.myDemoService.Info(id, MyDemo.class);
		if (null != myDemo) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(myDemo));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), id));
		}
		return mav;
	}
	/**
	 * 请求分页数据操作
	 * @param currentPage 当前页
	 * @param pageSize 页面大小
	 */
	@RequestMapping("/list")
	public ModelAndView list(int currentPage, int pageSize) {
		ModelAndView mav = getJsonView();
		Page<MyDemo> page = new Page<MyDemo>(currentPage, pageSize);
		List<MyDemo> myDemos = myDemoService.list(page, MyDemo.class);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), myDemos, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(RETURN_MODEL_KEY, reutrnModel);
		return mav;
	}
	
	/**
	 * 添加数据操作
	 * @param myDemo 添加实体
	 */
	@RequestMapping("/insert")
	public ModelAndView insert(MyDemo myDemo) {
		ModelAndView mav = getJsonView();
		myDemo.setId(IDUtil.generateUUID());
		this.myDemoService.insert(myDemo);
		mav.addObject(RETURN_MODEL_KEY, new ReturnModel(myDemo));
		return mav;
	}
	/**
	 * 更新数据操作
	 * @param myDemo 更新实体
	 */
	@RequestMapping("/update")
	public ModelAndView update(MyDemo myDemo) {
		ModelAndView mav = getJsonView();
		int affected = this.myDemoService.update(myDemo);
		if (affected > 0) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(myDemo));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), myDemo));
		}
		return mav;
	}
	/**
	 * 删除数据操作
	 * @param ids 删除实体主键数组
	 */
	@RequestMapping("/del")
	public ModelAndView del(String[] ids) {
		ModelAndView mav = getJsonView();
		int affectedCount = this.myDemoService.delete(Arrays.asList(ids), MyDemo.class);
		if (affectedCount > 0) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ids));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), ids));
		}
		return mav;
	}
	
	// ----------- 自定义的方法------------
	
}
