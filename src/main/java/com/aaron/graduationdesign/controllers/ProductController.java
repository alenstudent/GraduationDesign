package com.aaron.graduationdesign.controllers;

import java.util.Date;
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
import com.aaron.graduationdesign.models.Product;
import com.aaron.graduationdesign.models.User;
import com.aaron.graduationdesign.services.CustomerService;
import com.aaron.graduationdesign.services.ProductService;



/**
 * @author aaron Email: aaronhong0610@sina.com
 * @version 创建时间 ：2016年4月27日 上午12:42:59
 * 类说明：
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Resource(name = "productService")
	private ProductService productService;
	
	@RequestMapping("/list/{currentPage}/{pageSize}")
	public ModelAndView getAllProducts(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize, HttpServletRequest request) {
		ModelAndView mav = getJsonView();
		Page<Product> page = new Page<Product>(currentPage, pageSize);
		List<Product> customers = productService.getCustomers(page);
		ReturnModel reutrnModel = new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), customers, currentPage, pageSize, page.getPageCount(), page.getTotalCount());
		mav.addObject(reutrnModel);
		return mav;
	}
	
	@RequestMapping("/add/page")
	public ModelAndView toAddProductPage() {
		ModelAndView mav = getJSPView("addProductPage");
		return mav;
	}
	@RequestMapping("/add")
	public ModelAndView addProduct(Product product, HttpServletRequest request) {
		ModelAndView mav = getJsonView();
		product.setId(IDUtil.generateUUID());
		product.setProCraeteTime(new Date());
		product.setProUpdateTime(new Date());
		product.setProUpdateUser(ContextUtil.getUserFromRequest(request).getId());
		productService.addProduct(product);
		mav.addObject(new ReturnModel(ReturnCodeEnum.SUCCESS.getCode(), ReturnCodeEnum.SUCCESS.getTips(), product));
		return mav;
	}
	
}
