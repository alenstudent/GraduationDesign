package com.aaron.graduationdesign.controllers;

import java.util.Arrays;
import java.util.Date;
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
import com.aaron.framework.utils.NamespaceUtil;
import com.aaron.graduationdesign.Utils.ContextUtil;
import com.aaron.graduationdesign.models.Customer;
import com.aaron.graduationdesign.models.Product;
import com.aaron.graduationdesign.models.User;
import com.aaron.graduationdesign.services.CustomerService;
import com.aaron.graduationdesign.services.ProductService;


 /**
 * @author aaron Email: aaronhong0610@sina.com
 * @version 创建时间 ：2016年-04月-28日 17:17:40
 * 类说明：
 */
@Controller
@RequestMapping("/customer/")
public class CustomerController extends BaseController
{
	@Resource(name="customerService")
	private CustomerService customerService;
	@Resource(name="productService")
	private ProductService productService;
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("/add/page")
	public ModelAndView toAddPage() {
		ModelAndView mav = getJSPView("customer/add");
		return mav;
	}
	/**
	 * 跳转到列表页面
	 */
	@RequestMapping("/list/page")
	public ModelAndView toListPage() {
		ModelAndView mav = getJSPView("customer/list");
		return mav;
	}
	/**
	 * 跳转到详情页面
	 */
	@RequestMapping("/info/page")
	public ModelAndView toInfoPage(String id) {
		ModelAndView mav = getJSPView("customer/info");
		Customer customer = this.customerService.Info(id, Customer.class);
		if (null != customer) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
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
		ModelAndView mav = getJSPView("customer/edit");
		Customer customer = this.customerService.Info(id, Customer.class);
		if (null != customer) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
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
		Page<Customer> page = new Page<Customer>(currentPage, pageSize);
		String currentUserId = ContextUtil.getCurrentUserId();
//		List<Customer> customers = customerService.list(page, Customer.class);
		List<Customer>customers = this.customerService.selectListBySqlIdAndParamWithPage(NamespaceUtil.getNamespace(Customer.class, "list"), currentUserId, page);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customers, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(RETURN_MODEL_KEY, reutrnModel);
		return mav;
	}
	
	/**
	 * 添加数据操作
	 * @param customer 添加实体
	 */
	@RequestMapping("/insert")
	public ModelAndView insert(Customer customer) {
		ModelAndView mav = getJsonView();
		customer.setId(IDUtil.generateUUID());
		customer.setCreateTime(new Date());
		customer.setUpdateTime(new Date());
		customer.setCusBelongTo(ContextUtil.getUserFromContext().getId());
		this.customerService.insert(customer);
		mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
		return mav;
	}
	/**
	 * 更新数据操作
	 * @param customer 更新实体
	 */
	@RequestMapping("/update")
	public ModelAndView update(Customer customer) {
		ModelAndView mav = getJsonView();
		customer.setUpdateTime(new Date());
		int affected = this.customerService.update(customer);
		if (affected > 0) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(customer));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), customer));
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
		int affectedCount = this.customerService.delete(Arrays.asList(ids), Customer.class);
		if (affectedCount > 0) {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ids));
		} else {
			mav.addObject(RETURN_MODEL_KEY, new ReturnModel(ReturnCodeEnum.NETWORK_ERROR.getCode(), ReturnCodeEnum.NETWORK_ERROR.getTips(), ids));
		}
		return mav;
	}
	
	// ----------- 自定义的方法------------
	
	@RequestMapping("/list/product/page")
	public ModelAndView toProductListPage() {
		ModelAndView mav = getJSPView("customer/productList");
		return mav;
	}
	@RequestMapping("/list/product")
	public ModelAndView listProduct(int currentPage, int pageSize) {
		ModelAndView mav = getJsonView();
		Page<Product> page = new Page<Product>(currentPage, pageSize);
		User currentUser = ContextUtil.getUserFromContext();
//		List<Product> products = productService.list(page, Product.class);
		List<Product> products = this.productService.selectListBySqlIdAndParamWithPage(NamespaceUtil.getNamespace(Product.class, "listAllProduct"), currentUser.getId(), page);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), products, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(RETURN_MODEL_KEY, reutrnModel);
		return mav;
	}
}
