package com.aaron.graduationdesign.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/list/{currentPage}/{pageSize}")
	public ModelAndView getMyAllCustomers(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		ModelAndView mav = getJsonView();
		User user = ContextUtil.getUserFromRequest(request);
		Page<Customer> page = new Page<Customer>(currentPage, pageSize);
		List<Customer> customers = customerService.getCustomersBySaleId(user.getId(), page);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customers, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(reutrnModel);
		return mav;
	}
	
	@RequestMapping("/add/page")
	public ModelAndView toAddCustomerPage() {
		ModelAndView mav = getJSPView("addCustomerPage");
		return mav;
	}
	@RequestMapping("/add")
	public ModelAndView addCutomer(Customer customer, HttpServletRequest request) {
		ModelAndView mav = getJsonView();
		customer.setId(IDUtil.generateUUID());
		customer.setCusBelongTo(ContextUtil.getUserFromRequest(request).getId());
		customerService.addCustomer(customer);
		mav.addObject(new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customer));
		return mav;
	}
	
}
