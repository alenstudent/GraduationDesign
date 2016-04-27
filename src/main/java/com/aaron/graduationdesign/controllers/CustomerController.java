package com.aaron.graduationdesign.controllers;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aaron.framework.controller.BaseController;
import com.aaron.framework.dao.IDUtil;
import com.aaron.framework.model.Page;
import com.aaron.framework.model.ReturnCodeEnum;
import com.aaron.framework.model.ReturnModel;
import com.aaron.graduationdesign.Utils.ContextUtil;
import com.aaron.graduationdesign.models.Customer;
import com.aaron.graduationdesign.models.User;
import com.aaron.graduationdesign.services.CustomerService;



/**
 * @author aaron Email: aaronhong0610@sina.com
 * @version 创建时间 ：2016年4月27日 上午12:42:59
 * 类说明：
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

	@Resource(name = "customerService")
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public ModelAndView list(int currentPage, int pageSize) {
		ModelAndView mav = getJSPView("customer/list");
		Page<Customer> page = new Page<Customer>(currentPage, pageSize);
		List<Customer> customers = customerService.list(page);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customers, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(RETURN_MODEL_KEY, reutrnModel);
		return mav;
	}
	
	@RequestMapping("/add/page")
	public ModelAndView addPage() {
		ModelAndView mav = getJSPView("customer/add");
		return mav;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(Customer customer) {
		ModelAndView mav = getJsonView();
		customer.setId(IDUtil.generateUUID());
		this.customerService.insert(customer);
		mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView update(Customer customer) {
		ModelAndView mav = getJsonView();
		int affected = this.customerService.update(customer);
		if (affected > 0) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), customer));
		}
		return mav;
	}
	@RequestMapping("/info")
	public ModelAndView Info(String id) {
		ModelAndView mav = getJSPView("customer/info");
		Customer customer = this.customerService.Info(id, Customer.class);
		if (null != customer) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), id));
		}
		return mav;
	}
	@RequestMapping("/del")
	public ModelAndView del(String[] ids) {
		ModelAndView mav = getJsonView();
		int affectedCount = this.customerService.delete(Arrays.asList(ids), Customer.class);
		if (affectedCount > 0) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ids));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), ids));
		}
		return mav;
	}
	
	@RequestMapping("/list")
	public ModelAndView lists(int currentPage, int pageSize) {
		ModelAndView mav = getJsonView();
		User user = ContextUtil.getUserFromContext();
		Page<Customer> page = new Page<Customer>(currentPage, pageSize);
		List<Customer> customers = customerService.getCustomersBySaleId(user.getId(), page);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customers, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(RETURN_MODEL_KEY, reutrnModel);
		return mav;
	}
	
	@RequestMapping("/add/page")
	public ModelAndView toAddCustomerPage() {
		ModelAndView mav = getJSPView("addCustomerPage");
		return mav;
	}
	@RequestMapping("/add")
	public ModelAndView addCutomer(Customer customer) {
		ModelAndView mav = getJsonView();
		customer.setId(IDUtil.generateUUID());
		customer.setCusBelongTo(ContextUtil.getUserFromContext().getId());
		customerService.addCustomer(customer);
		mav.addObject(new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customer));
		return mav;
	}
	
}
