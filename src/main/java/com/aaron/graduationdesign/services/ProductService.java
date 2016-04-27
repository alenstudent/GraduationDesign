package com.aaron.graduationdesign.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aaron.framework.dao.BaseDao;
import com.aaron.framework.model.Page;
import com.aaron.framework.service.AbstractService;
import com.aaron.framework.utils.NamespaceUtil;
import com.aaron.graduationdesign.daos.ProductDao;
import com.aaron.graduationdesign.models.Customer;
import com.aaron.graduationdesign.models.Product;

/**
 *<pre>
 * 对象功能:产品信息表 Service类
 * 开发人员:aaron
 * 创建时间:2016-04-27 00:04:20
 *</pre>
 */
@Service("productService")
public class ProductService extends AbstractService {
	@Resource(name="productDao")
	private ProductDao productDao;
	
	@Override
	public BaseDao getDao() {
		return this.productDao;
	}

	public List<Product> getCustomers(Page<Product> page) {
		Map<String, String> parameters = new HashMap<String, String>();
		return this.productDao.selectListBySqlIdAndParamWithPage(NamespaceUtil.getNamespace(Product.class, "getAllProducts"), parameters, page);
	}

	public void addProduct(Product product) {
		this.productDao.insertBySqlIdAndParam(NamespaceUtil.getNamespace(Product.class, "addProduct"), product);
		
	}
}
